package maryjaneslastdance.sigecap.service;

import java.util.List;

import maryjaneslastdance.sigecap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.repo.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private JWTService jwt;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Sesion verificarUsuario(Usuario usuario) {
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPwd()));
		if(auth.isAuthenticated()) {
			usuario = repo.findByEmail(usuario.getEmail());
			String token = jwt.generarToken(usuario, 3);
			return new Sesion(usuario, token, jwt.HORAS_DURACION_JWT);
		}
		return null;
	}
	
	public Usuario registrar(Usuario usuario) {
		usuario.setPwd(passwordEncoder.encode(usuario.getPwd()));
		return repo.save(usuario);
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) repo.findAll();
		usuarios.forEach(u -> u.ocultarPwd());
		return usuarios;
	}

	public Usuario getUsuario(String email) {
		return repo.findByEmail(email).ocultarPwd();
	}

	public Usuario getPerfilUsuario(UsuarioDetails usuarioDetails) {
		return repo.findByEmail(usuarioDetails.getEmail()).ocultarPwd();
	}

	public Usuario actualizarUsuario(Usuario usuario, UsuarioDetails usuarioDetails) {
		boolean isAdmin = usuarioDetails.getRol().equals(Roles.ADMIN);
		if(!isAdmin) {
			usuario.setEmail(usuarioDetails.getEmail());
		}
		Usuario old = repo.findByEmail(usuario.getEmail());
		if(usuario.getNombres()!=null)
			old.setNombres(usuario.getNombres());
		if(usuario.getApellidos()!=null)
			old.setApellidos(usuario.getApellidos());
		if(isAdmin && verificarRol(usuario.getRol()))
			old.setRol(usuario.getRol());
		if(usuario.getPwd()!=null)
			old.setPwd(passwordEncoder.encode(usuario.getPwd()));
		return repo.save(old);
	}
	private boolean verificarRol(Rol r) {
		if(r==null)
			return false;
		switch(r.getId()) {
		case 1:
			r.setNombre(Roles.ADMIN);
			break;
		case 2:
			r.setNombre(Roles.ALUMNO);
			break;
		case 3:
			r.setNombre(Roles.TUTOR);
			break;
		default:
			return false;
		}
		return true;
	}
	public List<Usuario> selectAlumnosNotIn(Capacitacion capacitacion) {
		return repo.alumnosNotIn(capacitacion);
	}
    public List<Usuario> selectTutoresNotIn(Capacitacion capacitacion) {
		return repo.tutoresNotIn(capacitacion);
    }

    public List<Usuario> selectAll() {
		return (List<Usuario>) repo.findAll();
    }
	public Usuario select(int id) {
		return repo.findById(id).orElse(null);
	}
}
