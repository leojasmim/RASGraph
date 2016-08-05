package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.dao.InternacaoDAO;
import br.com.ljasmim.rasgraph.dao.UnidadeSaudeDAO;
import br.com.ljasmim.rasgraph.domain.Internacao;
import br.com.ljasmim.rasgraph.util.Util;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste da classe de persistência InternacaoDAO
 *
 * @author LeonardoJasmim
 */
public class InternacaoDAOTest {

    Internacao internacao;
    InternacaoDAO internacaoDAO;
    UnidadeSaudeDAO unidadeSaudeDAO;
    DoencaDAO doencaDAO;

    public InternacaoDAOTest() {
    }

    @Before
    public void setUp() {
        internacaoDAO = new InternacaoDAO();
        unidadeSaudeDAO = new UnidadeSaudeDAO();
        doencaDAO = new DoencaDAO();
    }

    @Test
    public void testSave() {
        internacao = new Internacao();
        internacao.setDataInternacao(Util.parseLocalToTimestampSql("05/08/2016 12:32:59"));
        internacao.setDoenca(doencaDAO.getByID(1L));
        internacao.setUnidadeDestino(unidadeSaudeDAO.getByID(1L));
        internacao.setUnidadeSolicitante(unidadeSaudeDAO.getByID(2L));
        internacao = internacaoDAO.save(internacao);
        assertTrue(internacao != null);

        internacao = new Internacao();
        internacao.setDataInternacao(Util.parseLocalToTimestampSql("05/08/2016 12:32:59"));
        internacao.setDoenca(doencaDAO.getByID(1L));
        internacao.setUnidadeDestino(unidadeSaudeDAO.getByID(2L));
        internacao.setUnidadeSolicitante(unidadeSaudeDAO.getByID(1L));
        internacao = internacaoDAO.save(internacao);
        assertTrue(internacao != null);

        internacao = new Internacao();
        internacao.setDataInternacao(Util.parseLocalToTimestampSql("05/08/2016 12:32:59"));
        internacao.setDoenca(doencaDAO.getByID(1L));
        internacao.setUnidadeDestino(unidadeSaudeDAO.getByID(1L));
        internacao.setUnidadeSolicitante(unidadeSaudeDAO.getByID(2L));
        internacao = internacaoDAO.save(internacao);
        assertTrue(internacao != null);
    }

    @Test
    public void testRemove() {
        internacao = internacaoDAO.getByID(3L);
        if (internacao != null) {
            internacaoDAO.remove(internacao);
        }
        internacao = internacaoDAO.getByID(3L);
        assertTrue(internacao == null);
        assertTrue(doencaDAO.getByID(1L) != null);
        assertTrue(unidadeSaudeDAO.getByID(1L) != null);
        assertTrue(unidadeSaudeDAO.getByID(2L) != null);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(internacaoDAO.count() == internacaoDAO.getAll().size());
        assertTrue(internacaoDAO.count() == 2);
    }

}
