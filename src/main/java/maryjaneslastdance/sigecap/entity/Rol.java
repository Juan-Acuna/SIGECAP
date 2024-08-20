package maryjaneslastdance.sigecap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	//@Column(name = "estado", nullable = false, length = 1)
	@Column(name = "estado", nullable = true, length = 1)
	private Boolean estado;

	public Rol() {
		
	}

	public Rol(Long id, String nombre, Boolean estado) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
	
}
