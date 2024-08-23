package maryjaneslastdance.sigecap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Rol rol;
	
	

	@Column(name = "nombres", nullable = false, length = 45)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 45)
	private String apellidos;
	
	@Column(name = "email", nullable = false, length = 45)
	private String email;
	
	@Column(name = "pwd", nullable = false, length = 200)
	private String password;
	
	@Column(name = "estado", nullable = false, length = 1)
	private Boolean estado;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombres, String apellidos, String email, String password, Boolean estado) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.rol = rol;
	}

	public Usuario(String nombres, String apellidos, String email, String password, Boolean estado, Rol rol) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", estado=" + estado + "]";
	}

	
}
