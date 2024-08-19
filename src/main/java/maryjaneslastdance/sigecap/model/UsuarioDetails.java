package maryjaneslastdance.sigecap.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetails implements UserDetails{
	
	private Usuario usuario;
	private Collection<GrantedAuthority> roles;
	
	public UsuarioDetails(Usuario usuario) {
		this.usuario=usuario;
		this.roles = Collections.singleton(new SimpleGrantedAuthority(rolToString(usuario.getId_rol())));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	
	public int getId() {
		return this.usuario.getId();
	}

	@Override
	public String getPassword() {
		return this.usuario.getPwd();
	}

	@Override
	public String getUsername() {
		return this.usuario.getEmail();
	}
	
	@Override
	public boolean isEnabled() {
		return usuario.isActivo();
	}
	
	private String rolToString(int rol) {
		switch(rol) {
		case 1:
			return "Administrador";
		case 2:
			return "Tutor";
		default:
			return "Alumno";
		}
	}

}
