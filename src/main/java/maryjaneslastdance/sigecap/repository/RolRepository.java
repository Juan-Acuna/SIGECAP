package maryjaneslastdance.sigecap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
