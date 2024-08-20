package maryjaneslastdance.sigecap.service;

import java.util.List;
import maryjaneslastdance.sigecap.entity.Capacitacion;

public interface CapacitacionService {
	public List<Capacitacion> listarCapacitaciones();
	
	public Capacitacion guardarCapacitacion(Capacitacion capacitacion);
	
	public Capacitacion obtenerCapacitacionPorId(Long id);
	
	public Capacitacion editarCapacitacion(Capacitacion capacitacion);
	
	public void eliminarCapacitacion(Long id);
}
