package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.Propuesta;

@Repository
public interface PropuestaRepository extends MongoRepository<Propuesta, String> {

}
