package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.ZonaDeseada;
import forms.ZonaDeseadaDTO;
import repositories.ZonaDeseadaRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class ZonaDeseadaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ZonaDeseadaRepository zonaDeseadaRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private LoginService loginService;

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

	public Collection<ZonaDeseada> findAllByUserId() {
		Collection<ZonaDeseada> res;
		Collection<ZonaDeseada> todas;
		UserAccount userAccount;
		String id;

		res = new ArrayList<ZonaDeseada>();
		todas = findAll();
		userAccount = loginService.getPrincipal2();
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

	public Page<ZonaDeseada> findPlazas(Pageable pageable) {
		return zonaDeseadaRepository.findAll(pageable);
	}

	public void reconstruct(ZonaDeseadaDTO zona) {

		ZonaDeseada zonaDeseada = new ZonaDeseada();
		Double radio;

		radio = distance(zona.getSlat(), zona.getElat(), zona.getSlng(), zona.getElng());

		zonaDeseada.setLatitud(zona.getSlat());
		zonaDeseada.setLongitud(zona.getSlng());
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
}
