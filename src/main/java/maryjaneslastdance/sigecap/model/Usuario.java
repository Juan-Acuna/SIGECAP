package maryjaneslastdance.sigecap.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Usuario {
	public Usuario() {}
	public Usuario(String nombres, String apellidos, String email, String pwd, Rol rol, boolean activo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.pwd = pwd;
		this.rol = rol;
		this.activo = activo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String nombres;
	private String apellidos;
	@Column(unique=true, nullable=false)
	private String email;
	@Column(nullable=false)
	private String pwd;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rol", nullable=false)
	private Rol rol;
	@Column(nullable=false)
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
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
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
	public Usuario ocultarPwd() {
		this.pwd=null;
		return this;
	}
}
