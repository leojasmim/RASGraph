package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.ProcedimentoDAO;
import br.com.ljasmim.rasgraph.domain.Procedimento;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste da classe de persistência ProcedimentoDAOTest
 * @author LeonardoJasmim
 */
public class ProcedimentoDAOTest {

    Procedimento procedimento;
    ProcedimentoDAO procedimentoDAO;
        
    public ProcedimentoDAOTest() {
    }

    @Before
    public void setUp(){
        procedimentoDAO = new ProcedimentoDAO();
    }
    
    @Test
    public void testSave(){
        procedimento = new Procedimento();
        procedimento.setCodigo("P01");
        procedimento.setDescricao("PROC_01");
        procedimento = procedimentoDAO.save(procedimento);
        assertTrue(procedimento != null);
        
        procedimento = new Procedimento();
        procedimento.setCodigo("P02");
        procedimento.setDescricao("PROC_02");
        procedimento = procedimentoDAO.save(procedimento);
        assertTrue(procedimento != null);
        
        procedimento = new Procedimento();
        procedimento.setCodigo("P03");
        procedimento.setDescricao("PROC_03");
        procedimento = procedimentoDAO.save(procedimento);
        assertTrue(procedimento != null);
        
        procedimento = new Procedimento();
        procedimento.setCodigo("P01");
        procedimento.setDescricao("PROC_02");
        procedimento = procedimentoDAO.save(procedimento);
        assertTrue(procedimento == null);
    }
    
    @Test
    public void testRemove(){
        procedimento = procedimentoDAO.getByID(3L);
        if(procedimento != null){
            procedimentoDAO.remove(procedimento);
        }
        procedimento = procedimentoDAO.getByID(3L);
        assertTrue(procedimento == null);
    }
    
    @Test
    public void testGetAllAndCount(){
        assertTrue(procedimentoDAO.count() == procedimentoDAO.getAll().size());
        assertTrue(procedimentoDAO.count() == 2);
    }
    
    @Test
    public void testFind(){
        procedimento = new Procedimento();
        procedimento.setCodigo("P05");
        assertTrue(procedimentoDAO.find(procedimento) == null);
        procedimento.setCodigo("P01");
        assertTrue(procedimentoDAO.find(procedimento) != null);        
    }
}
