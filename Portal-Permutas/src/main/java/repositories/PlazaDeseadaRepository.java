package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.PlazaDeseada;

@Repository
public interface PlazaDeseadaRepository extends MongoRepository<PlazaDeseada, String> {

}
