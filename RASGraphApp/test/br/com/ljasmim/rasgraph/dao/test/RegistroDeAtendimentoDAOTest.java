package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.RegistroDeAtendimentoDAO;
import br.com.ljasmim.rasgraph.registro.RegistroDeAtendimento;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Classe de teste de persistência da classe RegistroDeAtendimentoDAO
 *
 * @author LeonardoJasmim
 */
public class RegistroDeAtendimentoDAOTest {

    RegistroDeAtendimentoDAO registroDAO;
    RegistroDeAtendimento registro;

    public RegistroDeAtendimentoDAOTest() {
    }

    @Before
    public void setUp() {
        registroDAO = new RegistroDeAtendimentoDAO();
    }

    @Test
    public void testSave() {
        registro = new RegistroDeAtendimento();
        registro.setDataAtendimento("05/03/1984 09:50:00");
        registro = registroDAO.save(registro);
        assertTrue(registro.getId() != 0);

        registro = new RegistroDeAtendimento();
        registro.setDataAtendimento("05/03/1984 09:50:00");
        registro = registroDAO.save(registro);
        assertTrue(registro.getId() != 0);

        registro = new RegistroDeAtendimento();
        registro.setDataAtendimento("05/01/1984 09:50:00");
        registro = registroDAO.save(registro);
        assertTrue(registro.getId() != 0);
    }

    @Test
    public void testRemove() {
        registro = registroDAO.getByID(3L);
        if (registro != null) {
            registroDAO.remove(registro);
        }
        assertTrue(registroDAO.getByID(3L) == null);
    }

    @Test
    public void testGetAll() {
        List<RegistroDeAtendimento> registros = registroDAO.getAll();
        long n = registroDAO.getCount();
        assertTrue(registros.size() == n);
        System.out.println(n);
    }

    @Test
    public void testAcessoAosRegistros() {
        long i = registroDAO.getFirst().getId();
        long n = i + registroDAO.getCount();
        
        for (; i <= n; i++) {
            registro = registroDAO.getByID(i);
            registroDAO.remove(registro);
            assertTrue(registroDAO.getByID(i) == null);
            if (i % 10000 == 0) {
                System.out.println(Long.toString(i));
            }
        }

    }
}
