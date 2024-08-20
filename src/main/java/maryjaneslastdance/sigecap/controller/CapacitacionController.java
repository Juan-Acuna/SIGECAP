package maryjaneslastdance.sigecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import maryjaneslastdance.sigecap.entity.Capacitacion;
import maryjaneslastdance.sigecap.service.CapacitacionService;

import jakarta.servlet.http.HttpSession;


@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService servicio;
	
	@GetMapping("/capacitacion")
	public String listarCapacitaciones(Model modelo, HttpSession session) {
		session.removeAttribute("msg");
		modelo.addAttribute("capacitacion", servicio.listarCapacitaciones());
		return "frmCapacitacionListar";
	}
	
	@GetMapping("/capacitacion/frmCapacitacionCrear")
	public String crearCapacitacion(Model modelo) {
		Capacitacion capacita = new Capacitacion();
		modelo.addAttribute("capacitacion", capacita);
		return "frmCapacitacionCrear";
	}
	
	@PostMapping("/capacitacion/frmCapacitacionCrear")
	public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacita, HttpSession session) {
		servicio.guardarCapacitacion(capacita);
		session.setAttribute("msg", "Capacitación registrada exitosamente...");
		System.out.println(capacita);
		return "redirect:/capacitacion/frmCapacitacionCrear";
	}
	
	@GetMapping("/capacitacion/frmCapacitacionEditar/{id}")
	public String editarCapacitacion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("capacitacion", servicio.obtenerCapacitacionPorId(id));
		return "frmCapacitacionEditar";
	}
	
	@PostMapping("/capacitacion/frmCapacitacionEditar/{id}")
	public String actualizarCapacitacion(@PathVariable Long id, @ModelAttribute("capacitacion") Capacitacion capacita, Model modelo) {
		Capacitacion capacitaExistente = servicio.obtenerCapacitacionPorId(id);
		capacitaExistente.setId(id);
		capacitaExistente.setTitulo(capacita.getTitulo());
		capacitaExistente.setDescripcion(capacita.getDescripcion());
		capacitaExistente.setFechaIni(capacita.getFechaIni());
		capacitaExistente.setFechaTer(capacita.getFechaTer());
		capacitaExistente.setDuracionHrsCrono(capacita.getDuracionHrsCrono());
		capacitaExistente.setHrIni(capacita.getHrIni());
		capacitaExistente.setHrTer(capacita.getHrTer());
		capacitaExistente.setEstado(capacita.getEstado());
		servicio.editarCapacitacion(capacitaExistente);
		return "redirect:/capacitacion";
	}
	
	@GetMapping("/capacitacion/{id}")
	public String eliminarCapacitacion(@PathVariable Long id) {
		servicio.eliminarCapacitacion(id);
		return "redirect:/capacitacion";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}