package maryjaneslastdance.sigecap.repo;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacionId;

import java.util.List;

@Repository
public interface UsuarioCapacitacionRepository  extends CrudRepository<UsuarioCapacitacion, UsuarioCapacitacionId>{
    @Query("SELECT uc.usuario FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion")
    List<Usuario> findAllUsersByCapacitacion(Capacitacion capacitacion);
    @Query("SELECT uc.capacitacion FROM UsuarioCapacitacion uc WHERE uc.usuario=:usuario")
    List<Capacitacion> findAllCapacitacionesByUser(Usuario usuario);
}
