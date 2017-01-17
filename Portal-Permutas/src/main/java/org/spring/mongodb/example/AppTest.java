package org.spring.mongodb.example;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import domain.PlazaPropia;
import domain.PlazaDeseada;
import domain.Usuario;
import security.Authority;
import security.UserAccount;

//import domain.PlazaPropia;

//import org.springframework.context.support.GenericXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("spring/config/SpringMongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		// PlazaDeseada plazaDeseada1 = new PlazaDeseada();
		// plazaDeseada1.setCuidad("Sevilla");
		// plazaDeseada1.setUsuarioId("5866b0466647cbc7f7893046");
		// plazaDeseada1.setZona("Zona1");
		//
		// mongoOperation.save(plazaDeseada1);

		// PlazaDeseada plazaDeseada2 = new PlazaDeseada();
		// plazaDeseada2.setCuidad("Sevilla");
		// plazaDeseada2.setUsuarioId("5866b0466647cbc7f7893046");
		// plazaDeseada2.setZona("Zona2");
		//
		// mongoOperation.save(plazaDeseada2);
		
		UserAccount userAccount = new UserAccount();
		
		Md5PasswordEncoder encoder;
		encoder = new Md5PasswordEncoder();

	
		userAccount.setUsername("julio");
		userAccount.setPassword(encoder.encodePassword("julio", null));
		userAccount.setEnabled(true);
		userAccount.setAccountNonExpired(true);
		userAccount.setAccountNonLocked(true);
		userAccount.setCredentialsNonExpired(true);
		userAccount.addRole("ROLE_USER");
		
		mongoOperation.save(userAccount);

		// UserAccount userAccount;
		// Authority authority;
		//
		// userAccount = new UserAccount();
		// authority = new Authority();
		//
		// authority.setAuthority("USUARIO");
		// userAccount.addAuthority(authority);
		// userAccount.setUsername("usuario1");
		// userAccount.setPassword("usuario1");
		//
		// mongoOperation.save(userAccount);
		//
		// Usuario usuario = new Usuario();
		// usuario.setApellidos("Martín Alba");
		// usuario.setEmail("jmartinalba88@gmail.com");
		// usuario.setNombre("Julio");
		// usuario.setTelefono("623354654");
		// usuario.setUserAccountId(userAccount.getId());
		//
		// mongoOperation.save(usuario);
		//
		// PlazaPropia plazaPropia = new PlazaPropia();
		// plazaPropia.setCentro("centro1");
		// plazaPropia.setCiudad("Sevilla");
		// plazaPropia.setDireccion("direccion1");
		// plazaPropia.setTitulo("titulo1");
		// plazaPropia.setUsuarioId(usuario.getId());
		//
		// mongoOperation.save(plazaPropia);

		// now user object got the created id.
		// System.out.println("1. usuario : " + usuario + "2. plazaPropia : " +
		// plazaPropia);

		// // query to search user
		// Query searchUserQuery = new
		// Query(Criteria.where("ciudad").is("Sevilla"));
		//
		// // find the saved user again.
		// PlazaPropia savedPlaza = mongoOperation.findOne(searchUserQuery,
		// PlazaPropia.class);
		// System.out.println("2. find - savedPlaza : " + savedPlaza);

	}
}