package maryjaneslastdance.sigecap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.exception.InactiveUserException;
import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import maryjaneslastdance.sigecap.repo.UsuarioRepository;

@Service
public class SigecapUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository repo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, InactiveUserException {
		Usuario u = repo.findByEmail(username);
		if(u==null)
			throw new UsernameNotFoundException("Usuario no existe");
		if(!u.isActivo())
			throw new InactiveUserException("Usuario inactivo");
		return new UsuarioDetails(u);
	}

}
