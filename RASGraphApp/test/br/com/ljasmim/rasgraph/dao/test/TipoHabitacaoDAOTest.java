package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.TipoHabitacaoDAO;
import br.com.ljasmim.rasgraph.domain.TipoHabitacao;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe TipoHabitacao
 *
 * @author LeonardoJasmim
 */
public class TipoHabitacaoDAOTest {

    TipoHabitacao tipoHab;
    TipoHabitacaoDAO tipoHabDAO;
    List<TipoHabitacao> tiposHab;

    public TipoHabitacaoDAOTest() {
    }

    @Before
    public void setUp() {
        tipoHabDAO = new TipoHabitacaoDAO();
    }

    @Test
    public void testSave() {
        tipoHab = new TipoHabitacao();
        tipoHab.setDescricao("TIPOHAB_01");
        tipoHab = tipoHabDAO.save(tipoHab);
        assertTrue(tipoHab != null);
        tipoHab = new TipoHabitacao();
        tipoHab.setDescricao("TIPOHAB_02");
        tipoHab = tipoHabDAO.save(tipoHab);
        assertTrue(tipoHab != null);
        tipoHab = new TipoHabitacao();
        tipoHab.setDescricao("TIPOHAB_03");
        tipoHab = tipoHabDAO.save(tipoHab);
        assertTrue(tipoHab != null);
        tipoHab = new TipoHabitacao();
        tipoHab.setDescricao("TIPOHAB_03");
        tipoHab = tipoHabDAO.save(tipoHab);
        assertTrue(tipoHab == null);
    }

    @Test
    public void testRemove() {
        tipoHab = tipoHabDAO.getByID(3L);
        if (tipoHab != null) {
            tipoHabDAO.remove(tipoHab);
        }
        tipoHab = tipoHabDAO.getByID(3L);
        assertTrue(tipoHab == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = tipoHabDAO.getCount();
        tiposHab = tipoHabDAO.getAll();
        assertTrue(tiposHab.size() == count);
        assertTrue(count == 2);
    }

    @Test
    public void testFind() {
        tipoHab = new TipoHabitacao();
        tipoHab.setDescricao("TIPOHAB_05");
        assertTrue(tipoHabDAO.find(tipoHab) == null);
        tipoHab.setDescricao("TIPOHAB_02");
        assertTrue(tipoHabDAO.find(tipoHab) != null);
        assertTrue(tipoHabDAO.find(tipoHab).getId() == 2);
    }
}
