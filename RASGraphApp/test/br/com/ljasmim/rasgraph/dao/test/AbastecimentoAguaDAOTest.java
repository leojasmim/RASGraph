package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.AbastecimentoAguaDAO;
import br.com.ljasmim.rasgraph.domain.AbastecimentoAgua;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persitência da classe AbastecimentoAgua
 *
 * @author LeonardoJasmim
 */
public class AbastecimentoAguaDAOTest {

    AbastecimentoAgua abastecimento;
    AbastecimentoAguaDAO abastecimentoDAO;
    List<AbastecimentoAgua> abastecimentos;

    public AbastecimentoAguaDAOTest() {
    }

    @Before
    public void setUp() {
        abastecimentoDAO = new AbastecimentoAguaDAO();
    }

    @Test
    public void testSave() {
        abastecimento = new AbastecimentoAgua();
        abastecimento.setDescricao("ABAST_01");
        abastecimento = abastecimentoDAO.save(abastecimento);
        assertTrue(abastecimento != null);
        abastecimento = new AbastecimentoAgua();
        abastecimento.setDescricao("ABAST_02");
        abastecimento = abastecimentoDAO.save(abastecimento);
        assertTrue(abastecimento != null);
        abastecimento = new AbastecimentoAgua();
        abastecimento.setDescricao("ABAST_03");
        abastecimento = abastecimentoDAO.save(abastecimento);
        assertTrue(abastecimento != null);
        abastecimento = new AbastecimentoAgua();
        abastecimento.setDescricao("ABAST_03");
        abastecimento = abastecimentoDAO.save(abastecimento);
        assertTrue(abastecimento == null);
    }

    @Test
    public void testRemove() {
        abastecimento = abastecimentoDAO.getByID(3L);
        if (abastecimento != null) {
            abastecimentoDAO.remove(abastecimento);
        }
        abastecimento = abastecimentoDAO.getByID(3L);
        assertTrue(abastecimento == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = abastecimentoDAO.getCount();
        abastecimentos = abastecimentoDAO.getAll();
        assertTrue(abastecimentos.size() == count);
        assertTrue(count == 2);
    }

    @Test
    public void testFind() {
        abastecimento = new AbastecimentoAgua();
        abastecimento.setDescricao("ABAST_05");
        assertTrue(abastecimentoDAO.find(abastecimento) == null);

        abastecimento.setDescricao("ABAST_01");
        assertTrue(abastecimentoDAO.find(abastecimento) != null);
        assertTrue(abastecimentoDAO.find(abastecimento).getId() == 1);
    }

}
