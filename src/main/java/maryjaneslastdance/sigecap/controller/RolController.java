package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Rol;
import maryjaneslastdance.sigecap.model.Ubicacion;
import maryjaneslastdance.sigecap.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Secured(Roles.ADMIN)
    @GetMapping
    public String listar(Model model){
        model.addAttribute("roles",service.selectAll());
        return "roles/listar";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("rol", new Rol());
        return "roles/crear";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/{id}/editar")
    public String editar(Model model, @PathVariable int id){
        var rol = service.select(id);
        if(rol==null)
            throw new BadRequestException("No se encontro el rol.");
        model.addAttribute("rol",rol);
        return "roles/editar";
    }
}
