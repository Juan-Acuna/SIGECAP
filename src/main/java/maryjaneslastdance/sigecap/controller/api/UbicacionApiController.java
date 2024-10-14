package maryjaneslastdance.sigecap.controller.api;

import maryjaneslastdance.sigecap.model.Ubicacion;
import maryjaneslastdance.sigecap.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionApiController {
    @Autowired
    private UbicacionService service;

    @GetMapping
    public List<Ubicacion> listarUbicaciones(){
        return service.selectAll();
    }
    @GetMapping("/{id}")
    public Ubicacion ubicacion(@PathVariable int id){
        return service.select(id);
    }
    @PostMapping
    public Ubicacion crearUbicacion(@RequestBody Ubicacion ubicacion){
        return service.insert(ubicacion);
    }
    @PatchMapping
    public Ubicacion actualizarUbicacion(@RequestBody Ubicacion ubicacion){
        return service.update(ubicacion);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        service.delete(id);
    }
}
