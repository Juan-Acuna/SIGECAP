package maryjaneslastdance.sigecap.controller.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.service.UsuarioCapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import maryjaneslastdance.sigecap.model.Capacitacion;
import maryjaneslastdance.sigecap.service.CapacitacionService;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionApiController {
	
	@Autowired
	CapacitacionService service;

	@Autowired
	UsuarioCapacitacionService usuCapService;
	
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
	}
	@PatchMapping
	public Capacitacion actualizarCapacitacion(@RequestBody Capacitacion capacitacion){
		return service.update(capacitacion);
	}
	@DeleteMapping("/{id}")
	public void eliminarCapacitacion(@PathVariable int id){
		service.delete(id);
	}
	@GetMapping("/{id}/usuarios")
	public List<Usuario> usuariosPorCapacitacion(@PathVariable int id){
		var capacitacion = service.select(id);
		if(capacitacion==null)
			throw new BadRequestException("No se encontro la capacitacion.");
		return usuCapService.selectUsuarios(capacitacion);
	}
	@PostMapping("/agregar/{id}")
	public List<UsuarioCapacitacion> agregarUsuarios(@RequestBody List<Usuario> usuarios, @PathVariable int idCapacitacion){
		var capacitacion = service.select(idCapacitacion);
		if(capacitacion==null)
			throw new BadRequestException("La capacitacion indicada no existe.");
		List<UsuarioCapacitacion> usuarioCap = new ArrayList<>();
		for(var u : usuarios){
			usuarioCap.add(new UsuarioCapacitacion(u, capacitacion));
		}
		if(usuarioCap.isEmpty())
			throw new BadRequestException("No se ingreso ningun usuario");
		return usuCapService.insertAll(usuarioCap);
	}
}
