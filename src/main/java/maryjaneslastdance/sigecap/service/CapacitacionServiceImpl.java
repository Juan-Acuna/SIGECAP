package maryjaneslastdance.sigecap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import maryjaneslastdance.sigecap.entity.Capacitacion;
import maryjaneslastdance.sigecap.repository.CapacitacionRepository;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{

	@Autowired
	private CapacitacionRepository repositorio;
	
	@Override
	public List<Capacitacion> listarCapacitaciones() {
		return repositorio.findAll();
	}

	@Override
	public Capacitacion guardarCapacitacion(Capacitacion capacitacion) {
		return repositorio.save(capacitacion);
	}

	@Override
	public Capacitacion obtenerCapacitacionPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Capacitacion editarCapacitacion(Capacitacion capacitacion) {
		return repositorio.save(capacitacion);
	}

	@Override
	public void eliminarCapacitacion(Long id) {
		repositorio.deleteById(id);
	}
}
