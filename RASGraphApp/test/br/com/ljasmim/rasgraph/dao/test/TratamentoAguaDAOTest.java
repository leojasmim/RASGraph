package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.TratamentoAguaDAO;
import br.com.ljasmim.rasgraph.domain.TratamentoAgua;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe TratamentoAguaDAO
 *
 * @author LeonardoJasmim
 */
public class TratamentoAguaDAOTest {

    TratamentoAgua tratamentoAgua;
    TratamentoAguaDAO tratamentoAguaDAO;
    List<TratamentoAgua> tratamentosAgua;

    public TratamentoAguaDAOTest() {
    }

    @Before
    public void setUp() {
        tratamentoAguaDAO = new TratamentoAguaDAO();
    }

    @Test
    public void testSave() {
        tratamentoAgua = new TratamentoAgua();
        tratamentoAgua.setDescricao("TRATAGUA_01");
        tratamentoAgua = tratamentoAguaDAO.save(tratamentoAgua);
        assertTrue(tratamentoAgua != null);

        tratamentoAgua = new TratamentoAgua();
        tratamentoAgua.setDescricao("TRATAGUA_02");
        tratamentoAgua = tratamentoAguaDAO.save(tratamentoAgua);
        assertTrue(tratamentoAgua != null);

        tratamentoAgua = new TratamentoAgua();
        tratamentoAgua.setDescricao("TRATAGUA_03");
        tratamentoAgua = tratamentoAguaDAO.save(tratamentoAgua);
        assertTrue(tratamentoAgua != null);

        tratamentoAgua = new TratamentoAgua();
        tratamentoAgua.setDescricao("TRATAGUA_03");
        tratamentoAgua = tratamentoAguaDAO.save(tratamentoAgua);
        assertTrue(tratamentoAgua == null);
    }

    @Test
    public void testRemove() {
        tratamentoAgua = tratamentoAguaDAO.getByID(3L);
        if (tratamentoAgua != null) {
            tratamentoAguaDAO.remove(tratamentoAgua);
        }
        tratamentoAgua = tratamentoAguaDAO.getByID(3L);
        assertTrue(tratamentoAgua == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = tratamentoAguaDAO.count();
        tratamentosAgua = tratamentoAguaDAO.getAll();
        assertTrue(tratamentosAgua.size() == count);
        assertTrue(count == 2);
    }

    @Test
    public void testFind() {
        tratamentoAgua = new TratamentoAgua();
        tratamentoAgua.setDescricao("TRATAGUA_05");
        assertTrue(tratamentoAguaDAO.find(tratamentoAgua) == null);

        tratamentoAgua.setDescricao("TRATAGUA_02");
        assertTrue(tratamentoAguaDAO.find(tratamentoAgua) != null);
        assertTrue(tratamentoAguaDAO.find(tratamentoAgua).getId() == 2);
    }

}
