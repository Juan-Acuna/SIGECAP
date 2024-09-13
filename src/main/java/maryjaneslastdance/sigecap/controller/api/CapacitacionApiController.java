package maryjaneslastdance.sigecap.controller.api;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.service.CapacitacionService;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionApiController {
	
	@Autowired
	CapacitacionService service;
	
	@GetMapping("/periodo/{inicio}/{fin}")
	public List<Capacitacion> consultarPeriodo(@PathVariable LocalDateTime inicio, @PathVariable LocalDateTime fin) {
		return service.getPeriodo(inicio, fin);
	}

	@GetMapping("/fecha/{fecha}")
	public List<Capacitacion> consultarFecha(@PathVariable LocalDateTime fecha) {
		return service.getFecha(fecha);
	}

	@PostMapping
	public Capacitacion crearCapacitacion(@RequestBody Capacitacion capacitacion) {
		
		return service.insert(capacitacion);
		//return "redirect:~/capacitacion/frmCapacitacionCrear";
	}
	@PatchMapping
	public Capacitacion actualizarCapacitacion(@RequestBody Capacitacion capacitacion){
		return service.update(capacitacion);
	}
	@DeleteMapping("/{id}")
	public void eliminarCapacitacion(@PathVariable int id){
		service.delete(id);
	}
}
