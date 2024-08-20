package maryjaneslastdance.sigecap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	@GetMapping("/")
	public String verPaginaIndex() {
		return "index";
	}
	
	@GetMapping("/autentica")
	public String verPaginaAutenticacion() {
		return "autentica";
	}
	
	@GetMapping("/inicio")
	public String verPaginaInicio() {
		return "inicio";
	}
}
