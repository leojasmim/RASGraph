package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.AtendimentoDAO;
import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.dao.EspecialidadeDAO;
import br.com.ljasmim.rasgraph.dao.InternacaoDAO;
import br.com.ljasmim.rasgraph.dao.PacienteDAO;
import br.com.ljasmim.rasgraph.dao.ProcedimentoDAO;
import br.com.ljasmim.rasgraph.dao.ProfissionalSaudeDAO;
import br.com.ljasmim.rasgraph.dao.UnidadeSaudeDAO;
import br.com.ljasmim.rasgraph.domain.Atendimento;
import br.com.ljasmim.rasgraph.util.Util;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste da classe de persistência AtendimentoDAO
 *
 * @author LeonardoJasmim
 */
public class AtendimentoDAOTest {

    Atendimento atendimento;

    AtendimentoDAO atendimentoDAO;
    PacienteDAO pacienteDAO;
    ProfissionalSaudeDAO profissionalSaudeDAO;
    ProcedimentoDAO procedimentoDAO;
    UnidadeSaudeDAO unidadeSaudeDAO;
    DoencaDAO doencaDAO;
    InternacaoDAO internacaoDAO;
    EspecialidadeDAO especialidadeDAO;

    public AtendimentoDAOTest() {
    }

    @Before
    public void setUp() {
        atendimentoDAO = new AtendimentoDAO();
        pacienteDAO = new PacienteDAO();
        profissionalSaudeDAO = new ProfissionalSaudeDAO();
        procedimentoDAO = new ProcedimentoDAO();
        unidadeSaudeDAO = new UnidadeSaudeDAO();
        doencaDAO = new DoencaDAO();
        internacaoDAO = new InternacaoDAO();
        especialidadeDAO = new EspecialidadeDAO();
    }

    @Test
    public void testSave() {
        atendimento = new Atendimento();
        atendimento.setDataAtendimento(Util.parseLocalToTimestampSql("05/08/2016 19:34:21"));
        atendimento.setPaciente(pacienteDAO.getByID(1L));
        atendimento.setProfissionalSaude(profissionalSaudeDAO.getByID(1L));
        atendimento.setProcedimento(procedimentoDAO.getByID(1L));
        atendimento.setUnidadeAtendimento(unidadeSaudeDAO.getByID(1L));
        atendimento.setDoenca(doencaDAO.getByID(1L));
        atendimento.setInternacao(internacaoDAO.getByID(1L));
        atendimento.setEncaminhadoParaEspecialidade(especialidadeDAO.getByID(1L));
        atendimento.setSolicitadoExame(true);
        atendimento.setQtdMedicacaoDispensada(1);
        atendimento.setQtdMedicacaoNaoPadrao(1);
        atendimento.setQtdMedicacaoPrescrita(1);
        atendimento = atendimentoDAO.save(atendimento);
        assertTrue(atendimento != null);

        atendimento = new Atendimento();
        atendimento.setDataAtendimento(Util.parseLocalToTimestampSql("05/08/2016 19:34:21"));
        atendimento.setPaciente(pacienteDAO.getByID(1L));
        atendimento.setProfissionalSaude(profissionalSaudeDAO.getByID(1L));
        atendimento.setProcedimento(procedimentoDAO.getByID(1L));
        atendimento.setUnidadeAtendimento(unidadeSaudeDAO.getByID(1L));
        atendimento.setDoenca(doencaDAO.getByID(1L));
        atendimento.setSolicitadoExame(true);
        atendimento.setQtdMedicacaoDispensada(1);
        atendimento.setQtdMedicacaoNaoPadrao(1);
        atendimento.setQtdMedicacaoPrescrita(1);
        atendimento = atendimentoDAO.save(atendimento);
        assertTrue(atendimento != null);

        atendimento = new Atendimento();
        atendimento.setDataAtendimento(Util.parseLocalToTimestampSql("05/08/2016 19:34:21"));
        atendimento.setPaciente(pacienteDAO.getByID(2L));
        atendimento.setProfissionalSaude(profissionalSaudeDAO.getByID(2L));
        atendimento.setProcedimento(procedimentoDAO.getByID(2L));
        atendimento.setUnidadeAtendimento(unidadeSaudeDAO.getByID(2L));
        atendimento.setDoenca(doencaDAO.getByID(2L));
        atendimento.setInternacao(internacaoDAO.getByID(2L));
        atendimento.setEncaminhadoParaEspecialidade(especialidadeDAO.getByID(2L));
        atendimento.setSolicitadoExame(true);
        atendimento.setQtdMedicacaoDispensada(1);
        atendimento.setQtdMedicacaoNaoPadrao(1);
        atendimento.setQtdMedicacaoPrescrita(1);
        atendimento = atendimentoDAO.save(atendimento);
        assertTrue(atendimento != null);
    }

    @Test
    public void testRemove() {
        atendimento = atendimentoDAO.getByID(3L);
        if (atendimento != null) {
            atendimentoDAO.remove(atendimento);
        }
        atendimento = atendimentoDAO.getByID(3L);
        assertTrue(atendimento == null);
        assertTrue(pacienteDAO.getByID(2L) != null);
        assertTrue(procedimentoDAO.getByID(2L) != null);
        assertTrue(profissionalSaudeDAO.getByID(2L) != null);
        assertTrue(unidadeSaudeDAO.getByID(2L) != null);
        assertTrue(doencaDAO.getByID(2L) != null);
        assertTrue(internacaoDAO.getByID(2L) == null);
        assertTrue(especialidadeDAO.getByID(2L) != null);
    }

    @Test
    public void testGetAllAndCount(){
        assertTrue(atendimentoDAO.count() == atendimentoDAO.getAll().size());
        assertTrue(atendimentoDAO.count() == 2);
    }
}
