package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.PlazaPropia;
import services.PlazaPropiaService;

@RestController
@RequestMapping(value = "/api/plazaPropia")
public class PlazaPropiaController {

	@Autowired
	private PlazaPropiaService plazaPropiaService;

	// Busca todas las plazas

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<PlazaPropia>> findAll() {

		Collection<PlazaPropia> res;

		res = plazaPropiaService.findAll();

		return new ResponseEntity<Collection<PlazaPropia>>(res, HttpStatus.OK);
	}

	// Busca la plaza del usuario logeado

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<PlazaPropia> findByPrincipal() {

		PlazaPropia res;

		res = plazaPropiaService.findByPrincipal();

		if (res == null) {
			return new ResponseEntity<PlazaPropia>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PlazaPropia>(res, HttpStatus.OK);
	}

	// Busca la plaza cuyo usuario se pasa por id
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<PlazaPropia> findByUserId(@PathVariable("id") String id) {

		PlazaPropia res;

		res = plazaPropiaService.findByUserId(id);

		if (id == null) {
			return new ResponseEntity<PlazaPropia>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PlazaPropia>(res, HttpStatus.OK);
	}

	// Modifica la plaza actual del usuario logeado

	@RequestMapping(value = "/modifica", method = RequestMethod.PUT)
	public ResponseEntity<PlazaPropia> modificaPlaza(@RequestBody PlazaPropia plazaPropia) {

		if (plazaPropia == null) {
			return new ResponseEntity<PlazaPropia>(HttpStatus.NOT_FOUND);
		}

		plazaPropiaService.modificaPlaza(plazaPropia);
		return new ResponseEntity<PlazaPropia>(plazaPropia, HttpStatus.OK);
	}
}