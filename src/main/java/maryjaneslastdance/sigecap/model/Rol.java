package maryjaneslastdance.sigecap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {
	protected Rol() {}
	public Rol(String nombre) {
		this.nombre = nombre;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRol;
	private String nombre;
	public Integer getId() {
		return idRol;
	}
	public void setId(Integer id) {
		this.idRol = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
