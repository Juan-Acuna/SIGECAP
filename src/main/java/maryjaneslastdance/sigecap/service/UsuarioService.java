package maryjaneslastdance.sigecap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;
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
			String token = jwt.generarToken(usuario);
			return new Sesion(usuario, token);
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
}
