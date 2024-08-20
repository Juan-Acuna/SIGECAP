package maryjaneslastdance.sigecap.service;

import java.util.List;
import maryjaneslastdance.sigecap.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listarUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario editarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
}
