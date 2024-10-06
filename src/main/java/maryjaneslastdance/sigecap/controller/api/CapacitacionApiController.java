package maryjaneslastdance.sigecap.controller.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Calificacion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioCapacitacion;
import maryjaneslastdance.sigecap.service.UsuarioCapacitacionService;
import maryjaneslastdance.sigecap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	@Autowired
	UsuarioService usuService;
	
	@GetMapping("/periodo/{inicio}/{fin}")
	public List<Capacitacion> consultarPeriodo(@PathVariable LocalDateTime inicio, @PathVariable LocalDateTime fin) {
		return service.getPeriodo(inicio, fin);
	}

	@GetMapping("/fecha/{fecha}")
	public List<Capacitacion> consultarFecha(@PathVariable LocalDateTime fecha) {
		return service.getFecha(fecha);
	}
	@Secured(Roles.ADMIN)
	@PostMapping
	public Capacitacion crearCapacitacion(@RequestBody Capacitacion capacitacion) {
		return service.insert(capacitacion);
	}
	@Secured({Roles.ADMIN, Roles.TUTOR})
	@PatchMapping
	public Capacitacion actualizarCapacitacion(@RequestBody Capacitacion capacitacion){
		return service.update(capacitacion);
	}
	@DeleteMapping("/{id}")
	public void eliminarCapacitacion(@PathVariable int id){
		service.delete(id);
	}
	@GetMapping("/{id}")
	public Capacitacion getCapacitacion(@PathVariable int id){
		return service.select(id);
	}
	@Secured(Roles.ADMIN)
	@GetMapping("/{id}/usuarios")
	public List<Usuario> usuariosPorCapacitacion(@PathVariable int id){
		var capacitacion = service.select(id);
		if(capacitacion==null)
			throw new BadRequestException("No se encontro la capacitacion.");
		return usuCapService.selectUsuarios(capacitacion);
	}
	@Secured(Roles.ADMIN)
	@PostMapping("/{id}/agregar")
	public List<UsuarioCapacitacion> agregarUsuarios(@RequestBody List<Usuario> usuarios, @PathVariable int id){
		var capacitacion = service.select(id);
		if(capacitacion==null)
			throw new BadRequestException("La capacitacion indicada no existe.");
		List<UsuarioCapacitacion> usuarioCap = new ArrayList<>();
		for(var u : usuarios){
			var us = usuService.getUsuario(u.getEmail());
			if(us==null)
				continue;
			usuarioCap.add(new UsuarioCapacitacion(us, capacitacion));
		}
		if(usuarioCap.isEmpty())
			throw new BadRequestException("No se ingreso ningun usuario");
		return usuCapService.insertAll(usuarioCap);
	}
	@Secured(Roles.ADMIN)
	@DeleteMapping("/{id}/usuarios/quitar/{usuario}")
	public void quitarUsuarios(@PathVariable int id, @PathVariable String usuario){
		var cap = service.select(id);
		if(cap==null)
			throw new BadRequestException("No se encontro la capacitacion.");
		var usu = usuService.getUsuario(usuario);
		if(usu==null)
			throw new BadRequestException("No se encontro el usuario.");
		usuCapService.delete(new UsuarioCapacitacion(usu, cap));
	}
	@Secured(Roles.TUTOR)
	@PatchMapping("/{id}/calificar")
	public UsuarioCapacitacion calificar(@PathVariable int id, @RequestBody Calificacion calificacion){
		var usuario = usuService.getUsuario(calificacion.getUsuario());
		if(usuario==null)
			throw new BadRequestException("No se encontro el usuario");
		var cap = service.select(id);
		if(cap==null)
			throw new BadRequestException("No se encontro la capacitacion.");
		UsuarioCapacitacion usuCap = usuCapService.select(usuario, cap);
		if(usuCap==null)
			throw new BadRequestException("El usuario no esta inscrito en la capacitacion.");
		usuCap.setNota(calificacion.getNota());
		usuCap.setComentarios(calificacion.getComentarios());
		return usuCapService.update(usuCap);
	}
}
