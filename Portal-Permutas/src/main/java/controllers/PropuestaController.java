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

import domain.Coincidencia;
import domain.Propuesta;
import services.PropuestaService;

@RestController
@RequestMapping(value = "/api/propuesta")
public class PropuestaController {

	@Autowired
	private PropuestaService propuestaService;

	// Busca todas las propuestas del usuario logeado.

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<Propuesta>> findAllByUserId(@PathVariable String id) {

		Collection<Propuesta> res;

		// checkprincipal
		res = propuestaService.findAllByUserId(id);

		if (res == null) {
			return new ResponseEntity<Collection<Propuesta>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<Propuesta>>(res, HttpStatus.OK);
	}

	// Busca una propuesta por su id.

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Propuesta> findByPropuestaId(@PathVariable String id) {

		Propuesta res;

		// checkprincipal
		res = propuestaService.findOne(id);

		if (res == null) {
			return new ResponseEntity<Propuesta>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Propuesta>(res, HttpStatus.OK);
	}

	// Para testeo solo

	@RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Propuesta> findOne() {

		Propuesta res;

		// checkprincipal
		res = propuestaService.findOne("5899fe5f61e6264d5bebf163");

		if (res == null) {
			return new ResponseEntity<Propuesta>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Propuesta>(res, HttpStatus.OK);
	}

	// Crea una nueva propuesta.

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void add(@RequestBody Propuesta propuesta) {

		propuestaService.creaPropuesta(propuesta);

	}

	// Acepta una propuesta.

	@RequestMapping(value = "acepta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Propuesta> aceptaPropuesta(@RequestBody Propuesta propuesta) {

		if (propuesta == null) {
			return new ResponseEntity<Propuesta>(HttpStatus.NOT_FOUND);
		}

		propuestaService.aceptaPropuesta(propuesta);
		return new ResponseEntity<Propuesta>(propuesta, HttpStatus.OK);
	}

	// Rechaza una propuesta.

	@RequestMapping(value = "rechaza/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Propuesta> rechazaPropuesta(@RequestBody Propuesta propuesta) {

		if (propuesta == null) {
			return new ResponseEntity<Propuesta>(HttpStatus.NOT_FOUND);
		}

		propuestaService.rechazaPropuesta(propuesta);
		return new ResponseEntity<Propuesta>(propuesta, HttpStatus.OK);
	}
}