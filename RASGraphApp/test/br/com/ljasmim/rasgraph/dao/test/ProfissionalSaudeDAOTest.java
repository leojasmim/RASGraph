package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.ProfissionalSaudeDAO;
import br.com.ljasmim.rasgraph.domain.ProfissionalSaude;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe ProfissionalSaude
 *
 * @author LeonardoJasmim
 */
public class ProfissionalSaudeDAOTest {

    ProfissionalSaude profSaude;
    ProfissionalSaudeDAO profSaudeDAO;

    public ProfissionalSaudeDAOTest() {
    }

    @Before
    public void setUp() {
        profSaudeDAO = new ProfissionalSaudeDAO();
    }

    @Test
    public void testSave() {
        profSaude = new ProfissionalSaude();
        profSaude.setCbo("A01");
        profSaude.setDescricao("PROF_01");
        profSaude = profSaudeDAO.save(profSaude);
        assertTrue(profSaude != null);
        profSaude = new ProfissionalSaude();
        profSaude.setCbo("A02");
        profSaude.setDescricao("PROF_02");
        profSaude = profSaudeDAO.save(profSaude);
        assertTrue(profSaude != null);
        profSaude = new ProfissionalSaude();
        profSaude.setCbo("A03");
        profSaude.setDescricao("PROF_03");
        profSaude = profSaudeDAO.save(profSaude);
        assertTrue(profSaude != null);
        profSaude = new ProfissionalSaude();
        profSaude.setCbo("A03");
        profSaude.setDescricao("PROF_03");
        profSaude = profSaudeDAO.save(profSaude);
        assertTrue(profSaude == null);
    }
    
    @Test
    public void testRemove(){
        profSaude = profSaudeDAO.getByID(3L);
        if(profSaude != null){
            profSaudeDAO.remove(profSaude);
        }                
        profSaude = profSaudeDAO.getByID(3L);
        assertTrue(profSaude == null);
    }

    @Test
    public void testGetAllAndCount(){
        assertTrue(profSaudeDAO.count() == profSaudeDAO.getAll().size());
        assertTrue(profSaudeDAO.count() == 2);
    }
    
    @Test
    public void testFind(){
        profSaude = new ProfissionalSaude();
        profSaude.setCbo("A03");
        assertTrue(profSaudeDAO.find(profSaude) == null);
        profSaude.setCbo("A01");
        assertTrue(profSaudeDAO.find(profSaude) != null);
        assertTrue(profSaudeDAO.find(profSaude).getDescricao().equals("PROF_01"));
    }
}
