package maryjaneslastdance.sigecap.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacionId;
@Repository
public interface UsuarioCapacitacionRepository  extends CrudRepository<UsuarioCapacitacion, UsuarioCapacitacionId>{

}
