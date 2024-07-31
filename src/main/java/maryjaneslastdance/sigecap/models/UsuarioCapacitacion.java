package maryjaneslastdance.sigecap.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class UsuarioCapacitacion {
	
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
}
