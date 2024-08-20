package maryjaneslastdance.sigecap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Time;
import java.util.Date;
import java.util.Locale.IsoCountryCode;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Capacitacion")
public class Capacitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 45)
	private String titulo;
	
	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;
	
	@Column(name = "fchInicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaIni;
	
	@Column(name = "fchTermino")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaTer;
	
	@Column(name = "hrInicio")
	private Time hrIni;
	
	@Column(name = "hrTermino")
	private Time hrTer;
	
	@Column(name = "duracionHrsCrono")
	private int duracionHrsCrono;
	
	@Column(name = "estado", nullable = false, length = 1)
	private Boolean estado;

	public Capacitacion() {
		
	}

	public Capacitacion(Long id, String titulo, String descripcion, Date fechaIni, Date fechaTer, Time hrIni,
			Time hrTer, int duracionHrsCrono, Boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaIni = fechaIni;
		this.fechaTer = fechaTer;
		this.hrIni = hrIni;
		this.hrTer = hrTer;
		this.duracionHrsCrono = duracionHrsCrono;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaTer() {
		return fechaTer;
	}

	public void setFechaTer(Date fechaTer) {
		this.fechaTer = fechaTer;
	}

	public Time getHrIni() {
		return hrIni;
	}

	public void setHrIni(Time hrIni) {
		this.hrIni = hrIni;
	}

	public Time getHrTer() {
		return hrTer;
	}

	public void setHrTer(Time hrTer) {
		this.hrTer = hrTer;
	}

	public int getDuracionHrsCrono() {
		return duracionHrsCrono;
	}

	public void setDuracionHrsCrono(int duracionHrsCrono) {
		this.duracionHrsCrono = duracionHrsCrono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaIni="
				+ fechaIni + ", fechaTer=" + fechaTer + ", hrIni=" + hrIni + ", hrTer=" + hrTer + ", duracionHrsCrono="
				+ duracionHrsCrono + ", estado=" + estado + "]";
	}
	
	
	
	
}
