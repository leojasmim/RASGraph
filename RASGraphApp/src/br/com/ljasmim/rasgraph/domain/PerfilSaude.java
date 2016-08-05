package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um perfil de serviço de saúde procurado por um paciente
 * quando o mesmo adoece
 *
 * @author LeonardoJasmim
 */
@Entity
public class PerfilSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descricao", unique = true)
    private String descricao;

    public PerfilSaude() {
    }

    public PerfilSaude(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.descricao);
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
        final PerfilSaude other = (PerfilSaude) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PerfilSaude{" + "id=" + id + ", descricao=" + descricao + '}';
    }

}
