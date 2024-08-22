package maryjaneslastdance.sigecap.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails{
	
	private Usuario usuario;
	private Collection<GrantedAuthority> roles;
	
	public UsuarioDetails(Usuario usuario) {
		this.usuario=usuario;
		this.roles = Collections.singleton(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
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
	public String getEmail() {
		return this.usuario.getEmail();
	}
	public String getRol() {
		return this.usuario.getRol().getNombre();
	}
}
