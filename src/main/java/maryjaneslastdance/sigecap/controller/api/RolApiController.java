package maryjaneslastdance.sigecap.controller.api;

import maryjaneslastdance.sigecap.model.Rol;
import maryjaneslastdance.sigecap.model.Ubicacion;
import maryjaneslastdance.sigecap.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolApiController {
    @Autowired
    private RolService service;
    @GetMapping
    public List<Rol> listarRoles(){
        return service.selectAll();
    }
    @GetMapping("/{id}")
    public Rol rol(@PathVariable int id){
        return service.select(id);
    }
    @PostMapping
    public Rol crear(@RequestBody Rol rol){
        return service.insert(rol);
    }
    @PatchMapping
    public Rol actualizar(@RequestBody Rol rol){
        return service.update(rol);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        service.delete(id);
    }
}
