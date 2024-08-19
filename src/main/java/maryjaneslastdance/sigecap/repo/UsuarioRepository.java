package maryjaneslastdance.sigecap.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.models.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
