package maryjaneslastdance.sigecap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;
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
	
	@PostMapping("/registrar")
	public Usuario registrar(@RequestBody Usuario usuario) {
		return service.registrar(usuario);
	}
	
	@GetMapping
	public List<Usuario> usuarios(){
		return service.listarUsuarios();
	}
}
