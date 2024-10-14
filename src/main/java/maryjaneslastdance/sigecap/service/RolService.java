package maryjaneslastdance.sigecap.service;

import maryjaneslastdance.sigecap.model.Rol;
import maryjaneslastdance.sigecap.repo.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository repo;
    public List<Rol> selectAll() {
        return (List<Rol>) repo.findAll();
    }
    public Rol select(int id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Rol insert(Rol rol) {
        return repo.save(rol);
    }

    public Rol update(Rol rol) {
        return repo.save(rol);
    }
}
