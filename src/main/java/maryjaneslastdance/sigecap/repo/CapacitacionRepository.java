package maryjaneslastdance.sigecap.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Capacitacion;
@Repository
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{
	
	@Query("SELECT c FROM Capacitacion c WHERE c.inicio>=:inicio AND c.fin<=:fin OR c.inicio<=:inicio AND c.fin>=:fin OR c.inicio<=:inicio AND c.fin>=:inicio OR c.inicio<=:fin AND c.fin>=:fin")
	List<Capacitacion> findConflictingCapacitaciones(LocalDateTime inicio, LocalDateTime fin);
}
