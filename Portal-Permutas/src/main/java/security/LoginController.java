/* LoginController.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

@RestController
@RequestMapping("/security")
public class LoginController extends AbstractController {

	// Supporting services ----------------------------------------------------

	@Autowired
	LoginService service;

	// Constructors -----------------------------------------------------------

	public LoginController() {
		super();
	}

	// Authenticate -----------------------------------------------------------

	@RequestMapping(value = "/principal", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserAccount> getPrincipal() {
		UserAccount res;

		res = service.getPrincipal();

		if (res == null) {
			return new ResponseEntity<UserAccount>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UserAccount>(res, HttpStatus.OK);
	}

	// Login ------------------------------------------------------------------

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> login() {
		User res;

		System.out.println("entra");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		res = (User) auth.getPrincipal();

		System.out.println(res);

		if (res == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(res, HttpStatus.OK);
	}

	// LoginFailure -----------------------------------------------------------

	@RequestMapping("/loginFailure")
	public ModelAndView failure() {
		ModelAndView result;

		result = new ModelAndView("redirect:login.do?showError=true");

		return result;
	}

}