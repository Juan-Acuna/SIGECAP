package maryjaneslastdance.sigecap.model;


public class Sesion {
	private String email;
	private String token;
	private int rol;
	public Sesion(Usuario usuario, String token) {
		this.email = usuario.getEmail();
		this.token = token;
		this.rol = usuario.getRol().getId();
	}
	public String getEmail() {
		return email;
	}
	public String getToken() {
		return token;
	}
	public int getRol() {
		return rol;
	}
}
