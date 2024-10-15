package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Rol;
import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import maryjaneslastdance.sigecap.service.RolService;
import maryjaneslastdance.sigecap.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService service;
    @Autowired
    private UsuarioService usuService;

    @Secured(Roles.ADMIN)
    @GetMapping
    public String listar(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
        var usuario = usuService.getUsuario(usuarioDetails.getEmail());
        if(usuario==null)
            throw new BadRequestException("Sesion invalida.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        model.addAttribute("roles",service.selectAll());
        return "roles/listar";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/crear")
    public String crear(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
        var usuario = usuService.getUsuario(usuarioDetails.getEmail());
        if(usuario==null)
            throw new BadRequestException("Sesion invalida.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        model.addAttribute("rol", new Rol());
        return "roles/crear";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/{id}/editar")
    public String editar(Model model, @PathVariable int id, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
        var usuario = usuService.getUsuario(usuarioDetails.getEmail());
        if(usuario==null)
            throw new BadRequestException("Sesion invalida.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        var rol = service.select(id);
        if(rol==null)
            throw new BadRequestException("No se encontro el rol.");
        model.addAttribute("rol",rol);
        return "roles/editar";
    }
}
