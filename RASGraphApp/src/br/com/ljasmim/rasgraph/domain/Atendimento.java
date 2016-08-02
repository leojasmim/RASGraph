package br.com.ljasmim.rasgraph.domain;

import java.io.Serializable;
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
    
}
