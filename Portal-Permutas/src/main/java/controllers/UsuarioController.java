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

import forms.UsuarioForm;
import security.UserAccount;
import services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;


	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<UserAccount>> get() {

		Collection<UserAccount> userAccount = usuarioService.findAll();

		return new ResponseEntity<Collection<UserAccount>>(userAccount, HttpStatus.OK);

	}

	// Registra un nuevo usuario
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void register(@RequestBody UsuarioForm user) {

		usuarioService.reconstruct(user);

	}

	// Busca el usuario logeado

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<UserAccount> findByUserId() {

		UserAccount res;

		// checkea principal -> busca principal // De momento devuelve uno concreto.
		res = usuarioService.findOne("5895b95e61e67638e2cb19c2");
		System.out.println("Entra al findUser");

		if (res == null) {
			return new ResponseEntity<UserAccount>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UserAccount>(res, HttpStatus.OK);
	}

	// Modifica el perfil del usuario logeado

	@RequestMapping(value = "/modifica", method = RequestMethod.PUT)
	public ResponseEntity<UserAccount> updatePlaza(@RequestBody UserAccount usuario) {

		System.out.println("Entra al modifica");
		if (usuario == null) {
			return new ResponseEntity<UserAccount>(HttpStatus.NOT_FOUND);
		}

		usuarioService.modificaUserAccount(usuario);
		return new ResponseEntity<UserAccount>(usuario, HttpStatus.OK);
	}

}
