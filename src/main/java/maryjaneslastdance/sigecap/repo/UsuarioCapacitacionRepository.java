package maryjaneslastdance.sigecap.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.models.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.models.UsuarioCapacitacionId;
@Repository
public interface UsuarioCapacitacionRepository  extends CrudRepository<UsuarioCapacitacion, UsuarioCapacitacionId>{

}
