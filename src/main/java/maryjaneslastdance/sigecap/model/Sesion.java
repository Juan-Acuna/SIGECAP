package maryjaneslastdance.sigecap.model;


public class Sesion {
	private String email;
	private String token;
	private int rol;
	private int duracion;
	public Sesion(Usuario usuario, String token, int duracion) {
		this.email = usuario.getEmail();
		this.token = token;
		this.rol = usuario.getRol().getId();
		this.duracion = duracion;
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
