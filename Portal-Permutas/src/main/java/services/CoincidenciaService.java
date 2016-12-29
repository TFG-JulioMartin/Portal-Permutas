package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Coincidencia;
import repositories.CoincidenciaRepository;

@Service
@Transactional
public class CoincidenciaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private CoincidenciaRepository coincidenciaRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public CoincidenciaService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Coincidencia create() {
		Coincidencia result;

		result = new Coincidencia();

		return result;
	}

	public Coincidencia findOne(String coincidenciaId) {
		Assert.notNull(coincidenciaId);

		Coincidencia result;

		result = coincidenciaRepository.findOne(coincidenciaId);

		return result;

	}

	public Collection<Coincidencia> findAll() {

		Collection<Coincidencia> result;

		result = coincidenciaRepository.findAll();

		return result;
	}

	public void save(Coincidencia coincidencia) {
		Assert.notNull(coincidencia);

		coincidenciaRepository.save(coincidencia);
	}

	public void delete(Coincidencia coincidencia) {
		Assert.notNull(coincidencia);

		coincidenciaRepository.delete(coincidencia);

	}

	// Other business methods -------------------------------------------------

}
