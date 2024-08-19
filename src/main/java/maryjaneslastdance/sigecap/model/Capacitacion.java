package maryjaneslastdance.sigecap.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Capacitacion {
	protected Capacitacion() {}
	public Capacitacion(String titulo, String descripcion, LocalDate inicio, LocalDate fin) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descripcion;
	private LocalDate inicio;
	private LocalDate fin;
	@OneToMany(mappedBy="capacitacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UsuarioCapacitacion> usuarioCapacitaciones = new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public Set<UsuarioCapacitacion> getUsuarioCapacitaciones() {
		return usuarioCapacitaciones;
	}
	public void setUsuarioCapacitaciones(Set<UsuarioCapacitacion> usuarioCapacitaciones) {
		this.usuarioCapacitaciones = usuarioCapacitaciones;
	}
}
