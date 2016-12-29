package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	Usuario findByUserAccountId(String userAccountId);

}
