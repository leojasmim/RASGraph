package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.TipoUnidadeDAO;
import br.com.ljasmim.rasgraph.domain.TipoUnidade;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe TipoUnidade
 *
 * @author LeonardoJasmim
 */
public class TipoUnidadeTest {

    TipoUnidade tipo;
    TipoUnidadeDAO tipoDAO;

    public TipoUnidadeTest() {
    }

    @Before
    public void setUp(){
        tipoDAO = new TipoUnidadeDAO();
    }
    
    @Test
    public void testSave() {
        tipo = new TipoUnidade();
        tipo.setCodigo("A01");
        tipo.setDescricao("TIPO_01");
        tipo = tipoDAO.save(tipo);
        assertTrue(tipo != null);

        tipo = new TipoUnidade();
        tipo.setCodigo("A02");
        tipo.setDescricao("TIPO_02");
        tipo = tipoDAO.save(tipo);
        assertTrue(tipo != null);

        tipo = new TipoUnidade();
        tipo.setCodigo("A03");
        tipo.setDescricao("TIPO_03");
        tipo = tipoDAO.save(tipo);
        assertTrue(tipo != null);
        tipo = new TipoUnidade();

        tipo.setCodigo("A03");
        tipo.setDescricao("TIPO_03");
        tipo = tipoDAO.save(tipo);
        assertTrue(tipo == null);
    }

    @Test
    public void testRemove() {
        tipo = tipoDAO.getByID(3L);
        if (tipo != null) {
            tipoDAO.remove(tipo);
        }
        tipo = tipoDAO.getByID(3L);
        assertTrue(tipo == null);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(tipoDAO.getCount() == tipoDAO.getAll().size());
        assertTrue(tipoDAO.getCount() == 2);
    }

    @Test
    public void testFind() {
        tipo = new TipoUnidade();
        tipo.setCodigo("A03");
        assertTrue(tipoDAO.find(tipo) == null);
        tipo.setCodigo("A01");
        assertTrue(tipoDAO.find(tipo) != null);
        assertTrue(tipoDAO.find(tipo).getDescricao().equals("TIPO_01"));
    }
}
