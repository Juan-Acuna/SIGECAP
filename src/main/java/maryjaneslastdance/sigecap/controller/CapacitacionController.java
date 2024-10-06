package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.*;
import maryjaneslastdance.sigecap.service.UsuarioCapacitacionService;
import maryjaneslastdance.sigecap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import maryjaneslastdance.sigecap.service.CapacitacionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {
	
	@Autowired
	private CapacitacionService service;
	@Autowired
	private UsuarioCapacitacionService usuCapService;
	@Autowired
	private UsuarioService usuarioService;

	@Secured(Roles.ADMIN)
	@GetMapping("/crear")
	public String crearCapacitacion(Model model) {
		model.addAttribute("capacitacion", new Capacitacion());
		model.addAttribute("ahora", LocalDateTime.now().toString().substring(0,10));
		return "frmCapacitacionCrear";
	}
	@GetMapping
	public String listarCapacitaciones(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails) {
		var usuario = usuarioService.getUsuario(usuarioDetails.getEmail());
		if(usuario==null)
			throw new BadRequestException("Sesion invalida.");
		List<Capacitacion> caps;
		Map<Integer, Integer> alumnos = new HashMap<>();
		Map<Integer, Integer> tutores = new HashMap<>();
		switch (usuarioDetails.getRol()) {
			case Roles.ADMIN:
				caps = service.getCapacitaciones();
				for(var c : caps){
					alumnos.put(c.getId(), usuCapService.getConteoAlumnos(c));
					tutores.put(c.getId(), usuCapService.getConteoTutores(c));
				}
				break;
			case Roles.ALUMNO:
			case Roles.TUTOR:
				caps = usuCapService.selectCapacitaciones(usuario);
				break;
			default:
				throw new BadRequestException("Sesion invalida.");
		};
		model.addAttribute("sesion", new Sesion(usuario, null, 0));
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("tutores", tutores);
		model.addAttribute("capacitacion", caps);
		return "listarCapacitaciones";
	}
	@GetMapping("/{id}")
	public String verCapacitacion(Model model, @PathVariable int id, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
		var usuario = usuarioService.getUsuario(usuarioDetails.getEmail());
		if(usuario==null)
			throw new BadRequestException("Sesion invalida.");
		var capacitacion = service.select(id);
		if(capacitacion==null)
			throw new BadRequestException("No se encontro la capacitacion");
		Map<String, List<Usuario>> usuarios = new HashMap<>();
		usuarios.put("tutores", usuCapService.getTutores(capacitacion));
		usuarios.put("alumnos", usuCapService.getAlumnos(capacitacion));
		model.addAttribute("capacitacion",capacitacion);
		model.addAttribute("usuarios", usuarios);
		if(usuarioDetails.getRol().equals("Tutor")){
			Map<String, Calificacion> calificaciones = new HashMap<>();
			usuCapService.getCalificaciones(capacitacion).forEach(c->calificaciones.put(c.getUsuario(), c));
			model.addAttribute("calificaciones",calificaciones);
		}
		model.addAttribute("sesion", new Sesion(usuario, null, 0));
		return "verCapacitacion";
	}
}
