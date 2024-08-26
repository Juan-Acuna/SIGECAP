package maryjaneslastdance.sigecap.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
