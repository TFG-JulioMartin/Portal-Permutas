package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Coincidencia;
import domain.Propuesta;
import repositories.PropuestaRepository;

@Service
@Transactional
public class PropuestaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private PropuestaRepository propuestaRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public PropuestaService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Propuesta create() {
		Propuesta result;

		result = new Propuesta();

		result.setEstado(0);
		result.setFecha(new Date());

		return result;
	}

	public Propuesta findOne(String propuestaId) {
		Assert.notNull(propuestaId);

		Propuesta result;

		result = propuestaRepository.findOne(propuestaId);

		return result;

	}

	public Collection<Propuesta> findAll() {

		Collection<Propuesta> result;

		result = propuestaRepository.findAll();

		return result;
	}

	public void save(Propuesta propuesta) {
		Assert.notNull(propuesta);

		long milliseconds;
		Date moment;

		milliseconds = System.currentTimeMillis() - 100;
		moment = new Date(milliseconds);

		propuesta.setFecha(moment);

		propuestaRepository.save(propuesta);
	}

	public void delete(Propuesta propuesta) {
		Assert.notNull(propuesta);

		propuestaRepository.delete(propuesta);

	}

	// Other business methods -------------------------------------------------

	public Collection<Propuesta> findAllByUserId(String id) {
		Collection<Propuesta> res;
		Collection<Propuesta> todas;

		todas = propuestaRepository.findAll();
		res = new ArrayList<Propuesta>();

		for (Propuesta p : todas) {
			if (p.getRemitenteId().equals(id) || p.getDestinatarioId().equals(id)) {
				res.add(p);
			}
		}
		return res;
	}

	public Propuesta creaPropuesta(Coincidencia coincidencia) {
		Propuesta res;

		res = create();
		
		res.setDestinatarioId(coincidencia.getIdUsuarioDestino());
		// Cambiar al principal
		res.setRemitenteId("5898c37f61e6598b14cce7de");
		
		return res;

	}

	// temporales

	public void aceptaPropuesta(Propuesta propuesta) {
		propuesta.setEstado(1);
	}

	public void rechazaPropuesta(Propuesta propuesta) {
		propuesta.setEstado(2);
	}
}