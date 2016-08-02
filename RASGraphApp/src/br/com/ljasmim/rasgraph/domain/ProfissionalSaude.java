package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
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

    private String codigoCbo;

    private String descricao;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(long id, String codigoCbo, String descricao) {
        this.id = id;
        this.codigoCbo = codigoCbo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoCbo() {
        return codigoCbo;
    }

    public void setCodigoCbo(String codigoCbo) {
        this.codigoCbo = codigoCbo;
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
        hash = 59 * hash + Objects.hashCode(this.codigoCbo);
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
        if (!Objects.equals(this.codigoCbo, other.codigoCbo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfissionalSaude{" + "id=" + id + ", codigoCbo=" + codigoCbo + ", descricao=" + descricao + '}';
    }

    
}
