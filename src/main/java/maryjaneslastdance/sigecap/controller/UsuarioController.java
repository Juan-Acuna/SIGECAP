package maryjaneslastdance.sigecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import maryjaneslastdance.sigecap.entity.Usuario;
import maryjaneslastdance.sigecap.service.UsuarioService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/usuario")
	public String listarUsuarios(Model modelo, HttpSession session) {
		session.removeAttribute("msg");
		modelo.addAttribute("usuario", servicio.listarUsuarios());
		return "frmUsuarioListar";
	}
	
	@GetMapping("/usuario/frmUsuarioCrear")
	public String crearUsuario(Model modelo) {
		Usuario usr = new Usuario();
		modelo.addAttribute("usuario", usr);
		return "frmUsuarioCrear";
	}
	
	@PostMapping("/usuario/frmUsuarioCrear")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usr, HttpSession session) {
		servicio.guardarUsuario(usr);
		session.setAttribute("msg", "Usuario registrado exitosamente...");
		System.out.println(usr);
		return "redirect:/usuario/frmUsuarioCrear";
	}

	@GetMapping("/usuario/frmUsuarioEditar/{id}")
	public String editarUsuario(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
		return "frmUsuarioEditar";
	}
	
	@PostMapping("/usuario/frmUsuarioEditar/{id}")
	public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usr, Model modelo) {
		Usuario usrExistente = servicio.obtenerUsuarioPorId(id);
		usrExistente.setId(id);
		usrExistente.setNombres(usr.getNombres());
		usrExistente.setApellidos(usr.getApellidos());
		usrExistente.setEmail(usr.getEmail());
		usrExistente.setEstado(usr.getEstado());
		usrExistente.setPassword(usr.getPassword());
		servicio.editarUsuario(usrExistente);
		return "redirect:/usuario";
	}
	
	@GetMapping("/usuario/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		servicio.eliminarUsuario(id);
		return "redirect:/usuario";
	}
	
}
