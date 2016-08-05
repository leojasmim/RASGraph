package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.EspecialidadeDAO;
import br.com.ljasmim.rasgraph.domain.Especialidade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da Classe EspecialidadeDAO
 *
 * @author LeonardoJasmim
 */
public class EspecialidadeDAOTest {

    Especialidade especialidade;
    EspecialidadeDAO especialidadeDAO;
    List<Especialidade> especialidades;

    public EspecialidadeDAOTest() {
    }

    @Before
    public void setUp() {
        especialidadeDAO = new EspecialidadeDAO();
    }
    
    @Test
    public void testSave(){
        especialidade = new Especialidade();
        especialidade.setArea("AREA_01");
        especialidade = especialidadeDAO.save(especialidade);
        assertTrue(especialidade != null);
        especialidade = new Especialidade();
        especialidade.setArea("AREA_02");
        especialidade = especialidadeDAO.save(especialidade);
        assertTrue(especialidade != null);
        especialidade = new Especialidade();
        especialidade.setArea("AREA_03");
        especialidade = especialidadeDAO.save(especialidade);
        assertTrue(especialidade != null);
        especialidade = new Especialidade();
        especialidade.setArea("AREA_03");
        especialidade = especialidadeDAO.save(especialidade);
        assertTrue(especialidade == null);
    }
    
    @Test
    public void testRemove(){
        especialidade = especialidadeDAO.getByID(3L);
        if (especialidade != null){
            especialidadeDAO.remove(especialidade);
        }
        especialidade = especialidadeDAO.getByID(3L);
        assertTrue(especialidade == null);
    }
    
    @Test
    public void testGetAllAndCount(){
        long count = especialidadeDAO.count();
        especialidades = especialidadeDAO.getAll();
        assertTrue(especialidades.size() == count);
        assertTrue(count == 2);
    }
    
    @Test
    public void testFind(){
        especialidade = new Especialidade();
        especialidade.setArea("AREA_05");
        assertTrue(especialidadeDAO.find(especialidade) == null);
        especialidade.setArea("AREA_01");
        assertTrue(especialidadeDAO.find(especialidade) != null);
        assertTrue(especialidadeDAO.find(especialidade).getId() == 1);
    }
}
