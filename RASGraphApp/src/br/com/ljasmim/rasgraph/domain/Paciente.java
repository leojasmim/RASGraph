package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe que representa um paciente
 *
 * @author LeonardoJasmim
 */
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int codigo;

    private String dataNascimento;

    private String sexo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "residencia_id")
    private Residencia residencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupocomunitario_id")
    private GrupoComunitario grupoComunitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meiocomunicacao_id")
    private MeioComunicacao meioComunicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meiotransporte_id")
    private MeioTransporte meioTransporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfilsaude_id")
    private PerfilSaude perfilSaude;

    public Paciente() {
    }

    public Paciente(long id, int codigo, String dataNascimento, String sexo, Residencia residencia, GrupoComunitario grupoComunitario, MeioComunicacao meioComunicacao, MeioTransporte meioTransporte, PerfilSaude perfilSaude) {
        this.id = id;
        this.codigo = codigo;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.residencia = residencia;
        this.grupoComunitario = grupoComunitario;
        this.meioComunicacao = meioComunicacao;
        this.meioTransporte = meioTransporte;
        this.perfilSaude = perfilSaude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.residencia);
        hash = 97 * hash + Objects.hashCode(this.grupoComunitario);
        hash = 97 * hash + Objects.hashCode(this.meioComunicacao);
        hash = 97 * hash + Objects.hashCode(this.meioTransporte);
        hash = 97 * hash + Objects.hashCode(this.perfilSaude);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.residencia, other.residencia)) {
            return false;
        }
        if (!Objects.equals(this.grupoComunitario, other.grupoComunitario)) {
            return false;
        }
        if (!Objects.equals(this.meioComunicacao, other.meioComunicacao)) {
            return false;
        }
        if (!Objects.equals(this.meioTransporte, other.meioTransporte)) {
            return false;
        }
        if (!Objects.equals(this.perfilSaude, other.perfilSaude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", codigo=" + codigo + '}';
    }

}
