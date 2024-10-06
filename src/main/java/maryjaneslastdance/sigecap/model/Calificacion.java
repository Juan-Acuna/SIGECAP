package maryjaneslastdance.sigecap.model;

public class Calificacion {
    private String usuario;
    private Float nota;
    private String comentarios;
    public Calificacion(String usuario, Float nota, String comentarios) {
        this.usuario = usuario;
        this.nota = nota;
        this.comentarios = comentarios;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Float getNota() {
        return nota;
    }
    public void setNota(Float nota) {
        this.nota = nota;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
