package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.domain.Doenca;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da Classe DoencaDAO
 *
 * @author LeonardoJasmim
 */
public class DoencaDAOTest {

    Doenca doenca;
    DoencaDAO doencaDAO;
    List<Doenca> doencas;

    public DoencaDAOTest() {
    }

    @Before
    public void SetUp() {
        doencaDAO = new DoencaDAO();
    }

    @Test
    public void testSave() {
        doenca = new Doenca();
        doenca.setCid("A01");
        doenca.setDescricao("DOENCA_01");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);

        doenca = new Doenca();
        doenca.setCid("A01");
        doenca.setDescricao("DOENCA_02");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);

        doenca = new Doenca();
        doenca.setCid("A02");
        doenca.setDescricao("DOENCA_01");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);

        doenca = new Doenca();
        doenca.setCid("A02");
        doenca.setDescricao("DOENCA_02");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);

        doenca = new Doenca();
        doenca.setCid("A03");
        doenca.setDescricao("DOENCA_03");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);

        doenca = new Doenca();
        doenca.setCid("A02");
        doenca.setDescricao("DOENCA_02");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca == null);

        doenca = new Doenca();
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca == null);
    }

    @Test
    public void testRemove() {
        doenca = doencaDAO.getByID(4L);
        if (doenca != null) {
            doencaDAO.remove(doenca);
        }
        doenca = doencaDAO.getByID(4L);
        assertTrue(doenca == null);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(doencaDAO.getAll().size() == doencaDAO.count());
        assertTrue(doencaDAO.count() == 4);
    }

    @Test
    public void testFind() {
        doenca = new Doenca();
        doenca.setCid("A01");
        doenca.setDescricao("DOENCA_03");
        assertTrue(doencaDAO.find(doenca) == null);

        doenca.setCid("A03");
        assertTrue(doencaDAO.find(doenca) != null);
        assertTrue(doencaDAO.find(doenca).getId() == 5);

        doenca = new Doenca();
        assertTrue(doencaDAO.find(doenca) == null);
    }

}
