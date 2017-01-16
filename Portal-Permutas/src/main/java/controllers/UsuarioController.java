package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.Usuario;
import forms.UsuarioForm;
import services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// Registra un nuevo usuario

	@RequestMapping(method = RequestMethod.GET,produces = "application/json")	
	ResponseEntity<Collection<Usuario>> get() {

		Collection<Usuario> usuario = usuarioService.findAll();

		return new ResponseEntity<Collection<Usuario>>(usuario, HttpStatus.OK);

	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void register(@RequestBody UsuarioForm usuarioForm) {

		Usuario usuario = usuarioService.reconstruct(usuarioForm);

		usuarioService.save(usuario);

	}

	// Busca el usuario por su id

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Usuario> findByUserId(@PathVariable String id) {

		Usuario res;

		// checkprincipal
		res = usuarioService.findOne(id);

		if (res == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(res, HttpStatus.OK);
	}

	// Modifica el perfil del usuario logeado

	@RequestMapping(value = "/modifica/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updatePlaza(@RequestBody Usuario usuario) {

		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		usuarioService.modificaUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
