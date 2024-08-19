package maryjaneslastdance.sigecap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import maryjaneslastdance.sigecap.model.Usuario;
import maryjaneslastdance.sigecap.model.UsuarioDetails;
import maryjaneslastdance.sigecap.repo.UsuarioRepository;

@Service
public class SigecapUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = repo.findByEmail(username);
		if(u==null)
			throw new UsernameNotFoundException("Usuario no existe");
		return new UsuarioDetails(u);
	}

}
