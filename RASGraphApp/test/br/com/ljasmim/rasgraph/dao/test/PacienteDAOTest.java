package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.AbastecimentoAguaDAO;
import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.ColetaLixoDAO;
import br.com.ljasmim.rasgraph.dao.EsgotamentoDAO;
import br.com.ljasmim.rasgraph.dao.GrupoComunitarioDAO;
import br.com.ljasmim.rasgraph.dao.MeioComunicacaoDAO;
import br.com.ljasmim.rasgraph.dao.MeioTransporteDAO;
import br.com.ljasmim.rasgraph.dao.PacienteDAO;
import br.com.ljasmim.rasgraph.dao.PerfilSaudeDAO;
import br.com.ljasmim.rasgraph.dao.ResidenciaDAO;
import br.com.ljasmim.rasgraph.dao.TipoHabitacaoDAO;
import br.com.ljasmim.rasgraph.dao.TratamentoAguaDAO;
import br.com.ljasmim.rasgraph.domain.Paciente;
import br.com.ljasmim.rasgraph.domain.Residencia;
import br.com.ljasmim.rasgraph.util.Util;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author LeonardoJasmim
 */
public class PacienteDAOTest {

    Paciente paciente;
    Residencia residencia;

    PacienteDAO pacienteDAO;
    BairroDAO bairroDAO;
    ColetaLixoDAO coletaLixoDAO;
    TratamentoAguaDAO tratamentoAguaDAO;
    TipoHabitacaoDAO tipoHabitacaoDAO;
    AbastecimentoAguaDAO abastecimentoAguaDAO;
    EsgotamentoDAO esgotamentoDAO;
    ResidenciaDAO residenciaDAO;
    GrupoComunitarioDAO grupoComunitarioDAO;
    MeioComunicacaoDAO meioComunicacaoDAO;
    MeioTransporteDAO meioTransporteDAO;
    PerfilSaudeDAO perfilSaudeDAO;

    public PacienteDAOTest() {
    }

    @Before
    public void setUp() {
        bairroDAO = new BairroDAO();
        coletaLixoDAO = new ColetaLixoDAO();
        tratamentoAguaDAO = new TratamentoAguaDAO();
        tipoHabitacaoDAO = new TipoHabitacaoDAO();
        abastecimentoAguaDAO = new AbastecimentoAguaDAO();
        esgotamentoDAO = new EsgotamentoDAO();
        residenciaDAO = new ResidenciaDAO();
        grupoComunitarioDAO = new GrupoComunitarioDAO();
        meioComunicacaoDAO = new MeioComunicacaoDAO();
        meioTransporteDAO = new MeioTransporteDAO();
        perfilSaudeDAO = new PerfilSaudeDAO();
        pacienteDAO = new PacienteDAO();
    }

    @Test
    public void testSave() {
        int count = 1;

        paciente = new Paciente();
        paciente.setResidencia(residenciaDAO.getByID(1L));
        paciente.setDataNascimento(Util.parseLocalToDateSql("05/03/1984 00:00:00"));
        paciente.setSexo("M");
        paciente.setGrupoComunitario(grupoComunitarioDAO.getByID(1L));
        paciente.setMeioComunicacao(meioComunicacaoDAO.getByID(1L));
        paciente.setMeioTransporte(meioTransporteDAO.getByID(1L));
        paciente.setPerfilSaude(perfilSaudeDAO.getByID(1L));
        paciente.setCodigo(count);
        paciente = pacienteDAO.save(paciente);
        assertTrue(paciente != null);
        count++;

        paciente = new Paciente();
        paciente.setResidencia(residenciaDAO.getByID(1L));
        paciente.setDataNascimento(Util.parseLocalToDateSql("19/10/1988 00:00:00"));
        paciente.setSexo("F");
        paciente.setGrupoComunitario(grupoComunitarioDAO.getByID(2L));
        paciente.setMeioComunicacao(meioComunicacaoDAO.getByID(2L));
        paciente.setMeioTransporte(meioTransporteDAO.getByID(2L));
        paciente.setPerfilSaude(perfilSaudeDAO.getByID(2L));
        paciente.setCodigo(count);
        paciente = pacienteDAO.save(paciente);
        assertTrue(paciente != null);
        count++;

        paciente = new Paciente();
        paciente.setResidencia(residenciaDAO.getByID(2L));
        paciente.setDataNascimento(Util.parseLocalToDateSql("05/03/1984 00:00:00"));
        paciente.setSexo("M");
        paciente.setCodigo(count);
        paciente = pacienteDAO.save(paciente);
        assertTrue(paciente != null);
        count++;

        paciente = new Paciente();
        paciente.setResidencia(residenciaDAO.getByID(3L));
        paciente.setCodigo(count);
        paciente = pacienteDAO.save(paciente);
        assertTrue(paciente != null);
        count++;
        
        paciente = new Paciente();
        paciente.setCodigo(count);
        paciente = pacienteDAO.save(paciente);
        assertTrue(paciente != null);
        count++;
    }

    @Test
    public void testRemove() {
        paciente = pacienteDAO.getByID(4L);
        if (paciente != null) {
            pacienteDAO.remove(paciente);
        }
        paciente = pacienteDAO.getByID(4L);
        assertTrue(paciente == null);
        assertTrue(residenciaDAO.getByID(3L) == null);
        assertTrue(meioComunicacaoDAO.getByID(2L) != null);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(pacienteDAO.count() == pacienteDAO.getAll().size());
        assertTrue(pacienteDAO.count() == 4);
    }

    @Test
    public void testFind() {
        paciente = pacienteDAO.getByID(1L);
        List<Paciente> pacientes = pacienteDAO.find(paciente);
        assertTrue(pacientes.size() == 2);
        assertTrue(paciente.equals(pacientes.get(0)));
        assertTrue(!paciente.equals(pacientes.get(1)));

        paciente = new Paciente();

        paciente.setResidencia(residenciaDAO.getByID(3L));
        paciente.setDataNascimento(Util.parseLocalToDateSql("05/03/1984 00:00:00"));
        paciente.setGrupoComunitario(grupoComunitarioDAO.getByID(2L));
        paciente.setMeioComunicacao(meioComunicacaoDAO.getByID(2L));
        paciente.setMeioTransporte(meioTransporteDAO.getByID(2L));
        paciente.setPerfilSaude(perfilSaudeDAO.getByID(1L));
        
        pacientes = pacienteDAO.find(paciente);
        assertTrue(pacientes.isEmpty());
    }

}
