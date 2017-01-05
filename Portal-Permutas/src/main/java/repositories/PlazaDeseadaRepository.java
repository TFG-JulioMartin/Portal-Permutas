package repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.PlazaDeseada;

@Repository
public interface PlazaDeseadaRepository extends MongoRepository<PlazaDeseada, String> {

	public Collection<PlazaDeseada> findByUsuarioId(String id);

}
