package maryjaneslastdance.sigecap.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class UsuarioCapacitacionId {
	private Integer idUsu;
    private Integer idCap;

    public Integer getUsuarioId() {
        return idUsu;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.idUsu = usuarioId;
    }

    public Integer getCapacitacionId() {
        return idCap;
    }

    public void setCapacitacionId(Integer capacitacionId) {
        this.idCap = capacitacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCapacitacionId that = (UsuarioCapacitacionId) o;
        return Objects.equals(idUsu, that.idUsu) && Objects.equals(idCap, that.idCap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsu, idCap);
    }
}
