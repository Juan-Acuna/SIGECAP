package maryjaneslastdance.sigecap.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Capacitacion {
	public Capacitacion() {}

	public Capacitacion(String titulo, String descripcion, LocalDateTime inicio, LocalDateTime fin, int maxAlumnos, int maxTutores) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.maxAlumnos = maxAlumnos;
		this.maxTutores = maxTutores;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descripcion;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	@Column(nullable = true)
	private int maxAlumnos = 20;
	@Column(nullable = true)
	private int maxTutores = 2;

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
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getMaxTutores() {
        return maxTutores;
    }

    public void setMaxTutores(int maxTutores) {
        this.maxTutores = maxTutores;
    }
}
