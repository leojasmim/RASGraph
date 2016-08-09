package br.com.ljasmim.rasgraph.app;

import br.com.ljasmim.rasgraph.dao.AbastecimentoAguaDAO;
import br.com.ljasmim.rasgraph.dao.AtendimentoDAO;
import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.ColetaLixoDAO;
import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.dao.EsgotamentoDAO;
import br.com.ljasmim.rasgraph.dao.EspecialidadeDAO;
import br.com.ljasmim.rasgraph.dao.GrupoComunitarioDAO;
import br.com.ljasmim.rasgraph.dao.MeioComunicacaoDAO;
import br.com.ljasmim.rasgraph.dao.MeioTransporteDAO;
import br.com.ljasmim.rasgraph.dao.MunicipioDAO;
import br.com.ljasmim.rasgraph.dao.PacienteDAO;
import br.com.ljasmim.rasgraph.dao.PerfilSaudeDAO;
import br.com.ljasmim.rasgraph.dao.ProcedimentoDAO;
import br.com.ljasmim.rasgraph.dao.ProfissionalSaudeDAO;
import br.com.ljasmim.rasgraph.dao.RegistroDeAtendimentoDAO;
import br.com.ljasmim.rasgraph.dao.ResidenciaDAO;
import br.com.ljasmim.rasgraph.dao.TipoHabitacaoDAO;
import br.com.ljasmim.rasgraph.dao.TipoUnidadeDAO;
import br.com.ljasmim.rasgraph.dao.TratamentoAguaDAO;
import br.com.ljasmim.rasgraph.dao.UnidadeSaudeDAO;
import br.com.ljasmim.rasgraph.domain.AbastecimentoAgua;
import br.com.ljasmim.rasgraph.domain.Atendimento;
import br.com.ljasmim.rasgraph.domain.Bairro;
import br.com.ljasmim.rasgraph.domain.ColetaLixo;
import br.com.ljasmim.rasgraph.domain.Doenca;
import br.com.ljasmim.rasgraph.domain.Esgotamento;
import br.com.ljasmim.rasgraph.domain.Especialidade;
import br.com.ljasmim.rasgraph.domain.GeradorDeScript;
import br.com.ljasmim.rasgraph.domain.GrupoComunitario;
import br.com.ljasmim.rasgraph.domain.MeioComunicacao;
import br.com.ljasmim.rasgraph.domain.MeioTransporte;
import br.com.ljasmim.rasgraph.domain.Municipio;
import br.com.ljasmim.rasgraph.domain.Paciente;
import br.com.ljasmim.rasgraph.domain.PerfilSaude;
import br.com.ljasmim.rasgraph.domain.Procedimento;
import br.com.ljasmim.rasgraph.domain.ProfissionalSaude;
import br.com.ljasmim.rasgraph.domain.RegistroDeAtendimento;
import br.com.ljasmim.rasgraph.domain.Residencia;
import br.com.ljasmim.rasgraph.domain.TipoHabitacao;
import br.com.ljasmim.rasgraph.domain.TipoUnidade;
import br.com.ljasmim.rasgraph.domain.TratamentoAgua;
import br.com.ljasmim.rasgraph.domain.UnidadeSaude;
import br.com.ljasmim.rasgraph.util.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeonardoJasmim
 */
public class RASGraphConverter {

    private RegistroDeAtendimento registroGlobal;
    private RegistroDeAtendimentoDAO registroDAO;

    public RASGraphConverter() {
    }

    public void start() throws IOException {
        inicializarVariaveis();
        GeradorDeScript.createNewDatabase();
        carregaCsvFile(getPathsCsv());
    }

    public void converterRegistros() {
        long i = registroDAO.getFirst().getId();
        long n = i + registroDAO.count() - 1;

        while (i <= n) {
            registroGlobal = registroDAO.getByID(i);

        }
    }

    public void inicializarVariaveis() {
        registroDAO = new RegistroDeAtendimentoDAO();

    }

    public List<String> getPathsCsv() {
        List<String> paths = new ArrayList<>();
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_medicos-dados_abertos.csv");
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_dentistas-dados_abertos.csv");
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_enfermeiros-dados_abertos.csv");
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_outrosprofissionais-dados_abertos.csv");
        return paths;
    }

    public void carregaCsvFile(List<String> paths) throws IOException {
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";
        String scriptString = GeradorDeScript.getScriptStringForCopyCvs(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        GeradorDeScript.runBatchFile(scriptBatch);
        scriptBatch.delete();
        scriptSql.delete();
    }

    public Municipio buscaMunicipioDoRegistro(RegistroDeAtendimento registro) {
        Municipio m = new Municipio();
        MunicipioDAO mDAO = new MunicipioDAO();

        m.setNome(registro.getMunicipio());

        if (mDAO.find(m) != null) {
            return mDAO.find(m);
        } else {
            return mDAO.save(m);
        }
    }

    public Bairro buscaBairroDoRegistro(RegistroDeAtendimento registro) {
        Bairro b = new Bairro();
        BairroDAO bDAO = new BairroDAO();

        b.setMunicipio(buscaMunicipioDoRegistro(registro));
        b.setNome(registro.getBairro());

        if (bDAO.find(b) != null) {
            return bDAO.find(b);
        } else {
            return bDAO.save(b);
        }
    }

    public ColetaLixo buscaColetaLixoDoRegistro(RegistroDeAtendimento registro) {
        ColetaLixo lixo = new ColetaLixo();
        ColetaLixoDAO lixoDAO = new ColetaLixoDAO();

        lixo.setDescricao(registro.getDestinoLixo());

        if (lixoDAO.find(lixo) != null) {
            return lixoDAO.find(lixo);
        } else {
            return lixoDAO.save(lixo);
        }
    }

    public TratamentoAgua buscaTratamentoAguaDoRegistro(RegistroDeAtendimento registro) {
        TratamentoAgua agua = new TratamentoAgua();
        TratamentoAguaDAO aguaDAO = new TratamentoAguaDAO();

        agua.setDescricao(registro.getTratamentoAgua());

        if (aguaDAO.find(agua) != null) {
            return aguaDAO.find(agua);
        } else {
            return aguaDAO.save(agua);
        }
    }

    public TipoHabitacao buscaTipoHabitacaoDoRegistro(RegistroDeAtendimento registro) {
        TipoHabitacao habitacao = new TipoHabitacao();
        TipoHabitacaoDAO habitacaoDAO = new TipoHabitacaoDAO();

        habitacao.setDescricao(registro.getTipoHabitacao());

        if (habitacaoDAO.find(habitacao) != null) {
            return habitacaoDAO.find(habitacao);
        } else {
            return habitacaoDAO.save(habitacao);
        }
    }

    public AbastecimentoAgua buscaAbastecimentoAguaDoRegistro(RegistroDeAtendimento registro) {
        AbastecimentoAgua agua = new AbastecimentoAgua();
        AbastecimentoAguaDAO aguaDAO = new AbastecimentoAguaDAO();

        agua.setDescricao(registro.getAbastecimentoAgua());

        if (aguaDAO.find(agua) != null) {
            return aguaDAO.find(agua);
        } else {
            return aguaDAO.save(agua);
        }
    }

    public Esgotamento buscaEsgotamentoDoRegistro(RegistroDeAtendimento registro) {
        Esgotamento esgotamento = new Esgotamento();
        EsgotamentoDAO esgotamentoDAO = new EsgotamentoDAO();

        esgotamento.setDescricao(registro.getFezesUrina());

        if (esgotamentoDAO.find(esgotamento) != null) {
            return esgotamentoDAO.find(esgotamento);
        } else {
            return esgotamentoDAO.save(esgotamento);
        }
    }

    public Residencia getResidenciaDoRegistro(RegistroDeAtendimento registro) {
        Residencia residencia = new Residencia();

        residencia.setAbastecimentoAgua(buscaAbastecimentoAguaDoRegistro(registro));
        residencia.setBairro(buscaBairroDoRegistro(registro));
        residencia.setColetaLixo(buscaColetaLixoDoRegistro(registro));
        residencia.setComodos(Integer.parseInt(registro.getComodos()));
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean(registro.getEnergiaEletrica()));
        residencia.setEsgotamento(buscaEsgotamentoDoRegistro(registro));
        residencia.setTipo(buscaTipoHabitacaoDoRegistro(registro));
        residencia.setTratamentoAgua(buscaTratamentoAguaDoRegistro(registro));

        return residencia;
    }

    public Residencia saveNewResidencia(Residencia residencia) {
        ResidenciaDAO rDAO = new ResidenciaDAO();
        return rDAO.save(residencia);
    }

    public GrupoComunitario buscaGrupoComunitarioDoRegistro(RegistroDeAtendimento registro) {
        GrupoComunitario comunitario = new GrupoComunitario();
        GrupoComunitarioDAO comunitarioDAO = new GrupoComunitarioDAO();

        comunitario.setDescricao(registro.getGrupoComunitario());

        if (comunitarioDAO.find(comunitario) != null) {
            return comunitarioDAO.find(comunitario);
        } else {
            return comunitarioDAO.save(comunitario);
        }
    }

    public MeioComunicacao buscaMeioComunicacaoDoRegistro(RegistroDeAtendimento registro) {
        MeioComunicacao comunicacao = new MeioComunicacao();
        MeioComunicacaoDAO comunicacaoDAO = new MeioComunicacaoDAO();

        comunicacao.setDescricao(registro.getMeioComunicacao());

        if (comunicacaoDAO.find(comunicacao) != null) {
            return comunicacaoDAO.find(comunicacao);
        } else {
            return comunicacaoDAO.save(comunicacao);
        }
    }

    public MeioTransporte buscaMeioTransporteDoRegistro(RegistroDeAtendimento registro) {
        MeioTransporte transporte = new MeioTransporte();
        MeioTransporteDAO transporteDAO = new MeioTransporteDAO();

        transporte.setDescricao(registro.getMeioTransporte());

        if (transporteDAO.find(transporte) != null) {
            return transporteDAO.find(transporte);
        } else {
            return transporteDAO.save(transporte);
        }
    }

    public PerfilSaude buscaPerfilSaudeDoRegistro(RegistroDeAtendimento registro) {
        PerfilSaude perfilSaude = new PerfilSaude();
        PerfilSaudeDAO perfilSaudeDAO = new PerfilSaudeDAO();

        perfilSaude.setDescricao(registro.getEmCasoDoenca());

        if (perfilSaudeDAO.find(perfilSaude) != null) {
            return perfilSaudeDAO.find(perfilSaude);
        } else {
            return perfilSaudeDAO.save(perfilSaude);
        }
    }

    public Paciente buscaPacienteDoRegistro(RegistroDeAtendimento registro) {
        Paciente paciente = new Paciente();
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<Paciente> pacientes;

        paciente.setDataNascimento(Util.parseLocalToDateSql(registro.getDataAtendimento()));
        paciente.setGrupoComunitario(buscaGrupoComunitarioDoRegistro(registro));
        paciente.setMeioComunicacao(buscaMeioComunicacaoDoRegistro(registro));
        paciente.setMeioTransporte(buscaMeioTransporteDoRegistro(registro));
        paciente.setPerfilSaude(buscaPerfilSaudeDoRegistro(registro));
        paciente.setResidencia(getResidenciaDoRegistro(registro));
        paciente.setSexo(registro.getSexo());

        pacientes = pacienteDAO.find(paciente);

        for (Paciente p : pacientes) {
            if (paciente.equals(p)) {
                return p;
            }
        }

        paciente.setCodigo((int) (pacienteDAO.count() + 1));
        paciente.setResidencia(saveNewResidencia(paciente.getResidencia()));
        return pacienteDAO.save(paciente);
    }

    public TipoUnidade buscaTipoUnidadeDoRegistro(RegistroDeAtendimento registro) {
        TipoUnidade tipoUnidade = new TipoUnidade();
        TipoUnidadeDAO tipoUnidadeDAO = new TipoUnidadeDAO();

        tipoUnidade.setCodigo(registro.getTipoUnidadeCodigo());

        if (tipoUnidadeDAO.find(tipoUnidade) != null) {
            return tipoUnidadeDAO.find(tipoUnidade);
        } else {
            tipoUnidade.setDescricao(registro.getTipoUnidadeDescricao());
            return tipoUnidadeDAO.save(tipoUnidade);
        }
    }

    public UnidadeSaude buscaUnidadeSaudeDoRegistro(RegistroDeAtendimento registro) {
        UnidadeSaude unidade = new UnidadeSaude();
        UnidadeSaudeDAO unidadeDAO = new UnidadeSaudeDAO();

        unidade.setCnes(registro.getUnidadeCodigo());
        unidade.setNome(registro.getUnidadeDescricao());

        if (unidadeDAO.find(unidade) != null) {
            return unidadeDAO.find(unidade);
        } else {
            unidade.setTipoUnidade(buscaTipoUnidadeDoRegistro(registro));
            return unidadeDAO.save(unidade);
        }
    }

    public ProfissionalSaude buscaProfissionalSaudeDoRegistro(RegistroDeAtendimento registro) {
        ProfissionalSaude profissional = new ProfissionalSaude();
        ProfissionalSaudeDAO profissionalDAO = new ProfissionalSaudeDAO();

        profissional.setCbo(registro.getCboCodigo());

        if (profissionalDAO.find(profissional) != null) {
            return profissionalDAO.find(profissional);
        } else {
            profissional.setDescricao(registro.getCboDescricao());
            return profissionalDAO.save(profissional);
        }
    }

    public Procedimento buscaProcedimentoDoRegistro(RegistroDeAtendimento registro) {
        Procedimento procedimento = new Procedimento();
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();

        procedimento.setCodigo(registro.getProcedimentoCodigo());

        if (procedimentoDAO.find(procedimento) != null) {
            return procedimentoDAO.find(procedimento);
        } else {
            procedimento.setDescricao(registro.getProcedimentoDescricao());
            return procedimentoDAO.save(procedimento);
        }
    }

    public Especialidade buscaEspecialidadeDoRegistro(RegistroDeAtendimento registro) {
        Especialidade especialidade = new Especialidade();
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

        if (Util.converteStringSimOuNaoToBoolean(registro.getEncaminhadoAoEspecialista())) {
            especialidade.setArea(registro.getAreaAtuacaoEspecialista());
            if (especialidadeDAO.find(especialidade) != null) {
                return especialidadeDAO.find(especialidade);
            } else {
                return especialidadeDAO.save(especialidade);
            }
        } else {
            return null;
        }

    }

    public Doenca buscaDoencaDoRegitro(RegistroDeAtendimento registro) {
        Doenca doenca = new Doenca();
        DoencaDAO doencaDAO = new DoencaDAO();

        doenca.setCid(registro.getCidCodigo());
        doenca.setDescricao(registro.getCidDescricao());

        if (doencaDAO.find(doenca) != null) {
            return doencaDAO.find(doenca);
        } else {
            return doencaDAO.save(doenca);
        }
    }

//    public Atendimento converteRegistroParaAtendimento(RegistroDeAtendimento registro) {
//        Atendimento atendimento = new Atendimento();
//        
//    }
}
