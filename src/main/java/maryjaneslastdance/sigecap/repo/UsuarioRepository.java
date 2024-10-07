package maryjaneslastdance.sigecap.repo;

import maryjaneslastdance.sigecap.model.Capacitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.rol.id=2 AND u.id NOT IN (SELECT uc.usuario.id FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion)")
    List<Usuario> alumnosNotIn(Capacitacion capacitacion);
    @Query("SELECT u FROM Usuario u WHERE u.rol.id=3 AND u.id NOT IN (SELECT uc.usuario.id FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion)")
    List<Usuario> tutoresNotIn(Capacitacion capacitacion);
}
