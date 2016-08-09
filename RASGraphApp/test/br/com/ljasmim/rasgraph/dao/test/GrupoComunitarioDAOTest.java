package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.GrupoComunitarioDAO;
import br.com.ljasmim.rasgraph.domain.GrupoComunitario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da classe GrupoComunitario
 * @author LeonardoJasmim
 */
public class GrupoComunitarioDAOTest {
    
    GrupoComunitario grupo;
    GrupoComunitarioDAO grupoDAO;
    List<GrupoComunitario> grupos;
    
    public GrupoComunitarioDAOTest() {
    }

    @Before
    public void setUp(){
        grupoDAO = new GrupoComunitarioDAO();
    }
    
    @Test
    public void testSave(){
        grupo = new GrupoComunitario();
        grupo.setDescricao("GRUPOCOMUN_01");
        grupo =  grupoDAO.save(grupo);
        assertTrue(grupo != null);
        grupo = new GrupoComunitario();
        grupo.setDescricao("GRUPOCOMUN_02");
        grupo =  grupoDAO.save(grupo);
        assertTrue(grupo != null);
        grupo = new GrupoComunitario();
        grupo.setDescricao("GRUPOCOMUN_03");
        grupo =  grupoDAO.save(grupo);
        assertTrue(grupo != null);
        grupo = new GrupoComunitario();
        grupo.setDescricao("GRUPOCOMUN_03");
        grupo =  grupoDAO.save(grupo);
        assertTrue(grupo == null);
        grupo = new GrupoComunitario();
        grupo =  grupoDAO.save(grupo);
        assertTrue(grupo == null);
    }
        
    @Test
    public void testRemove(){
        grupo = grupoDAO.getByID(3L);
        if (grupo != null){
            grupoDAO.remove(grupo);
        }
        grupo = grupoDAO.getByID(3L);
        assertTrue(grupo == null);
    }
    
    @Test
    public void testGetAllAndCount(){
        long count = grupoDAO.count();
        grupos = grupoDAO.getAll();
        assertTrue(grupos.size() == count);
        assertTrue(count == 2);
    }
    
    @Test
    public void testFind(){
        grupo = new GrupoComunitario();
        grupo.setDescricao("GRUPOCOMUN_05");
        assertTrue(grupoDAO.find(grupo) == null);
        
        grupo.setDescricao("GRUPOCOMUN_01");
        assertTrue(grupoDAO.find(grupo) != null);
        assertTrue(grupoDAO.find(grupo).getId() == 1);
        
        grupo = new GrupoComunitario();
        assertTrue(grupoDAO.find(grupo) == null);
    }
}
