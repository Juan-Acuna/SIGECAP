package maryjaneslastdance.sigecap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maryjaneslastdance.sigecap.entity.Capacitacion;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long>{

}
