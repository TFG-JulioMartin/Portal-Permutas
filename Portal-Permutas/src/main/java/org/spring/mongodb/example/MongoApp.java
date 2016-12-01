// package org.spring.mongodb.example;
//
// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
//
// import com.mongodb.BasicDBObject;
// import com.mongodb.DB;
// import com.mongodb.MongoClient;
// import com.mongodb.MongoClientURI;
//
// public class MongoApp {
//
// private static final Log log = LogFactory.getLog(MongoApp.class);
//
// public static void main(String[] args) throws Exception {
//
// MongoClientURI uri = new
// MongoClientURI("mongodb://julioma:nova88@ds048319.mlab.com:48319/portal-permutas");
// MongoClient client = new MongoClient(uri);
// DB db = client.getDB(uri.getDatabase());
//
// BasicDBObject document = new BasicDBObject();
// document.put("titulo", "plazaTest");
// document.put("centro", "centroTest");
// document.put("direccion", "direccionTest");
// db.getCollection("PlazaDeseada").insert(document);
//
// log.info(db.getCollectionNames());
// log.info(db.getCollection("PlazaDeseada").find().toArray());
//
// }
// }