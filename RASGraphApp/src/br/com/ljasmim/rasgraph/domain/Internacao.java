package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe que representa uma internacao
 *
 * @author LeonardoJasmim
 */
@Entity
public class Internacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Timestamp dataInternacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unid_solic_id")
    private UnidadeSaude unidadeSolicitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unid_dest_id")
    private UnidadeSaude unidadeDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doenca_id")
    private Doenca doenca;

    public Internacao() {
    }

    public Internacao(long id, Timestamp dataInternacao, UnidadeSaude unidadeSolicitante, UnidadeSaude unidadeDestino, Doenca doenca) {
        this.id = id;
        this.dataInternacao = dataInternacao;
        this.unidadeSolicitante = unidadeSolicitante;
        this.unidadeDestino = unidadeDestino;
        this.doenca = doenca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(Timestamp dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public UnidadeSaude getUnidadeSolicitante() {
        return unidadeSolicitante;
    }

    public void setUnidadeSolicitante(UnidadeSaude unidadeSolicitante) {
        this.unidadeSolicitante = unidadeSolicitante;
    }

    public UnidadeSaude getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(UnidadeSaude unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.dataInternacao);
        hash = 41 * hash + Objects.hashCode(this.unidadeSolicitante);
        hash = 41 * hash + Objects.hashCode(this.unidadeDestino);
        hash = 41 * hash + Objects.hashCode(this.doenca);
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
        final Internacao other = (Internacao) obj;
        if (!Objects.equals(this.dataInternacao, other.dataInternacao)) {
            return false;
        }
        if (!Objects.equals(this.unidadeSolicitante, other.unidadeSolicitante)) {
            return false;
        }
        if (!Objects.equals(this.unidadeDestino, other.unidadeDestino)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Internacao{" + "id=" + id + '}';
    }
    
}
