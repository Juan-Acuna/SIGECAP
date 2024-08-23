package maryjaneslastdance.sigecap.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);

}
