package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.EsgotamentoDAO;
import br.com.ljasmim.rasgraph.domain.Esgotamento;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe Esgotamento
 *
 * @author LeonardoJasmim
 */
public class EsgotamentoDAOTest {

    Esgotamento esgotamento;
    EsgotamentoDAO esgotamentoDAO;
    List<Esgotamento> esgotamentos;

    public EsgotamentoDAOTest() {
    }

    @Before
    public void setUp() {
        esgotamentoDAO = new EsgotamentoDAO();
    }

    @Test
    public void testSave() {
        esgotamento = new Esgotamento();
        esgotamento.setDescricao("ESGOTO_01");
        esgotamento = esgotamentoDAO.save(esgotamento);
        assertTrue(esgotamento != null);
        esgotamento = new Esgotamento();
        esgotamento.setDescricao("ESGOTO_02");
        esgotamento = esgotamentoDAO.save(esgotamento);
        assertTrue(esgotamento != null);
        esgotamento = new Esgotamento();
        esgotamento.setDescricao("ESGOTO_03");
        esgotamento = esgotamentoDAO.save(esgotamento);
        assertTrue(esgotamento != null);
        esgotamento = new Esgotamento();
        esgotamento.setDescricao("ESGOTO_03");
        esgotamento = esgotamentoDAO.save(esgotamento);
        assertTrue(esgotamento == null);
        esgotamento = new Esgotamento();
        esgotamento = esgotamentoDAO.save(esgotamento);
        assertTrue(esgotamento == null);
    }

    @Test
    public void testRemove() {
        esgotamento = esgotamentoDAO.getByID(3L);
        if (esgotamento != null) {
            esgotamentoDAO.remove(esgotamento);
        }
        esgotamento = esgotamentoDAO.getByID(3L);
        assertTrue(esgotamento == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = esgotamentoDAO.count();
        esgotamentos = esgotamentoDAO.getAll();
        assertTrue(esgotamentos.size() == count);
        assertTrue(count == 2);
    }

    @Test
    public void testFind() {
        esgotamento = new Esgotamento();
        esgotamento.setDescricao("ESGOTO_05");
        assertTrue(esgotamentoDAO.find(esgotamento) == null);
        esgotamento.setDescricao("ESGOTO_01");
        assertTrue(esgotamentoDAO.find(esgotamento).getId() == 1);
        esgotamento = new Esgotamento();
        assertTrue(esgotamentoDAO.find(esgotamento) == null);
    }

}
