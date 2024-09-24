package maryjaneslastdance.sigecap.service;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.repo.UsuarioCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCapacitacionService {
    @Autowired
    UsuarioCapacitacionRepository repo;

    public List<UsuarioCapacitacion> insertAll(List<UsuarioCapacitacion> usuarioCap) {
        return (List<UsuarioCapacitacion>) repo.saveAll(usuarioCap);
    }
    public List<Usuario> selectUsuarios(Capacitacion capacitacion) {
        return repo.findAllUsersByCapacitacion(capacitacion);
    }
}
