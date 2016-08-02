package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
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
public class Especialista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String areaAtuacao;

    public Especialista() {
    }

    public Especialista(long id, String areaAtuacao) {
        this.id = id;
        this.areaAtuacao = areaAtuacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.areaAtuacao);
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
        final Especialista other = (Especialista) obj;
        if (!Objects.equals(this.areaAtuacao, other.areaAtuacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especialista{" + "areaAtuacao=" + areaAtuacao + '}';
    }
    
}
