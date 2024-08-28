package maryjaneslastdance.sigecap.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import maryjaneslastdance.sigecap.service.CapacitacionService;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionController{
	
	@Autowired
	CapacitacionService service;
	
}
