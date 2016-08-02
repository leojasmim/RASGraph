package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa as doenças e agravos
 *
 * @author LeonardoJasmim
 */
@Entity
public class Doenca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codigoCID;

    private String descricao;

    public Doenca() {
    }

    public Doenca(long id, String codigoCID, String descricao) {
        this.id = id;
        this.codigoCID = codigoCID;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoCID() {
        return codigoCID;
    }

    public void setCodigoCID(String codigoCID) {
        this.codigoCID = codigoCID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 73 * hash + Objects.hashCode(this.codigoCID);
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
        final Doenca other = (Doenca) obj;
        if (!Objects.equals(this.codigoCID, other.codigoCID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doenca{" + "id=" + id + ", codigoCID=" + codigoCID + ", descricao=" + descricao + '}';
    }

    

}
