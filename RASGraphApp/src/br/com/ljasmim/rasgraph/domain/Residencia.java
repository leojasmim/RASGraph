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
 * Classe que representa uma residência
 *
 * @author LeonardoJasmim
 */
@Entity
public class Residencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "energia")
    private String energiaEletrica;

    @Column(name = "comodos")
    private int comodos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coletalixo_id")
    private ColetaLixo coletaLixo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tratamentoagua_id")
    private TratamentoAgua tratamentoAgua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipohabitacao_id")
    private TipoHabitacao tipoHabitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abastecimentoagua_id")
    private AbastecimentoAgua abastecimentoAgua;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "esgotamento_id")
    private Esgotamento esgotamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bairro_id")
    private Bairro bairro;

    public Residencia() {
    }

    public Residencia(long id, String energiaEletrica, int comodos, ColetaLixo coletaLixo, TratamentoAgua tratamentoAgua, TipoHabitacao tipoHabitacao, AbastecimentoAgua abastecimentoAgua, Esgotamento esgotamento, Bairro bairro) {
        this.id = id;
        this.energiaEletrica = energiaEletrica;
        this.comodos = comodos;
        this.coletaLixo = coletaLixo;
        this.tratamentoAgua = tratamentoAgua;
        this.tipoHabitacao = tipoHabitacao;
        this.abastecimentoAgua = abastecimentoAgua;
        this.esgotamento = esgotamento;
        this.bairro = bairro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnergiaEletrica() {
        return energiaEletrica;
    }

    public void setEnergiaEletrica(String energiaEletrica) {
        this.energiaEletrica = energiaEletrica;
    }

    public int getComodos() {
        return comodos;
    }

    public void setComodos(int comodos) {
        this.comodos = comodos;
    }

    public ColetaLixo getColetaLixo() {
        return coletaLixo;
    }

    public void setColetaLixo(ColetaLixo coletaLixo) {
        this.coletaLixo = coletaLixo;
    }

    public TratamentoAgua getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(TratamentoAgua tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public TipoHabitacao getTipoHabitacao() {
        return tipoHabitacao;
    }

    public void setTipoHabitacao(TipoHabitacao tipoHabitacao) {
        this.tipoHabitacao = tipoHabitacao;
    }

    public AbastecimentoAgua getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(AbastecimentoAgua abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public Esgotamento getEsgotamento() {
        return esgotamento;
    }

    public void setEsgotamento(Esgotamento esgotamento) {
        this.esgotamento = esgotamento;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.energiaEletrica);
        hash = 59 * hash + this.comodos;
        hash = 59 * hash + Objects.hashCode(this.coletaLixo);
        hash = 59 * hash + Objects.hashCode(this.tratamentoAgua);
        hash = 59 * hash + Objects.hashCode(this.tipoHabitacao);
        hash = 59 * hash + Objects.hashCode(this.abastecimentoAgua);
        hash = 59 * hash + Objects.hashCode(this.esgotamento);
        hash = 59 * hash + Objects.hashCode(this.bairro);
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
        final Residencia other = (Residencia) obj;
        if (!Objects.equals(this.energiaEletrica, other.energiaEletrica)) {
            return false;
        }
        if (this.comodos != other.comodos) {
            return false;
        }
        if (!Objects.equals(this.coletaLixo, other.coletaLixo)) {
            return false;
        }
        if (!Objects.equals(this.tratamentoAgua, other.tratamentoAgua)) {
            return false;
        }
        if (!Objects.equals(this.tipoHabitacao, other.tipoHabitacao)) {
            return false;
        }
        if (!Objects.equals(this.abastecimentoAgua, other.abastecimentoAgua)) {
            return false;
        }
        if (!Objects.equals(this.esgotamento, other.esgotamento)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Residencia{" + "id=" + id + '}';
    }
        
}
