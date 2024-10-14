package maryjaneslastdance.sigecap.service;

import maryjaneslastdance.sigecap.model.Ubicacion;
import maryjaneslastdance.sigecap.repo.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepository repo;

    public List<Ubicacion> selectAll() {
        return (List<Ubicacion>) repo.findAll();
    }

    public Ubicacion select(int id) {
        return repo.findById(id).orElse(null);
    }

    public Ubicacion insert(Ubicacion ubicacion) {
        return repo.save(ubicacion);
    }

    public Ubicacion update(Ubicacion ubicacion) {
        return repo.save(ubicacion);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
