package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um especialista
 *
 * @author LeonardoJasmim
 */
@Entity
public class Especialidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "area", unique = true)
    private String area;

    public Especialidade() {
    }

    public Especialidade(long id, String area) {
        this.id = id;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.area);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidade other = (Especialidade) obj;
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especialidade{" + "id=" + id + ", area=" + area + '}';
    }

}
