package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe que representa uma Unidade de Saúde
 *
 * @author LeonardoJasmim
 */
@Entity
public class UnidadeSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cnes")
    private String codigoCnes;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipounidade_id")
    private TipoUnidade tipoUnidade;

    public UnidadeSaude() {
    }

    public UnidadeSaude(long id, String codigoCnes, String nome, TipoUnidade tipoUnidade) {
        this.id = id;
        this.codigoCnes = codigoCnes;
        this.nome = nome;
        this.tipoUnidade = tipoUnidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoCnes() {
        return codigoCnes;
    }

    public void setCodigoCnes(String codigoCnes) {
        this.codigoCnes = codigoCnes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUnidade getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(TipoUnidade tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.codigoCnes);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.tipoUnidade);
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
        final UnidadeSaude other = (UnidadeSaude) obj;
        if (!Objects.equals(this.codigoCnes, other.codigoCnes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnidadeSaude{" + "codigoCnes=" + codigoCnes + ", nome=" + nome + '}';
    }

}
