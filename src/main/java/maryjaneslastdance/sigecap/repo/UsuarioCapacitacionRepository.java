package maryjaneslastdance.sigecap.repo;

import maryjaneslastdance.sigecap.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioCapacitacionRepository  extends CrudRepository<UsuarioCapacitacion, UsuarioCapacitacionId>{
    @Query("SELECT uc.usuario FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion")
    List<Usuario> findAllUsersByCapacitacion(Capacitacion capacitacion);
    @Query("SELECT uc.capacitacion FROM UsuarioCapacitacion uc WHERE uc.usuario=:usuario")
    List<Capacitacion> findAllCapacitacionesByUser(Usuario usuario);
    @Query("SELECT COUNT(uc.usuario) FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion GROUP BY(uc.capacitacion)")
    Optional<Integer> countUsuarios(Capacitacion capacitacion);
    @Query("SELECT COUNT(uc.usuario) FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion AND uc.usuario.rol.id = 2 GROUP BY(uc.capacitacion)")
    Optional<Integer> countAlumnos(Capacitacion capacitacion);
    @Query("SELECT COUNT(uc.usuario) FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion AND uc.usuario.rol.id = 3 GROUP BY(uc.capacitacion)")
    Optional<Integer> countTutores(Capacitacion capacitacion);
    @Query("SELECT uc.usuario FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion AND uc.usuario.rol.id = 2")
    List<Usuario> alumnos(Capacitacion capacitacion);
    @Query("SELECT uc.usuario FROM UsuarioCapacitacion uc WHERE uc.capacitacion=:capacitacion AND uc.usuario.rol.id = 3")
    List<Usuario> tutores(Capacitacion capacitacion);
}
