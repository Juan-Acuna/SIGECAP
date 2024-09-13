package maryjaneslastdance.sigecap.model;

import jakarta.persistence.*;

@Entity
public class Rol {
	protected Rol() {}
	public Rol(String nombre) {
		this.nombre = nombre;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String nombre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
