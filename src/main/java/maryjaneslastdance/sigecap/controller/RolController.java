package maryjaneslastdance.sigecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import maryjaneslastdance.sigecap.entity.Rol;
import maryjaneslastdance.sigecap.service.RolService;


@Controller
public class RolController {

	@Autowired
	private RolService servicio;

	@GetMapping("/rol")
	public String listarRoles(Model modelo, HttpSession session) {
		session.removeAttribute("msg");
		modelo.addAttribute("rol", servicio.listarRoles());
		return "frmRolListar";
	}

	@GetMapping("/rol/frmRolCrear")
	public String crearRol(Model modelo) {
		Rol rol = new Rol();
		modelo.addAttribute("rol", rol);
		return "frmRolCrear";
	}
	
	@PostMapping("/rol/frmRolCrear")
	public String guardarRol(@ModelAttribute("rol") Rol rol, HttpSession session) {
		servicio.guardarRol(rol);
		session.setAttribute("msg", "Rol registrado exitosamente...");
		System.out.println(rol);
		return "redirect:/rol/frmRolCrear";
	}
	
	@GetMapping("/rol/frmRolEditar/{id}")
	public String editarRol(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("rol", servicio.obtenerRolPorId(id));
		return "frmRolEditar";
	}
	
	@PostMapping("/rol/frmRolEditar/{id}")
	public String actualizarRol(@PathVariable Long id, @ModelAttribute("rol") Rol rol, Model modelo) {
		Rol rolExistente = servicio.obtenerRolPorId(id);
		rolExistente.setId(id);
		rolExistente.setNombre(rol.getNombre());
		rolExistente.setEstado(rol.getEstado());
		servicio.editarRol(rolExistente);
		return "redirect:/rol";
	}
	
	@GetMapping("/rol/{id}")
	public String eliminarRol(@PathVariable Long id) {
		servicio.eliminarRol(id);
		return "redirect:/rol";
	}
}
