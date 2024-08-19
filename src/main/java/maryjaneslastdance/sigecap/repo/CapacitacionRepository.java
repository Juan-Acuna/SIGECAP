package maryjaneslastdance.sigecap.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Capacitacion;
@Repository
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{

}
