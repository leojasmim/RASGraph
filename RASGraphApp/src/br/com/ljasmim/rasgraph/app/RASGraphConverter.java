package br.com.ljasmim.rasgraph.app;

import br.com.ljasmim.rasgraph.dao.AbastecimentoAguaDAO;
import br.com.ljasmim.rasgraph.dao.AtendimentoDAO;
import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.ColetaLixoDAO;
import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.dao.EsgotamentoDAO;
import br.com.ljasmim.rasgraph.dao.EspecialidadeDAO;
import br.com.ljasmim.rasgraph.dao.GrupoComunitarioDAO;
import br.com.ljasmim.rasgraph.dao.InternacaoDAO;
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
import br.com.ljasmim.rasgraph.domain.Internacao;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que converte um registro de atendimento para a base do RASGraph
 *
 * @author LeonardoJasmim
 */
public class RASGraphConverter {

    PrintStream consoleLog;

    public RASGraphConverter() throws FileNotFoundException {
        String logPath = "log\\log" + Util.getNowSqlDateString() + ".txt";
        consoleLog = new PrintStream(new File(logPath));
        System.setOut(consoleLog);
    }

    public void start() throws IOException {
        verificaDatabase();
        converterRegistros();
    }

    public void verificaDatabase() throws IOException {
        if (!hasDatabase()) {
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + "Criação da Base iniciada...");
            GeradorDeScript.createNewDatabase();
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + "Base criada com com sucesso !!!");
        }
        if (isTodosRegistrosConvertidos()) {
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + "Carregamento dos arquivos CSV iniciado...");
            carregaCsvFileWithRegistroAtendimento(getPathsCsvWithRegistroAtendimento());
            carregaCsvFileWithMunicipio(getPathsCsvWithMunicipio());
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + "Carregamento dos arquivos CSV concluído !!!");
        }
    }

    public void converterRegistros() {
        RegistroDeAtendimento registro;
        RegistroDeAtendimentoDAO registroDAO = new RegistroDeAtendimentoDAO();
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        int count = 0;

        long i = atendimentoDAO.count() + 1;
        long n = registroDAO.count();

        consoleLog.println(Util.getNowLocalDateString() + ": "
                + "Conversão iniciada... "
                + (i - 1) + " registros convertidos. "
                + n + " registros para converter...");

        while (i <= n) {
            registro = registroDAO.getByID(i);
            converteRegistroParaAtendimento(registro);
            i++;
            count++;
            if (count % 10000 == 0) {
                consoleLog.println(Util.getNowLocalDateString() + ": "
                        + "Em andamento! " + count + " de "
                        + n + " registros convertidos  até o momento...");
            }
        }
        consoleLog.println(Util.getNowLocalDateString() + ": "
                + "Finalizado! " + count + " registros convertidos.");
    }

    public List<String> getPathsCsvWithRegistroAtendimento() {
        List<String> paths = new ArrayList<>();

//        paths.add(Util.getAbsolutePath("csv/saude_medicos-dados_abertos.csv"));
        paths.add(Util.getAbsolutePath("csv/saude_dentistas-dados_abertos.csv"));
//        paths.add(Util.getAbsolutePath("csv/saude_enfermeiros-dados_abertos.csv"));
//        paths.add(Util.getAbsolutePath("csv/saude_outrosprofissionais-dados_abertos.csv"));

        return paths;
    }

    public void carregaCsvFileWithRegistroAtendimento(List<String> paths) throws IOException {
        for (String path : paths) {
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + path + " preparado para importacao...");
        }
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";
        String scriptString = GeradorDeScript.getScriptStringForCopyCvsToRegistroAtendimento(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        GeradorDeScript.runBatchFile(scriptBatch);
        scriptBatch.delete();
        scriptSql.delete();
    }

    public List<String> getPathsCsvWithMunicipio() {
        List<String> paths = new ArrayList<>();
        paths.add(Util.getAbsolutePath("csv/ibge_municipios_2015.csv"));
        return paths;
    }

    public void carregaCsvFileWithMunicipio(List<String> paths) throws IOException {
        for (String path : paths) {
            consoleLog.println(Util.getNowLocalDateString() + ": "
                    + path + " preparado para importacao...");
        }
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";
        String scriptString = GeradorDeScript.getScriptStringForCopyCvsToMunicipio(paths);
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
            m.setIbge(0);
            return mDAO.getByID(1L);
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

    public Residencia capturarResidenciaDoRegistro(RegistroDeAtendimento registro) {
        Residencia residencia = new Residencia();

        residencia.setAbastecimentoAgua(buscaAbastecimentoAguaDoRegistro(registro));
        residencia.setBairro(buscaBairroDoRegistro(registro));
        residencia.setColetaLixo(buscaColetaLixoDoRegistro(registro));
        if (registro.getComodos() != null) {
            residencia.setComodos(Integer.parseInt(registro.getComodos()));
        }
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean(registro.getEnergiaEletrica()));
        residencia.setEsgotamento(buscaEsgotamentoDoRegistro(registro));
        residencia.setTipo(buscaTipoHabitacaoDoRegistro(registro));
        residencia.setTratamentoAgua(buscaTratamentoAguaDoRegistro(registro));

        return residencia;
    }

    public Residencia salvarNovaResidencia(Residencia residencia) {
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

        paciente.setDataNascimento(Util.parseLocalToDateSql(registro.getDataNascimento()));
        paciente.setGrupoComunitario(buscaGrupoComunitarioDoRegistro(registro));
        paciente.setMeioComunicacao(buscaMeioComunicacaoDoRegistro(registro));
        paciente.setMeioTransporte(buscaMeioTransporteDoRegistro(registro));
        paciente.setPerfilSaude(buscaPerfilSaudeDoRegistro(registro));
        paciente.setResidencia(capturarResidenciaDoRegistro(registro));
        paciente.setSexo(registro.getSexo());

        pacientes = pacienteDAO.find(paciente);

        for (Paciente p : pacientes) {
            if (paciente.equals(p)) {
                return p;
            }
        }

        paciente.setCodigo((int) (pacienteDAO.count() + 1));
        paciente.setResidencia(salvarNovaResidencia(paciente.getResidencia()));
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

        unidade.setNome(registro.getUnidadeDescricao());

        if (unidadeDAO.find(unidade) != null) {
            return unidadeDAO.find(unidade);
        } else {
            unidade.setTipoUnidade(buscaTipoUnidadeDoRegistro(registro));
            unidade.setCnes(registro.getUnidadeCodigo());
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
        if (Util.converteStringSimOuNaoToBoolean(registro.getEncaminhadoAoEspecialista())) {
            Especialidade especialidade = new Especialidade();
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
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

        if (doencaDAO.find(doenca) != null) {
            return doencaDAO.find(doenca);
        } else {
            doenca.setDescricao(registro.getCidDescricao());
            return doencaDAO.save(doenca);
        }
    }

    public Doenca buscaDoencaDaInternacao(RegistroDeAtendimento registro) {
        Doenca doenca = new Doenca();
        DoencaDAO doencaDAO = new DoencaDAO();

        doenca.setCid(registro.getCidInternacao());

        return doencaDAO.find(doenca);
    }

    public UnidadeSaude buscaUnidadeSaudeSolicitanteInternacao(RegistroDeAtendimento registro) {
        UnidadeSaude unidade = new UnidadeSaude();
        UnidadeSaudeDAO unidadeDAO = new UnidadeSaudeDAO();

        unidade.setNome(registro.getUnidadeSolicitanteInternacao());

        return unidadeDAO.find(unidade);
    }

    public UnidadeSaude buscaUnidadeSaudeDestinoInternacao(RegistroDeAtendimento registro) {
        UnidadeSaude unidade = new UnidadeSaude();
        UnidadeSaudeDAO unidadeDAO = new UnidadeSaudeDAO();

        unidade.setNome(registro.getUnidadeDestinoInternacao());

        return unidadeDAO.find(unidade);
    }

    public Internacao buscaInternacaoDoRegistro(RegistroDeAtendimento registro) {
        if (Util.converteStringSimOuNaoToBoolean(registro.getEncaminhadoParaIntenacao())) {
            Internacao internacao = new Internacao();
            InternacaoDAO internacaoDAO = new InternacaoDAO();
            internacao.setDataInternacao(Util.parseLocalToTimestampSql(registro.getDataInternacao()));
            internacao.setDoenca(buscaDoencaDaInternacao(registro));
            internacao.setUnidadeSolicitante(buscaUnidadeSaudeSolicitanteInternacao(registro));
            internacao.setUnidadeDestino(buscaUnidadeSaudeDestinoInternacao(registro));
            return internacaoDAO.save(internacao);
        } else {
            return null;
        }
    }

    public void converteRegistroParaAtendimento(RegistroDeAtendimento registro) {
        Atendimento atendimento = new Atendimento();
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        atendimento.setDataAtendimento(Util.parseLocalToTimestampSql(registro.getDataAtendimento()));
        atendimento.setDoenca(buscaDoencaDoRegitro(registro));
        atendimento.setEncaminhadoParaEspecialidade(buscaEspecialidadeDoRegistro(registro));
        atendimento.setInternacao(buscaInternacaoDoRegistro(registro));
        atendimento.setPaciente(buscaPacienteDoRegistro(registro));
        atendimento.setProcedimento(buscaProcedimentoDoRegistro(registro));
        atendimento.setProfissionalSaude(buscaProfissionalSaudeDoRegistro(registro));
        atendimento.setQtdMedicacaoDispensada(Integer.parseInt(registro.getQtdMedicacaoDispensada()));
        atendimento.setQtdMedicacaoNaoPadrao(Integer.parseInt(registro.getQtdMedicacaoNaoPadronizada()));
        atendimento.setQtdMedicacaoPrescrita(Integer.parseInt(registro.getQtdMedicacaoPrescrita()));
        atendimento.setSolicitadoExame(Util.converteStringSimOuNaoToBoolean(registro.getSolicitacaoExame()));
        atendimento.setUnidadeAtendimento(buscaUnidadeSaudeDoRegistro(registro));

        atendimento = atendimentoDAO.save(atendimento);
        if (atendimento == null) {
            consoleLog.println("Não foi possivel converter o " + registro.toString());
        }
    }

    private boolean hasDatabase() {
        return RegistroDeAtendimentoDAO.isConexaoValida();
    }

    private boolean isTodosRegistrosConvertidos() {
        RegistroDeAtendimentoDAO r = new RegistroDeAtendimentoDAO();
        AtendimentoDAO a = new AtendimentoDAO();
        long registros = r.count();
        long atendimentos = a.count();
        return registros == atendimentos;
    }
}
