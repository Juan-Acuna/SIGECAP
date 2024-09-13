package maryjaneslastdance.sigecap.service;

import java.time.LocalDateTime;
import java.util.List;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.repo.CapacitacionRepository;
import maryjaneslastdance.sigecap.model.Capacitacion;

@Service
public class CapacitacionService {
	
	@Autowired
	CapacitacionRepository repo;
	
	
	public boolean validarDisponibilidad() {
		
		
		return true;
	}


	public List<Capacitacion> getPeriodo(LocalDateTime horarioInicio, LocalDateTime horarioFin) {
		return repo.consultarPeriodo(horarioInicio, horarioFin);
	}


	public Capacitacion insert(Capacitacion capacitacion) {
		return repo.save(capacitacion);
	}

	public List<Capacitacion> getCapacitaciones(Usuario usuario) {
		return (List<Capacitacion>) repo.findAllByUsuario(usuario);
	}

	public List<Capacitacion> getCapacitaciones() {
		return (List<Capacitacion>) repo.findAll();
	}

    public Capacitacion update(Capacitacion capacitacion) {
		return repo.save(capacitacion);
    }

	public void delete(int id) {
		repo.deleteById(id);
	}

	public List<Capacitacion> getFecha(LocalDateTime fecha) {
		return repo.findByFecha(fecha);
	}
}
