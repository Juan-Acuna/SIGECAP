package maryjaneslastdance.sigecap.model;


public class Sesion {
	private int id;
	private String email;
	private String token;
	private int rol;
	public Sesion(Usuario usuario, String token) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.token = token;
		this.rol = usuario.getRol().getId();
	}
	public int getId() {
		return id;
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
