package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.PlazaPropia;
import services.PlazaPropiaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/plazaPropia")
public class PlazaPropiaController {

	@Autowired
	private PlazaPropiaService plazaPropiaService;
	
//	 @RequestMapping(value = "", method = RequestMethod.GET, produces =
//	 MediaType.APPLICATION_JSON_VALUE)
//	 public ResponseEntity<Page<PlazaPropia>> findAllPlazas(Pageable pageable,
//	 HttpServletRequest req) {
//	 Page<PlazaPropia> page = plazaPropiaService.findPlazas(pageable);
//	 return new ResponseEntity<>(page, HttpStatus.OK);
//	 }
	
	

}
