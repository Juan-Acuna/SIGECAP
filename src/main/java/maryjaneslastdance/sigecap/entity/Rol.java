package maryjaneslastdance.sigecap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name = "Rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "rol")
	private List<Usuario> lstUsuarios;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	//@Column(name = "estado", nullable = false, length = 1)
	@Column(name = "estado", nullable = true, length = 1)
	private Boolean estado;

	public Rol() {
		
	}

	public Rol(Long id, List<Usuario> lstUsuarios, String nombre, Boolean estado) {
		super();
		this.id = id;
		this.lstUsuarios = lstUsuarios;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", lstUsuarios=" + lstUsuarios + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
