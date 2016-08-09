package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um profissional de saúde
 *
 * @author LeonardoJasmim
 */
@Entity
public class ProfissionalSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String cbo;

    @Column(unique = true, nullable = false)
    private String descricao;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(long id, String cbo, String descricao) {
        this.id = id;
        this.cbo = cbo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
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
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.cbo);
        hash = 59 * hash + Objects.hashCode(this.descricao);
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
        final ProfissionalSaude other = (ProfissionalSaude) obj;
        if (!Objects.equals(this.cbo, other.cbo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfissionalSaude{" + "id=" + id + ", codigoCbo=" + cbo + ", descricao=" + descricao + '}';
    }

}
