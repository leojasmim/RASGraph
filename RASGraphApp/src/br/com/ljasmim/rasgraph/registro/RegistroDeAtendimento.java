package br.com.ljasmim.rasgraph.registro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe para armazenar os dados referentes ao registro de atendimento do
 * Sistema E-Saude
 *
 * @author LeonardoJasmim
 *
 */
@Entity
public class RegistroDeAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "a_dt_atend")
    private String dataAtendimento;
    
    @Column(name = "b_dt_nasc")
    private String dataNascimento;
    
    @Column(name = "c_sexo")
    private String sexo;
    
    @Column(name = "d_tipounid_cod")
    private String tipoUnidadeCodigo;

    @Column(name = "e_tipounid_desc")
    private String tipoUnidadeDescricao;
    
    @Column(name = "f_unid_cod")
    private String unidadeCodigo;
    
    @Column(name = "g_unid_desc")
    private String unidadeDescricao;
    
    @Column(name = "h_proc_cod")
    private String procedimentoCodigo;
    
    @Column(name = "i_proc_desc")
    private String procedimentoDescricao;
    
    @Column(name = "j_cbo_cod")
    private String cboCodigo;
    
    @Column(name = "k_cbo_desc")
    private String cboDescricao;
    
    @Column(name = "l_cid_cod")
    private String cidCodigo;
    
    @Column(name = "m_cid_desc")
    private String cidDescricao;
    
    @Column(name = "n_sol_exame")
    private String solicitacaoExame;
    
    @Column(name = "o_qtdmed_presc")
    private String qtdMedicacaoPrescrita;
    
    @Column(name = "p_qtdmed_disp")
    private String qtdMedicacaoDispensada;
    
    @Column(name = "q_qtdmed_npadrao")
    private String qtdMedicacaoNaoPadronizada;
    
    @Column(name = "r_enc_esp")
    private String encaminhadoAoEspecialista;
    
    @Column(name = "s_area_atuacao")
    private String areaAtuacaoEspecialista;
    
    @Column(name = "t_enc_inter")
    private String encaminhadoParaIntenacao;
    
    @Column(name = "u_dt_inter")
    private String dataInternacao;
    
    @Column(name = "v_unid_sol_inter")
    private String unidadeSolicitanteInternacao;
    
    @Column(name = "w_unid_dest_inter")
    private String unidadeDestinoInternacao;
    
    @Column(name = "x_cid_inter")
    private String cidInternacao;
    
    @Column(name = "y_trat_agua")
    private String tratamentoAgua;
    
    @Column(name = "z_abast_agua")
    private String abastecimentoAgua;
    
    @Column(name = "za_energia")
    private String energiaEletrica;
    
    @Column(name = "zb_tipo_hab")
    private String tipoHabitacao;
    
    @Column(name = "zc_dest_lixo")
    private String destinoLixo;
    
    @Column(name = "zd_fezes_urina")
    private String fezesUrina;
    
    @Column(name = "ze_comodos")
    private String comodos;
    
    @Column(name = "zf_caso_doenca")
    private String emCasoDoenca;
    
    @Column(name = "zg_grupo_comun")
    private String grupoComunitario;
    
    @Column(name = "zh_meio_comun")
    private String meioComunicacao;
    
    @Column(name = "zi_meio_transp")
    private String meioTransporte;
    
    @Column(name = "zj_municipio")
    private String municipio;
    
    @Column(name = "zk_bairro")
    private String bairro;

    public RegistroDeAtendimento(String dataAtendimento, String dataNascimento,
            String sexo, String tipoUnidadeCodigo, String tipoUnidadeDescricao,
            String unidadeCodigo, String unidadeDescricao, String procedimentoCodigo,
            String procedimentoDescricao, String cboCodigo, String cboDescricao,
            String cidCodigo, String cidDescricao, String solicitacaoExame,
            String qtdMedicacaoPrescrita, String qtdMedicacaoDispensada,
            String qtdMedicacaoNaoPadronizada, String encaminhadoAoEspecialista,
            String areaAtuacaoEspecialista, String encaminhadoParaIntenacao,
            String dataInternacao, String unidadeSolicitanteInternacao,
            String unidadeDestinoInternacao, String cidInternacao, String tratamentoAgua,
            String abastecimentoAgua, String energiaEletrica, String tipoHabitacao,
            String destinoLixo, String fezesUrina, String comodos, String emCasoDoenca,
            String grupoComunitario, String meioComunicacao, String meioTransporte,
            String municipio, String bairro) {
        this.dataAtendimento = dataAtendimento;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipoUnidadeCodigo = tipoUnidadeCodigo;
        this.tipoUnidadeDescricao = tipoUnidadeDescricao;
        this.unidadeCodigo = unidadeCodigo;
        this.unidadeDescricao = unidadeDescricao;
        this.procedimentoCodigo = procedimentoCodigo;
        this.procedimentoDescricao = procedimentoDescricao;
        this.cboCodigo = cboCodigo;
        this.cboDescricao = cboDescricao;
        this.cidCodigo = cidCodigo;
        this.cidDescricao = cidDescricao;
        this.solicitacaoExame = solicitacaoExame;
        this.qtdMedicacaoPrescrita = qtdMedicacaoPrescrita;
        this.qtdMedicacaoDispensada = qtdMedicacaoDispensada;
        this.qtdMedicacaoNaoPadronizada = qtdMedicacaoNaoPadronizada;
        this.encaminhadoAoEspecialista = encaminhadoAoEspecialista;
        this.areaAtuacaoEspecialista = areaAtuacaoEspecialista;
        this.encaminhadoParaIntenacao = encaminhadoParaIntenacao;
        this.dataInternacao = dataInternacao;
        this.unidadeSolicitanteInternacao = unidadeSolicitanteInternacao;
        this.unidadeDestinoInternacao = unidadeDestinoInternacao;
        this.cidInternacao = cidInternacao;
        this.tratamentoAgua = tratamentoAgua;
        this.abastecimentoAgua = abastecimentoAgua;
        this.energiaEletrica = energiaEletrica;
        this.tipoHabitacao = tipoHabitacao;
        this.destinoLixo = destinoLixo;
        this.fezesUrina = fezesUrina;
        this.comodos = comodos;
        this.emCasoDoenca = emCasoDoenca;
        this.grupoComunitario = grupoComunitario;
        this.meioComunicacao = meioComunicacao;
        this.meioTransporte = meioTransporte;
        this.municipio = municipio;
        this.bairro = bairro;
    }

    public RegistroDeAtendimento() {
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoUnidadeCodigo() {
        return tipoUnidadeCodigo;
    }

    public void setTipoUnidadeCodigo(String tipoUnidadeCodigo) {
        this.tipoUnidadeCodigo = tipoUnidadeCodigo;
    }

    public String getTipoUnidadeDescricao() {
        return tipoUnidadeDescricao;
    }

    public void setTipoUnidadeDescricao(String tipoUnidadeDescricao) {
        this.tipoUnidadeDescricao = tipoUnidadeDescricao;
    }

    public String getUnidadeCodigo() {
        return unidadeCodigo;
    }

    public void setUnidadeCodigo(String unidadeCodigo) {
        this.unidadeCodigo = unidadeCodigo;
    }

    public String getUnidadeDescricao() {
        return unidadeDescricao;
    }

    public void setUnidadeDescricao(String unidadeDescricao) {
        this.unidadeDescricao = unidadeDescricao;
    }

    public String getProcedimentoCodigo() {
        return procedimentoCodigo;
    }

    public void setProcedimentoCodigo(String procedimentoCodigo) {
        this.procedimentoCodigo = procedimentoCodigo;
    }

    public String getProcedimentoDescricao() {
        return procedimentoDescricao;
    }

    public void setProcedimentoDescricao(String procedimentoDescricao) {
        this.procedimentoDescricao = procedimentoDescricao;
    }

    public String getCboCodigo() {
        return cboCodigo;
    }

    public void setCboCodigo(String cboCodigo) {
        this.cboCodigo = cboCodigo;
    }

    public String getCboDescricao() {
        return cboDescricao;
    }

    public void setCboDescricao(String cboDescricao) {
        this.cboDescricao = cboDescricao;
    }

    public String getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(String cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getCidDescricao() {
        return cidDescricao;
    }

    public void setCidDescricao(String cidDescricao) {
        this.cidDescricao = cidDescricao;
    }

    public String getSolicitacaoExame() {
        return solicitacaoExame;
    }

    public void setSolicitacaoExame(String solicitacaoExame) {
        this.solicitacaoExame = solicitacaoExame;
    }

    public String getQtdMedicacaoPrescrita() {
        return qtdMedicacaoPrescrita;
    }

    public void setQtdMedicacaoPrescrita(String qtdMedicacaoPrescrita) {
        this.qtdMedicacaoPrescrita = qtdMedicacaoPrescrita;
    }

    public String getQtdMedicacaoDispensada() {
        return qtdMedicacaoDispensada;
    }

    public void setQtdMedicacaoDispensada(String qtdMedicacaoDispensada) {
        this.qtdMedicacaoDispensada = qtdMedicacaoDispensada;
    }

    public String getQtdMedicacaoNaoPadronizada() {
        return qtdMedicacaoNaoPadronizada;
    }

    public void setQtdMedicacaoNaoPadronizada(String qtdMedicacaoNaoPadronizada) {
        this.qtdMedicacaoNaoPadronizada = qtdMedicacaoNaoPadronizada;
    }

    public String getEncaminhadoAoEspecialista() {
        return encaminhadoAoEspecialista;
    }

    public void setEncaminhadoAoEspecialista(String encaminhadoAoEspecialista) {
        this.encaminhadoAoEspecialista = encaminhadoAoEspecialista;
    }

    public String getAreaAtuacaoEspecialista() {
        return areaAtuacaoEspecialista;
    }

    public void setAreaAtuacaoEspecialista(String areaAtuacaoEspecialista) {
        this.areaAtuacaoEspecialista = areaAtuacaoEspecialista;
    }

    public String getEncaminhadoParaIntenacao() {
        return encaminhadoParaIntenacao;
    }

    public void setEncaminhadoParaIntenacao(String encaminhadoParaIntenacao) {
        this.encaminhadoParaIntenacao = encaminhadoParaIntenacao;
    }

    public String getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(String dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public String getUnidadeSolicitanteInternacao() {
        return unidadeSolicitanteInternacao;
    }

    public void setUnidadeSolicitanteInternacao(String unidadeSolicitanteInternacao) {
        this.unidadeSolicitanteInternacao = unidadeSolicitanteInternacao;
    }

    public String getUnidadeDestinoInternacao() {
        return unidadeDestinoInternacao;
    }

    public void setUnidadeDestinoInternacao(String unidadeDestinoInternacao) {
        this.unidadeDestinoInternacao = unidadeDestinoInternacao;
    }

    public String getCidInternacao() {
        return cidInternacao;
    }

    public void setCidInternacao(String cidInternacao) {
        this.cidInternacao = cidInternacao;
    }

    public String getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(String tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public String getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(String abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public String getEnergiaEletrica() {
        return energiaEletrica;
    }

    public void setEnergiaEletrica(String energiaEletrica) {
        this.energiaEletrica = energiaEletrica;
    }

    public String getTipoHabitacao() {
        return tipoHabitacao;
    }

    public void setTipoHabitacao(String tipoHabitacao) {
        this.tipoHabitacao = tipoHabitacao;
    }

    public String getDestinoLixo() {
        return destinoLixo;
    }

    public void setDestinoLixo(String destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public String getFezesUrina() {
        return fezesUrina;
    }

    public void setFezesUrina(String fezesUrina) {
        this.fezesUrina = fezesUrina;
    }

    public String getComodos() {
        return comodos;
    }

    public void setComodos(String comodos) {
        this.comodos = comodos;
    }

    public String getEmCasoDoenca() {
        return emCasoDoenca;
    }

    public void setEmCasoDoenca(String emCasoDoenca) {
        this.emCasoDoenca = emCasoDoenca;
    }

    public String getGrupoComunitario() {
        return grupoComunitario;
    }

    public void setGrupoComunitario(String grupoComunitario) {
        this.grupoComunitario = grupoComunitario;
    }

    public String getMeioComunicacao() {
        return meioComunicacao;
    }

    public void setMeioComunicacao(String meioComunicacao) {
        this.meioComunicacao = meioComunicacao;
    }

    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
