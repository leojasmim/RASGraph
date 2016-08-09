package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe que representa as doenças e agravos
 *
 * @author LeonardoJasmim
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cid", "descricao"})})
public class Doenca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cid;
    
    @Column(nullable = false)
    private String descricao;

    public Doenca() {
    }

    public Doenca(long id, String cid, String descricao) {
        this.id = id;
        this.cid = cid;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
        hash = 73 * hash + Objects.hashCode(this.cid);
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
        if (!Objects.equals(this.cid, other.cid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doenca{" + "id=" + id + ", CID=" + cid + ", descricao=" + descricao + '}';
    }

}
