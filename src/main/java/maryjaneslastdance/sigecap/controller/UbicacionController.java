package maryjaneslastdance.sigecap.controller;

import maryjaneslastdance.sigecap.config.Roles;
import maryjaneslastdance.sigecap.exception.BadRequestException;
import maryjaneslastdance.sigecap.model.Ubicacion;
import maryjaneslastdance.sigecap.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ubicaciones")
public class UbicacionController {
    @Autowired
    private UbicacionService service;
    @Secured(Roles.ADMIN)
    @GetMapping
    public String listarUbicaciones(Model model){
        model.addAttribute("ubicaciones",service.selectAll());
        return "ubicaciones/listar";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("ubicacion", new Ubicacion());
        return "ubicaciones/crear";
    }
    @Secured(Roles.ADMIN)
    @GetMapping("/{id}/editar")
    public String editar(Model model, @PathVariable int id){
        var ubi = service.select(id);
        if(ubi==null)
            throw new BadRequestException("No se encontro la ubicacion.");
        model.addAttribute("ubicacion",ubi);
        return "ubicaciones/editar";
    }
}
