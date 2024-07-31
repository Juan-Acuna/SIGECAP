package maryjaneslastdance.sigecap.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Usuario {
	protected Usuario() {}
	public Usuario(String nombres, String apellidos, String email, String pwd, Integer id_rol, boolean activo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.pwd = pwd;
		this.id_rol = id_rol;
		this.activo = activo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String email;
	private String pwd;
	private Integer id_rol;
	private boolean activo;
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UsuarioCapacitacion> usuarioCapacitaciones = new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getId_rol() {
		return id_rol;
	}
	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<UsuarioCapacitacion> getUsuarioCapacitaciones() {
		return usuarioCapacitaciones;
	}
	public void setUsuarioCapacitaciones(Set<UsuarioCapacitacion> usuarioCapacitaciones) {
		this.usuarioCapacitaciones = usuarioCapacitaciones;
	}
}
