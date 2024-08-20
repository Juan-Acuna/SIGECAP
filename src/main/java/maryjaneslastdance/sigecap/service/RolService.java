package maryjaneslastdance.sigecap.service;

import java.util.List;
import maryjaneslastdance.sigecap.entity.Rol;


public interface RolService {
	public List<Rol> listarRoles();
	
	public Rol guardarRol(Rol rol);
	
	public Rol obtenerRolPorId(Long id);
	
	public Rol editarRol(Rol rol);
	
	public void eliminarRol(Long id);
}
