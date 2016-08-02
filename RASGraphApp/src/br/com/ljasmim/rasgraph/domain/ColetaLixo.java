package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa o tipo de coleta de lixo realizada na residência
 *
 * @author LeonardoJasmim
 */
@Entity
public class ColetaLixo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "destino")
    private String destino;

    public ColetaLixo(long id, String destino) {
        this.id = id;
        this.destino = destino;
    }

    public ColetaLixo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.destino);
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
        final ColetaLixo other = (ColetaLixo) obj;
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ColetaLixo{" + "id=" + id + ", destino=" + destino + '}';
    }
}
