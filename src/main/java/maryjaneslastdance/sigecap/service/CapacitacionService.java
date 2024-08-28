package maryjaneslastdance.sigecap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.repo.CapacitacionRepository;

@Service
public class CapacitacionService {
	
	@Autowired
	CapacitacionRepository capRepo;
	
	
	public boolean validarDisponibilidad() {
		
		
		return true;
	}

}
