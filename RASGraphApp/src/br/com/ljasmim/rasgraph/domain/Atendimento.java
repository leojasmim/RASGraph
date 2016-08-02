package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe que representa um atendimento
 *
 * @author LeonardoJasmim
 */
@Entity
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String dataAtendimento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadesaude_id") 
    @Column(name = "unid_atend_id")
    private UnidadeSaude unidadeAtendimento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doenca_id") 
    private Doenca doenca;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "internacao_id") 
    private Internacao internacao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialista_id") 
    private Especialista especialista;
    
    private boolean solicitadoExame;
    
    @Column(name = "qtd_med_prescrita")
    private int qtdMedicacaoPrescrita;
    
    @Column(name = "qtd_med_dispensada")
    private int qtdMedicacaoDispensada;
    
    @Column(name = "qtd_med_npadrao")
    private int qtdMedicacaoNaoPadrao;

    public Atendimento() {
    }

    public Atendimento(long id, String dataAtendimento, Paciente paciente, Procedimento procedimento, UnidadeSaude unidadeAtendimento, Doenca doenca, Internacao internacao, Especialista especialista, boolean solicitadoExame, int qtdMedicacaoPrescrita, int qtdMedicacaoDispensada, int qtdMedicacaoNaoPadrao) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.paciente = paciente;
        this.procedimento = procedimento;
        this.unidadeAtendimento = unidadeAtendimento;
        this.doenca = doenca;
        this.internacao = internacao;
        this.especialista = especialista;
        this.solicitadoExame = solicitadoExame;
        this.qtdMedicacaoPrescrita = qtdMedicacaoPrescrita;
        this.qtdMedicacaoDispensada = qtdMedicacaoDispensada;
        this.qtdMedicacaoNaoPadrao = qtdMedicacaoNaoPadrao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public UnidadeSaude getUnidadeAtendimento() {
        return unidadeAtendimento;
    }

    public void setUnidadeAtendimento(UnidadeSaude unidadeAtendimento) {
        this.unidadeAtendimento = unidadeAtendimento;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Internacao getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public boolean isSolicitadoExame() {
        return solicitadoExame;
    }

    public void setSolicitadoExame(boolean solicitadoExame) {
        this.solicitadoExame = solicitadoExame;
    }

    public int getQtdMedicacaoPrescrita() {
        return qtdMedicacaoPrescrita;
    }

    public void setQtdMedicacaoPrescrita(int qtdMedicacaoPrescrita) {
        this.qtdMedicacaoPrescrita = qtdMedicacaoPrescrita;
    }

    public int getQtdMedicacaoDispensada() {
        return qtdMedicacaoDispensada;
    }

    public void setQtdMedicacaoDispensada(int qtdMedicacaoDispensada) {
        this.qtdMedicacaoDispensada = qtdMedicacaoDispensada;
    }

    public int getQtdMedicacaoNaoPadrao() {
        return qtdMedicacaoNaoPadrao;
    }

    public void setQtdMedicacaoNaoPadrao(int qtdMedicacaoNaoPadrao) {
        this.qtdMedicacaoNaoPadrao = qtdMedicacaoNaoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.dataAtendimento);
        hash = 59 * hash + Objects.hashCode(this.paciente);
        hash = 59 * hash + Objects.hashCode(this.procedimento);
        hash = 59 * hash + Objects.hashCode(this.unidadeAtendimento);
        hash = 59 * hash + Objects.hashCode(this.doenca);
        hash = 59 * hash + Objects.hashCode(this.internacao);
        hash = 59 * hash + Objects.hashCode(this.especialista);
        hash = 59 * hash + (this.solicitadoExame ? 1 : 0);
        hash = 59 * hash + this.qtdMedicacaoPrescrita;
        hash = 59 * hash + this.qtdMedicacaoDispensada;
        hash = 59 * hash + this.qtdMedicacaoNaoPadrao;
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
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.dataAtendimento, other.dataAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.procedimento, other.procedimento)) {
            return false;
        }
        if (!Objects.equals(this.unidadeAtendimento, other.unidadeAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", paciente=" + paciente + '}';
    }
    
}
