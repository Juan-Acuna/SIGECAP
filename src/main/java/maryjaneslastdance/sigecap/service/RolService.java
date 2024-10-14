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
}
