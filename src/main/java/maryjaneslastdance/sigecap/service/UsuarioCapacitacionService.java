package maryjaneslastdance.sigecap.service;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.repo.RolRepository;
import maryjaneslastdance.sigecap.repo.UsuarioCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioCapacitacionService {
    @Autowired
    private UsuarioCapacitacionRepository repo;
    @Autowired
    private RolRepository rolRepo;

    public List<UsuarioCapacitacion> insertAll(List<UsuarioCapacitacion> usuarioCap) {
        return (List<UsuarioCapacitacion>) repo.saveAll(usuarioCap);
    }
    public List<Usuario> selectUsuarios(Capacitacion capacitacion) {
        return repo.findAllUsersByCapacitacion(capacitacion);
    }

    public List<Capacitacion> selectCapacitaciones(Usuario usuario) {
        return repo.findAllCapacitacionesByUser(usuario);
    }
    public int getConteoUsuarios(Capacitacion capacitacion) {
        return repo.countUsuarios(capacitacion).orElse(0);
    }
    public int getConteoAlumnos(Capacitacion capacitacion) {
        return repo.countAlumnos(capacitacion).orElse(0);
    }
    public int getConteoTutores(Capacitacion capacitacion) {
        return repo.countTutores(capacitacion).orElse(0);
    }
}
