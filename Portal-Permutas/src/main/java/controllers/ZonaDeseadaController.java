package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Coincidencia;
import domain.ZonaDeseada;
import forms.ZonaDeseadaDTO;
import services.UsuarioService;
import services.ZonaDeseadaService;

@RestController
@RequestMapping("/api/zonaDeseada")
public class ZonaDeseadaController {

	@Autowired
	private ZonaDeseadaService zonaDeseadaService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<ZonaDeseada>> findAll() {

		Collection<ZonaDeseada> res;

		res = zonaDeseadaService.findAllByPrincipal();

		if (res == null) {
			return new ResponseEntity<Collection<ZonaDeseada>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<ZonaDeseada>>(res, HttpStatus.OK);
	}

	// Comprueba si hay alguna coincidencia.

	@RequestMapping(value = "/matchings", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<Coincidencia>> compruebaCoincidencias() {

		Collection<Coincidencia> res;

		// checkprincipal
		res = zonaDeseadaService.compruebaCoincidencias();

		if (res == null) {
			return new ResponseEntity<Collection<Coincidencia>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<Coincidencia>>(res, HttpStatus.OK);
	}

	// Crea una nueva zona deseada.

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ZonaDeseada> create(@RequestBody ZonaDeseadaDTO zona) {

		ZonaDeseada res;

		res = zonaDeseadaService.reconstruct(zona);

		return new ResponseEntity<ZonaDeseada>(res, HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
	// produces = "application/json")
	// ResponseEntity<Collection<ZonaDeseada>> findAllByUserId(@PathVariable
	// String id) {
	//
	// Collection<ZonaDeseada> res;
	//
	// // checkprincipal
	// res = zonaDeseadaService.findAllByUserId(id);
	//
	// if (res == null) {
	// return new ResponseEntity<Collection<ZonaDeseada>>(HttpStatus.NOT_FOUND);
	// }
	//
	// return new ResponseEntity<Collection<ZonaDeseada>>(res, HttpStatus.OK);
	// }

	// @RequestMapping(method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// void add(@PathVariable String userId, @RequestBody @Valid ZonaDeseada
	// zonaDeseada) {
	// usuarioService.validateUser(userId);
	//
	// usuarioService.addPlazaDeseada(zonaDeseada);
	//
	// }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ZonaDeseada> delete(@PathVariable("id") String id) {

		ZonaDeseada zonaDeseada;

		zonaDeseada = zonaDeseadaService.findOne(id);
		
		if (zonaDeseada == null) {
            System.out.println("Unable to delete. ZonaDeseada with id " + id + " not found");
            return new ResponseEntity<ZonaDeseada>(HttpStatus.NOT_FOUND);
        }

		zonaDeseadaService.delete(zonaDeseada);

		return new ResponseEntity<ZonaDeseada>(HttpStatus.NO_CONTENT);
	}
}