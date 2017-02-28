package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Coincidencia;
import domain.PlazaPropia;
import domain.ZonaDeseada;
import forms.GoogleMapCircle;
import repositories.ZonaDeseadaRepository;
import security.UserAccount;

@Service
@Transactional
public class ZonaDeseadaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ZonaDeseadaRepository zonaDeseadaRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private PlazaPropiaService plazaPropiaService;

	@Autowired
	private UsuarioService usuarioService;

	// Constructors -----------------------------------------------------------

	public ZonaDeseadaService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public ZonaDeseada create() {
		ZonaDeseada result;

		result = new ZonaDeseada();

		return result;
	}

	public ZonaDeseada findOne(String zonaDeseadaId) {
		Assert.notNull(zonaDeseadaId);

		ZonaDeseada result;

		result = zonaDeseadaRepository.findOne(zonaDeseadaId);

		return result;

	}

	public Collection<ZonaDeseada> findAll() {

		Collection<ZonaDeseada> result;

		result = zonaDeseadaRepository.findAll();

		return result;
	}

	public void save(ZonaDeseada zonaDeseada) {
		Assert.notNull(zonaDeseada);

		zonaDeseadaRepository.save(zonaDeseada);
	}

	public void delete(ZonaDeseada zonaDeseada) {
		Assert.notNull(zonaDeseada);

		zonaDeseadaRepository.delete(zonaDeseada);

	}

	// Other business methods -------------------------------------------------

	public Collection<ZonaDeseada> findAllByPrincipal() {
		Collection<ZonaDeseada> res;
		Collection<ZonaDeseada> todas;
		UserAccount userAccount;
		String id;

		res = new ArrayList<ZonaDeseada>();
		todas = findAll();
		userAccount = usuarioService.findPrincipal();
		id = userAccount.getId();
		for (ZonaDeseada z : todas) {
			if (z.getUsuarioId().equals(id)) {
				res.add(z);
			}
		}

		return res;
	}

	public Collection<ZonaDeseada> reconstruct(GoogleMapCircle[] circles) {
		Collection<ZonaDeseada> res;

		res = new ArrayList<ZonaDeseada>();

		for (int i = 0; i < circles.length; i++) {
			ZonaDeseada z = create();
			z.setLatitud(circles[i].getLatitude());
			z.setLongitud(circles[i].getLongitude());
			z.setRadio(circles[i].getRadius());
			z.setUsuarioId(usuarioService.findPrincipal().getId());

			save(z);
			res.add(z);
		}
		return res;
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		final int R = 6371; // Radius of the earth

		Double latDistance = Math.toRadians(lat2 - lat1);
		Double lonDistance = Math.toRadians(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = 0.0;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

	public Collection<Coincidencia> compruebaCoincidencias() {
		Collection<Coincidencia> res;
		Collection<ZonaDeseada> principalZonas;
		PlazaPropia plazaPropia;
		Collection<PlazaPropia> allPlazas;

		res = new ArrayList<Coincidencia>();
		principalZonas = findAllByPrincipal();
		allPlazas = plazaPropiaService.findAll();
		plazaPropia = plazaPropiaService.findByPrincipal();

		for (Iterator<PlazaPropia> iterator = allPlazas.iterator(); iterator.hasNext();) {
			PlazaPropia currentPlaza = iterator.next();
			if (currentPlaza.getId().equals(plazaPropia.getId())) {
				iterator.remove();
			}
		}

		for (PlazaPropia p : allPlazas) {
			for (ZonaDeseada z : principalZonas) {
				if (distance(p.getLatitud(), z.getLatitud(), p.getLongitud(), z.getLongitud()) < z.getRadio()) {
					// Si la distancia entre las coordenadas de la plaza y las
					// coordenadas de la zona es
					// menos que el radio, se considera que la plaza esta dentro
					// de la zona deseada y se
					// crea una coincidencia.

					if (compruebaNoContiene(res, p)) {
						Coincidencia c = new Coincidencia();
						UserAccount userAccount = usuarioService.findOne(p.getUsuarioId());

						c.setId(p.getId());
						c.setIdUsuarioDestino(p.getUsuarioId());
						c.setNombreUsuarioDestino(userAccount.getNombre() + " " + userAccount.getApellidos());
						c.setTitulo(p.getTitulo());

						res.add(c);
					}
				}
			}
		}
		return res;
	}

	public static boolean compruebaNoContiene(Collection<Coincidencia> c, PlazaPropia p) {
		boolean res = true;

		for (Coincidencia coincidencia : c) {
			if (coincidencia.getId().equals(p.getId())) {
				res = false;
			}
		}
		return res;
	}

	public boolean checkPrincipal(ZonaDeseada zonaDeseada) {
		boolean res;
		UserAccount principal;

		principal = usuarioService.findPrincipal();
		res = zonaDeseada.getUsuarioId().equals(principal.getId());

		return res;
	}

}