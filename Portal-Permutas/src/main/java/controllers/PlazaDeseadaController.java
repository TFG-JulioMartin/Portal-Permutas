package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	Collection<PlazaDeseada> findAllByUserId() {

		Collection<PlazaDeseada> res;

		res = plazaDeseadaService.findAll();

		return res;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void add(@PathVariable String userId, @RequestBody @Valid PlazaDeseada plazaDeseada) {
		usuarioService.validateUser(userId);

		usuarioService.addPlazaDeseada(plazaDeseada);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable String userId, @PathVariable("id") String id) {
		usuarioService.validateUser(userId);

		PlazaDeseada plazaDeseada;

		plazaDeseada = plazaDeseadaService.findOne(id);

		usuarioService.deletePlazaDeseada(plazaDeseada);

	}

	@RequestMapping(value = "{zona}", method = RequestMethod.GET)
	void findByZona(@PathVariable("zona") String zona) {

		plazaDeseadaService.findByZona(zona);

	}
}