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

import domain.Propuesta;
import forms.PropuestaDTO;
import services.PropuestaService;

@RestController
@RequestMapping(value = "/api/propuesta")
public class PropuestaController {

	@Autowired
	private PropuestaService propuestaService;

	// Busca todas las propuestas enviadas del usuario logeado.

	@RequestMapping(value = "/enviadas", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<PropuestaDTO>> findAllEnviadas() {

		Collection<PropuestaDTO> res;

		res = propuestaService.findAllPropuestasEnviadasDTO();

		if (res == null) {
			return new ResponseEntity<Collection<PropuestaDTO>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<PropuestaDTO>>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/enviadasN", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Integer> findAllEnviadasN() {

		Integer res;

		res = propuestaService.findAllPropuestasEnviadasDTO().size();

		return new ResponseEntity<Integer>(res, HttpStatus.OK);
	}

	// Busca todas las propuestas recibidas del usuario logeado.

	@RequestMapping(value = "/recibidas", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Collection<PropuestaDTO>> findAllRecibidas() {

		Collection<PropuestaDTO> res;

		res = propuestaService.findAllPropuestasRecibidasDTO();

		if (res == null) {
			return new ResponseEntity<Collection<PropuestaDTO>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Collection<PropuestaDTO>>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/recibidasN", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<Integer> findAllRecibidasN() {

		Integer res;

		res = propuestaService.findAllPropuestasRecibidasDTO().size();

		return new ResponseEntity<Integer>(res, HttpStatus.OK);
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
	
	@RequestMapping(value = "aceptar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Propuesta> aceptaPropuesta(@PathVariable("id") String id) {

		Propuesta res;

		res = propuestaService.aceptaPropuesta(id);

		return new ResponseEntity<Propuesta>(res, HttpStatus.OK);
	}

	// Rechaza una propuesta.
	
	@RequestMapping(value = "rechazar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Propuesta> rechazaPropuesta(@PathVariable("id") String id) {

		Propuesta res;

		res = propuestaService.rechazaPropuesta(id);

		return new ResponseEntity<Propuesta>(res, HttpStatus.OK);
	}
}