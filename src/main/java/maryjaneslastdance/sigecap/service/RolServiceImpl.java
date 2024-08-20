package maryjaneslastdance.sigecap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import maryjaneslastdance.sigecap.entity.Rol;
import maryjaneslastdance.sigecap.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository repositorio;
		
	@Override
	public List<Rol> listarRoles() {
		return repositorio.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return repositorio.save(rol);
	}

	@Override
	public Rol obtenerRolPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Rol editarRol(Rol rol) {
		return repositorio.save(rol);
	}

	@Override
	public void eliminarRol(Long id) {
		repositorio.deleteById(id);
	}
}
