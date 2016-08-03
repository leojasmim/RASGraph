package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.PerfilSaudeDAO;
import br.com.ljasmim.rasgraph.domain.PerfilSaude;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe PerfilSaudeDAO
 *
 * @author LeonardoJasmim
 */
public class PerfilSaudeDAOTest {
    
    PerfilSaude perfil;
    PerfilSaudeDAO perfilDAO;
    List<PerfilSaude> perfis;
    
    public PerfilSaudeDAOTest() {
    }
    
    @Before
    public void setUp() {
        perfilDAO = new PerfilSaudeDAO();
    }
    
    @Test
    public void testSave() {
        perfil = new PerfilSaude();
        perfil.setDescricao("PERFIL_01");
        perfil = perfilDAO.save(perfil);
        assertTrue(perfil != null);
        perfil = new PerfilSaude();
        perfil.setDescricao("PERFIL_02");
        perfil = perfilDAO.save(perfil);
        assertTrue(perfil != null);
        perfil = new PerfilSaude();
        perfil.setDescricao("PERFIL_03");
        perfil = perfilDAO.save(perfil);
        assertTrue(perfil != null);
        perfil = new PerfilSaude();
        perfil.setDescricao("PERFIL_03");
        perfil = perfilDAO.save(perfil);
        assertTrue(perfil == null);
    }
    
    @Test
    public void testRemove() {
        perfil = perfilDAO.getByID(3L);
        if (perfil != null) {
            perfilDAO.remove(perfil);
        }
        perfil = perfilDAO.getByID(3L);
        assertTrue(perfil == null);
    }
    
    @Test
    public void testGetAllAndCount() {
        long count = perfilDAO.getCount();
        perfis = perfilDAO.getAll();
        assertTrue(perfis.size() == count);
        assertTrue(count == 2);
    }
    
    @Test
    public void find() {
        perfil = new PerfilSaude();
        perfil.setDescricao("PERFIL_05");
        assertTrue(perfilDAO.find(perfil) == null);
        perfil.setDescricao("PERFIL_01");
        assertTrue(perfilDAO.find(perfil) != null);
        assertTrue(perfilDAO.find(perfil).getId() == 1);
    }
}
