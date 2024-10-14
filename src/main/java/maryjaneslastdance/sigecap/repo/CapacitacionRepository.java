package maryjaneslastdance.sigecap.repo;

import java.time.LocalDateTime;
import java.util.List;

import maryjaneslastdance.sigecap.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Capacitacion;
@Repository
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{
	
	@Query("SELECT c FROM Capacitacion c WHERE c.inicio>=:inicio AND c.fin<=:fin OR c.inicio<=:inicio AND c.fin>=:fin OR c.inicio<=:inicio AND c.fin>=:inicio OR c.inicio<=:fin AND c.fin>=:fin")
	List<Capacitacion> consultarPeriodo(LocalDateTime inicio, LocalDateTime fin);

	@Query("SELECT uc.capacitacion FROM UsuarioCapacitacion uc WHERE uc.usuario = :usuario")
    List<Capacitacion> findAllByUsuario(Usuario usuario);

	@Query("SELECT c FROM Capacitacion c WHERE DATE(c.inicio) = DATE(:fecha)")
    List<Capacitacion> findByFecha(LocalDateTime fecha);
}
