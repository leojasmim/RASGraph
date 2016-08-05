package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
import java.sql.Timestamp;
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

    private Timestamp dataAtendimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profsaude_id")
    private ProfissionalSaude profissionalSaude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unid_atend_id")
    private UnidadeSaude unidadeAtendimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doenca_id")
    private Doenca doenca;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidade_id")
    private Especialidade encaminhadoParaEspecialidade;

    private boolean solicitadoExame;

    @Column(name = "qtd_med_prescrita")
    private int qtdMedicacaoPrescrita;

    @Column(name = "qtd_med_dispensada")
    private int qtdMedicacaoDispensada;

    @Column(name = "qtd_med_npadrao")
    private int qtdMedicacaoNaoPadrao;

    public Atendimento() {
    }

    public Atendimento(long id, Timestamp dataAtendimento, Paciente paciente, ProfissionalSaude profissionalSaude, Procedimento procedimento, UnidadeSaude unidadeAtendimento, Doenca doenca, Internacao internacao, Especialidade encaminhadoParaEspecialidade, boolean solicitadoExame, int qtdMedicacaoPrescrita, int qtdMedicacaoDispensada, int qtdMedicacaoNaoPadrao) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.paciente = paciente;
        this.profissionalSaude = profissionalSaude;
        this.procedimento = procedimento;
        this.unidadeAtendimento = unidadeAtendimento;
        this.doenca = doenca;
        this.internacao = internacao;
        this.encaminhadoParaEspecialidade = encaminhadoParaEspecialidade;
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

    public Timestamp getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Timestamp dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalSaude getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
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

    public Especialidade getEncaminhadoParaEspecialidade() {
        return encaminhadoParaEspecialidade;
    }

    public void setEncaminhadoParaEspecialidade(Especialidade encaminhadoParaEspecialidade) {
        this.encaminhadoParaEspecialidade = encaminhadoParaEspecialidade;
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
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dataAtendimento);
        hash = 53 * hash + Objects.hashCode(this.paciente);
        hash = 53 * hash + Objects.hashCode(this.profissionalSaude);
        hash = 53 * hash + Objects.hashCode(this.procedimento);
        hash = 53 * hash + Objects.hashCode(this.unidadeAtendimento);
        hash = 53 * hash + Objects.hashCode(this.doenca);
        hash = 53 * hash + Objects.hashCode(this.internacao);
        hash = 53 * hash + Objects.hashCode(this.encaminhadoParaEspecialidade);
        hash = 53 * hash + (this.solicitadoExame ? 1 : 0);
        hash = 53 * hash + this.qtdMedicacaoPrescrita;
        hash = 53 * hash + this.qtdMedicacaoDispensada;
        hash = 53 * hash + this.qtdMedicacaoNaoPadrao;
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
        if (!Objects.equals(this.profissionalSaude, other.profissionalSaude)) {
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
        if (!Objects.equals(this.internacao, other.internacao)) {
            return false;
        }
        if (!Objects.equals(this.encaminhadoParaEspecialidade, other.encaminhadoParaEspecialidade)) {
            return false;
        }
        if (this.solicitadoExame != other.solicitadoExame) {
            return false;
        }
        if (this.qtdMedicacaoPrescrita != other.qtdMedicacaoPrescrita) {
            return false;
        }
        if (this.qtdMedicacaoDispensada != other.qtdMedicacaoDispensada) {
            return false;
        }
        if (this.qtdMedicacaoNaoPadrao != other.qtdMedicacaoNaoPadrao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + '}';
    }

}
