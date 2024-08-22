package maryjaneslastdance.sigecap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import maryjaneslastdance.sigecap.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/login")
	public Sesion login(@RequestBody Usuario usuario) {
		return service.verificarUsuario(usuario);
	}
	
	@Secured(Roles.ADMIN)
	@PostMapping("/registrar")
	public Usuario registrar(@RequestBody Usuario usuario) {
		return service.registrar(usuario);
	}
	
	@Secured(Roles.ADMIN)
	@GetMapping
	public List<Usuario> usuarios(){
		return service.listarUsuarios();
	}
	
	@Secured(Roles.ADMIN)
	@GetMapping("/{email}")
	public Usuario usuario(@PathVariable String email) {
		return service.getUsuario(email).ocultarPwd();
	}
	
	@GetMapping("/perfil")
	public Usuario perfil(@AuthenticationPrincipal UsuarioDetails usuarioDetails) {
		return service.getPerfilUsuario(usuarioDetails).ocultarPwd();
	}
	
	@PostMapping
	public Usuario updateUsuario(@RequestBody Usuario usuario, @AuthenticationPrincipal UsuarioDetails usuarioDetails) {
		return service.actualizarUsuario(usuario, usuarioDetails).ocultarPwd();
	}
}
