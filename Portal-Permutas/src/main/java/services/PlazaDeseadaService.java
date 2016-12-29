package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.PlazaDeseada;
import domain.PlazaPropia;
import repositories.PlazaDeseadaRepository;

@Service
@Transactional
public class PlazaDeseadaService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private PlazaDeseadaRepository plazaDeseadaRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public PlazaDeseadaService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public PlazaDeseada create() {
		PlazaDeseada result;

		result = new PlazaDeseada();

		return result;
	}

	public PlazaDeseada findOne(String plazaDeseadaId) {
		Assert.notNull(plazaDeseadaId);

		PlazaDeseada result;

		result = plazaDeseadaRepository.findOne(plazaDeseadaId);

		return result;

	}

	public Collection<PlazaDeseada> findAll() {

		Collection<PlazaDeseada> result;

		result = plazaDeseadaRepository.findAll();

		return result;
	}

	public void save(PlazaDeseada plazaDeseada) {
		Assert.notNull(plazaDeseada);

		plazaDeseadaRepository.save(plazaDeseada);
	}

	public void delete(PlazaDeseada plazaDeseada) {
		Assert.notNull(plazaDeseada);

		plazaDeseadaRepository.delete(plazaDeseada);

	}

	// Other business methods -------------------------------------------------

	public Collection<PlazaDeseada> findAllByUserId(String userId) {

		return new ArrayList<PlazaDeseada>();
	}

	public Collection<PlazaDeseada> findByZona(String zona) {

		// Busca plazas cercanas a la zona dada.
		return new ArrayList<PlazaDeseada>();
	}
	
	public Page<PlazaDeseada> findPlazas(Pageable pageable) {
        return plazaDeseadaRepository.findAll(pageable);
    }

}
