package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Sesion;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import maryjaneslastdance.sigecap.service.UsuarioService;
import maryjaneslastdance.sigecap.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private RolService rolService;
    @Secured(Roles.ADMIN)
    @GetMapping
    public String listarUsuarios(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
        var usuario = service.getUsuario(usuarioDetails.getEmail());
        if(usuario==null)
            throw new BadRequestException("Sesion invalida.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        model.addAttribute("usuarios", service.selectAll());
        return "usuarios/listar";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/crear")
    public String crearCapacitacion(Model model, @AuthenticationPrincipal UsuarioDetails usuarioDetails) {
        var usuario = service.getUsuario(usuarioDetails.getEmail());
        if(usuario==null)
            throw new BadRequestException("Sesion invalida.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.selectAll());
        return "usuarios/crear";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/{id}/editar")
    public String editar(Model model, @PathVariable int id, @AuthenticationPrincipal UsuarioDetails usuarioDetails){
        var usuario = service.select(id);
        if(usuario==null)
            throw new BadRequestException("No se encontro al usuario.");
        model.addAttribute("sesion", new Sesion(usuario, null, 0));
        model.addAttribute("usuario",usuario);
        model.addAttribute("roles", rolService.selectAll());
        return "usuarios/editar";
    }
}
