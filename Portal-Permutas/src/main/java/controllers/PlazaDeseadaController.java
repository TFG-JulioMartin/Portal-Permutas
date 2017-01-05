package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.PlazaDeseada;
import services.PlazaDeseadaService;
import services.UsuarioService;

@RestController
@RequestMapping("/api/plazaDeseada")
public class PlazaDeseadaController {

	@Autowired
	private PlazaDeseadaService plazaDeseadaService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<PlazaDeseada>> findAllByUserId(@PathVariable String id) {

		Collection<PlazaDeseada> res;

		// checkprincipal
		res = plazaDeseadaService.findAllByUserId(id);

		if (res == null) {
			return new ResponseEntity<Collection<PlazaDeseada>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<PlazaDeseada>>(res, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void add(@PathVariable String userId, @RequestBody @Valid PlazaDeseada plazaDeseada) {
		usuarioService.validateUser(userId);

		usuarioService.addPlazaDeseada(plazaDeseada);

	}

	@RequestMapping(value = "/plaza/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable String userId, @PathVariable("id") String id) {
		usuarioService.validateUser(userId);

		PlazaDeseada plazaDeseada;

		plazaDeseada = plazaDeseadaService.findOne(id);

		usuarioService.deletePlazaDeseada(plazaDeseada);

	}
}