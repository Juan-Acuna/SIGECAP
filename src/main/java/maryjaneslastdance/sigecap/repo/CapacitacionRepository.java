package maryjaneslastdance.sigecap.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.models.Capacitacion;
@Repository
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{

}
