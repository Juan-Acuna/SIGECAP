package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import maryjaneslastdance.sigecap.service.CapacitacionService;

@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {
	
	@Autowired
	private CapacitacionService service;

	@GetMapping("/crear")
	public String crearCapacitacion(Model model) {
		model.addAttribute("capacitacion", new Capacitacion());
		return "frmCapacitacionCrear";
	}
	@GetMapping
	public String listarCapacitaciones(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails) {
		model.addAttribute("capacitacion", service.getCapacitaciones());
		return "listarCapacitaciones";
	}
}
