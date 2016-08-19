package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.TipoUnidadeDAO;
import br.com.ljasmim.rasgraph.dao.UnidadeSaudeDAO;
import br.com.ljasmim.rasgraph.domain.UnidadeSaude;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste da classe de persistência UnidadeSaudeDAOTest
 *
 * @author LeonardoJasmim
 */
public class UnidadeSaudeDAOTest {

    UnidadeSaude unidade;
    UnidadeSaudeDAO unidadeSaudeDAO;
    TipoUnidadeDAO tipoUnidadeDAO;
    BairroDAO bairroDAO;

    public UnidadeSaudeDAOTest() {
    }

    @Before
    public void setUp() {
        unidadeSaudeDAO = new UnidadeSaudeDAO();
        tipoUnidadeDAO = new TipoUnidadeDAO();
        bairroDAO = new BairroDAO();
    }

    @Test
    public void testSave() {
        unidade = new UnidadeSaude();
        unidade.setCnes("U00001");
        unidade.setNome("UNID_01");
        unidade.setTipoUnidade(tipoUnidadeDAO.getByID(1L));
        unidade = unidadeSaudeDAO.save(unidade);
        assertTrue(unidade != null);

        unidade = new UnidadeSaude();
        unidade.setCnes("U00002");
        unidade.setNome("UNID_02");
        unidade.setTipoUnidade(tipoUnidadeDAO.getByID(1L));
        unidade = unidadeSaudeDAO.save(unidade);
        assertTrue(unidade != null);

        unidade = new UnidadeSaude();
        unidade.setCnes("U00003");
        unidade.setNome("UNID_03");
        unidade.setTipoUnidade(tipoUnidadeDAO.getByID(1L));
        unidade.setBairro(bairroDAO.getByID(1L));
        unidade = unidadeSaudeDAO.save(unidade);
        assertTrue(unidade != null);

        unidade = new UnidadeSaude();
        unidade.setCnes("U00001");
        unidade.setNome("UNID_01");
        unidade.setTipoUnidade(tipoUnidadeDAO.getByID(1L));
        unidade = unidadeSaudeDAO.save(unidade);
        assertTrue(unidade == null);

        unidade = new UnidadeSaude();
        unidade = unidadeSaudeDAO.save(unidade);
        assertTrue(unidade == null);
    }

    @Test
    public void testRemove() {
        unidade = unidadeSaudeDAO.getByID(3L);
        if (unidade != null) {
            unidadeSaudeDAO.remove(unidade);
        }
        unidade = unidadeSaudeDAO.getByID(3L);
        assertTrue(unidade == null);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(unidadeSaudeDAO.count() == unidadeSaudeDAO.getAll().size());
        assertTrue(unidadeSaudeDAO.count() == 2);
    }

    @Test
    public void testFind() {
        unidade = new UnidadeSaude();
        unidade.setCnes("U00001");
        unidade.setNome("UNID_01");
        assertTrue(unidadeSaudeDAO.find(unidade) != null);
        assertTrue(unidadeSaudeDAO.find(unidade).getId() == 1);

        unidade.setNome("UNID_05");
        assertTrue(unidadeSaudeDAO.find(unidade) == null);

        unidade = new UnidadeSaude();
        assertTrue(unidadeSaudeDAO.find(unidade) == null);
    }

}
