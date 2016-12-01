//package org.spring.mongodb.example;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//
//import domain.PlazaPropia;
//
////import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class AppTest {
//
//	public static void main(String[] args) {
//
//		ApplicationContext ctx = new GenericXmlApplicationContext("spring/config/SpringMongoConfig.xml");
//		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
//
//		PlazaPropia plazaPropia = new PlazaPropia();
//		plazaPropia.setCentro("centroTEST");
//		plazaPropia.setCiudad("Sevilla");
//		plazaPropia.setDireccion("direccionTEST");
//		plazaPropia.setTitulo("tituloTEST");
//
//		// save
//		mongoOperation.save(plazaPropia);
//
//		// now user object got the created id.
//		System.out.println("1. plazaPropia : " + plazaPropia);
//
//		// query to search user
//		Query searchUserQuery = new Query(Criteria.where("ciudad").is("Sevilla"));
//
//		// find the saved user again.
//		PlazaPropia savedPlaza = mongoOperation.findOne(searchUserQuery, PlazaPropia.class);
//		System.out.println("2. find - savedPlaza : " + savedPlaza);
//
//	}
//}