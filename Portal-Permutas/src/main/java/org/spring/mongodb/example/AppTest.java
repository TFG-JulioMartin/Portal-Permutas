package org.spring.mongodb.example;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		
		PlazaDeseada plazaDeseada2 = new PlazaDeseada();
		plazaDeseada2.setCuidad("Sevilla");
		plazaDeseada2.setUsuarioId("5866b0466647cbc7f7893046");
		plazaDeseada2.setZona("Zona2");

		mongoOperation.save(plazaDeseada2);

		// Usuario usuario = new Usuario();
		// usuario.setApellidos("Martín Alba");
		// usuario.setEmail("jmartinalba88@gmail.com");
		// usuario.setNombre("Julio");
		// usuario.setTelefono("623354654");
		//
		// mongoOperation.save(usuario);
		//
		// PlazaPropia plazaPropia = new PlazaPropia();
		// plazaPropia.setCentro("centro1");
		// plazaPropia.setCiudad("Sevilla");
		// plazaPropia.setDireccion("direccion1");
		// plazaPropia.setTitulo("titulo1");
		// plazaPropia.setUsuarioId(usuario.getId());

		// mongoOperation.save(plazaPropia);

		// UserAccount userAccount = new UserAccount();
		// userAccount.setUsername("usuario1");
		// userAccount.setPassword("usuario1");
		// Collection<Authority> authorities = new ArrayList<>();
		// Authority authority = new Authority();
		// authority.setAuthority("ADMIN");
		// authorities.add(authority);
		// userAccount.setAuthorities(authorities);

		// save
		// mongoOperation.save(userAccount);

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