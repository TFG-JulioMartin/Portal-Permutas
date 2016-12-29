package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.Coincidencia;

@Repository
public interface CoincidenciaRepository extends MongoRepository<Coincidencia, String> {

}
