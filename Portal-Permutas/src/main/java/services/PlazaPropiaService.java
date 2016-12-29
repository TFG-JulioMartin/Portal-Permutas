package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.PlazaPropia;
import repositories.PlazaPropiaRepository;

@Service
@Transactional
public class PlazaPropiaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private PlazaPropiaRepository plazaPropiaRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public PlazaPropiaService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public PlazaPropia create() {
		PlazaPropia result;

		result = new PlazaPropia();

		return result;
	}

	public PlazaPropia findOne(String plazaPropiaId) {
		Assert.notNull(plazaPropiaId);

		PlazaPropia result;

		result = plazaPropiaRepository.findOne(plazaPropiaId);

		return result;

	}

	public Collection<PlazaPropia> findAll() {

		Collection<PlazaPropia> result;

		result = plazaPropiaRepository.findAll();

		return result;
	}

	public void save(PlazaPropia plazaPropia) {
		Assert.notNull(plazaPropia);

		plazaPropiaRepository.save(plazaPropia);
	}

	public void delete(PlazaPropia plazaPropia) {
		Assert.notNull(plazaPropia);

		plazaPropiaRepository.delete(plazaPropia);

	}

	// Other business methods -------------------------------------------------

	public PlazaPropia findByCiudad(String ciudad) {
		PlazaPropia result;

		result = plazaPropiaRepository.findByCiudad(ciudad);

		return result;
	}
	
	public Page<PlazaPropia> findPlazas(Pageable pageable) {
        return plazaPropiaRepository.findAll(pageable);
    }
}