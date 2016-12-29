package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Coincidencia;
import services.CoincidenciaService;
import services.UsuarioService;

@RestController
@RequestMapping("/api/coincidencia")
public class CoincidenciaController {

	@Autowired
	private CoincidenciaService coincidenciaService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST)
	void add(@PathVariable String userId, @RequestBody @Valid Coincidencia coincidencia) {
		usuarioService.validateUser(userId);

		coincidenciaService.save(coincidencia);

	}

}
