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
 * Classe que representa a entidade Municipio
 *
 * @author LeonardoJasmim
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ibge", "nome"})})
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private int ibge;
    
    @Column(nullable = false)
    private String regiaoFederal;
    
    @Column(nullable = false)
    private int codigoUf;
    
    @Column(nullable = false)
    private String uf;
    
    @Column(nullable = false)
    private String nome;

    private int populacao2015;

    public Municipio() {
    }

    public Municipio(long id, int ibge, String regiaoFederal, int codigoUf, String uf, String nome, int populacao2015) {
        this.id = id;
        this.ibge = ibge;
        this.regiaoFederal = regiaoFederal;
        this.codigoUf = codigoUf;
        this.uf = uf;
        this.nome = nome;
        this.populacao2015 = populacao2015;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public String getRegiaoFederal() {
        return regiaoFederal;
    }

    public void setRegiaoFederal(String regiaoFederal) {
        this.regiaoFederal = regiaoFederal;
    }

    public int getCodigoUf() {
        return codigoUf;
    }

    public void setCodigoUf(int codigoUf) {
        this.codigoUf = codigoUf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao2015() {
        return populacao2015;
    }

    public void setPopulacao2015(int populacao2015) {
        this.populacao2015 = populacao2015;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + this.ibge;
        hash = 29 * hash + Objects.hashCode(this.regiaoFederal);
        hash = 29 * hash + this.codigoUf;
        hash = 29 * hash + Objects.hashCode(this.uf);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + this.populacao2015;
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
        final Municipio other = (Municipio) obj;
        if (this.ibge != other.ibge) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", ibge=" + ibge + ", uf=" + uf + ", nome=" + nome + '}';
    }
        
}
