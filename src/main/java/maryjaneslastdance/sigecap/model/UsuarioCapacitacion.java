package maryjaneslastdance.sigecap.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class UsuarioCapacitacion {
	
	public UsuarioCapacitacion() {}
	
	public UsuarioCapacitacion(Usuario usuario, Capacitacion capacitacion) {
		this.id = new UsuarioCapacitacionId(usuario, capacitacion);
		this.usuario=usuario;
		this.capacitacion=capacitacion;
	}
	
	@EmbeddedId
	private UsuarioCapacitacionId id = new UsuarioCapacitacionId();
	@ManyToOne
	@MapsId("idUsu")
	@JoinColumn(name="id_usu")
	private Usuario usuario;
	@ManyToOne
	@MapsId("idCap")
	@JoinColumn(name="id_cap")
	private Capacitacion capacitacion;
	@Column(nullable=true)
	private Float nota;
	public UsuarioCapacitacionId getId() {
		return id;
	}
	public void setId(UsuarioCapacitacionId id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Capacitacion getCapacitacion() {
		return capacitacion;
	}
	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
}
