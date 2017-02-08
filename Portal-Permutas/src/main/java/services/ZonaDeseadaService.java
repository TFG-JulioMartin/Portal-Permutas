package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Coincidencia;
import domain.PlazaPropia;
import domain.ZonaDeseada;
import forms.ZonaDeseadaDTO;
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

	public Collection<ZonaDeseada> findByZona(String zona) {

		// Busca plazas cercanas a la zona dada.
		return new ArrayList<ZonaDeseada>();
	}

	public void reconstruct(ZonaDeseadaDTO zona) {

		ZonaDeseada zonaDeseada = new ZonaDeseada();
		Double radio;
		double lat = midPoint(zona.getSlat(), zona.getSlng(), zona.getElat(), zona.getElng())[0];
		double lng = midPoint(zona.getSlat(), zona.getSlng(), zona.getElat(), zona.getElng())[1];

		radio = distance(zona.getSlat(), zona.getElat(), zona.getSlng(), zona.getElng());

		zonaDeseada.setLatitud(lat);
		zonaDeseada.setLongitud(lng);
		zonaDeseada.setRadio(radio);

		save(zonaDeseada);
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

		return Math.sqrt(distance) / 2;
	}

	public static double[] midPoint(double lat1, double lon1, double lat2, double lon2) {

		double[] coords = new double[2];
		double dLon = Math.toRadians(lon2 - lon1);

		// convert to radians
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		lon1 = Math.toRadians(lon1);

		double Bx = Math.cos(lat2) * Math.cos(dLon);
		double By = Math.cos(lat2) * Math.sin(dLon);
		double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2),
				Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
		double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

		coords[0] = Math.toDegrees(lat3);
		coords[1] = Math.toDegrees(lon3);

		return coords;
	}

	public Collection<Coincidencia> compruebaCoincidencias() {
		Collection<Coincidencia> res;
		Collection<ZonaDeseada> principalZonas;
		Collection<PlazaPropia> allPlazas;
		int contador = 0;

		res = new ArrayList<Coincidencia>();
		principalZonas = findAllByPrincipal();
		allPlazas = plazaPropiaService.findAll();

		for (PlazaPropia p : allPlazas) {
			for (ZonaDeseada z : principalZonas) {
				if (distance(p.getLatitud(), z.getLatitud(), p.getLongitud(), z.getLongitud()) < z.getRadio()) {
					// Si la distancia entre las coordenadas de la plaza y las
					// coordenadas de la zona es
					// menos que el radio, se considera que la plaza esta dentro
					// de la zona deseada y se
					// crea una coincidencia.
					Coincidencia c = new Coincidencia();
					UserAccount userAccount = usuarioService.findOne(p.getUsuarioId());

					c.setId(String.valueOf(contador));
					c.setIdUsuarioDestino(p.getUsuarioId());
					c.setNombreUsuarioDestino(userAccount.getNombre() + " " + userAccount.getApellidos());
					c.setTitulo(p.getTitulo());

					contador++;

					res.add(c);
				}
			}
		}
		return res;
	}
}