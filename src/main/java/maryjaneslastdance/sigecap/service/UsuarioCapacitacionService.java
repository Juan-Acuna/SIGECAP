package maryjaneslastdance.sigecap.service;

import maryjaneslastdance.sigecap.model.*;
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

    public List<Usuario> getTutores(Capacitacion capacitacion) {
        return repo.tutores(capacitacion);
    }

    public List<Usuario> getAlumnos(Capacitacion capacitacion) {
        return repo.alumnos(capacitacion);
    }
    public void delete(UsuarioCapacitacion cap) {
        repo.delete(cap);
    }

    public UsuarioCapacitacion select(Usuario usuario, Capacitacion capacitacion) {
        return repo.findById(new UsuarioCapacitacionId(usuario, capacitacion)).orElse(null);
    }

    public UsuarioCapacitacion update(UsuarioCapacitacion usuarioCapacitacion) {
        return repo.save(usuarioCapacitacion);
    }

    public List<Calificacion> getCalificaciones(Capacitacion capacitacion) {
        return repo.getCalificaciones(capacitacion);
    }
}
