package maryjaneslastdance.sigecap.repo;

import maryjaneslastdance.sigecap.model.Ubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Integer> {
}
