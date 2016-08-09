package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.MeioComunicacaoDAO;
import br.com.ljasmim.rasgraph.domain.MeioComunicacao;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe MeioComunicacaoDAO
 *
 * @author LeonardoJasmim
 */
public class MeioComunicacaoDAOTest {

    MeioComunicacao meioComunicacao;
    MeioComunicacaoDAO meioComunicacaoDAO;
    List<MeioComunicacao> meiosComunicacao;

    public MeioComunicacaoDAOTest() {
    }

    @Before
    public void setUp() {
        meioComunicacaoDAO = new MeioComunicacaoDAO();
    }

    @Test
    public void testSave() {
        meioComunicacao = new MeioComunicacao();
        meioComunicacao.setDescricao("MEIOCOMUN_01");
        meioComunicacao = meioComunicacaoDAO.save(meioComunicacao);
        assertTrue(meioComunicacao != null);
        meioComunicacao = new MeioComunicacao();
        meioComunicacao.setDescricao("MEIOCOMUN_02");
        meioComunicacao = meioComunicacaoDAO.save(meioComunicacao);
        assertTrue(meioComunicacao != null);
        meioComunicacao = new MeioComunicacao();
        meioComunicacao.setDescricao("MEIOCOMUN_03");
        meioComunicacao = meioComunicacaoDAO.save(meioComunicacao);
        assertTrue(meioComunicacao != null);
        meioComunicacao = new MeioComunicacao();
        meioComunicacao.setDescricao("MEIOCOMUN_03");
        meioComunicacao = meioComunicacaoDAO.save(meioComunicacao);
        assertTrue(meioComunicacao == null);
        meioComunicacao = new MeioComunicacao();
        meioComunicacao = meioComunicacaoDAO.save(meioComunicacao);
        assertTrue(meioComunicacao == null);
    }

    @Test
    public void testRemove() {
        meioComunicacao = meioComunicacaoDAO.getByID(3L);
        if (meioComunicacao != null) {
            meioComunicacaoDAO.remove(meioComunicacao);
        }
        meioComunicacao = meioComunicacaoDAO.getByID(3L);
        assertTrue(meioComunicacao == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = meioComunicacaoDAO.count();
        meiosComunicacao = meioComunicacaoDAO.getAll();
        assertTrue(meiosComunicacao.size() == count);
        assertTrue(count == 2);
    }

    @Test
    public void testFind() {
        meioComunicacao = new MeioComunicacao();
        meioComunicacao.setDescricao("MEIOCOMUN_05");
        assertTrue(meioComunicacaoDAO.find(meioComunicacao) == null);
        meioComunicacao.setDescricao("MEIOCOMUN_01");
        assertTrue(meioComunicacaoDAO.find(meioComunicacao) != null);
        assertTrue(meioComunicacaoDAO.find(meioComunicacao).getId() == 1);
        meioComunicacao = new MeioComunicacao();
        assertTrue(meioComunicacaoDAO.find(meioComunicacao) == null);
    }
}
