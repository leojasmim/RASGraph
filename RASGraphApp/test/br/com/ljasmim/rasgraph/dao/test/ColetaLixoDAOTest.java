package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.ColetaLixoDAO;
import br.com.ljasmim.rasgraph.domain.ColetaLixo;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da Classe ColetaLixoDAO
 *
 * @author LeonardoJasmim
 */
public class ColetaLixoDAOTest {

    ColetaLixo coleta;
    ColetaLixoDAO coletaDAO;
    List<ColetaLixo> coletas;

    public ColetaLixoDAOTest() {
    }

    @Before
    public void setUp() {
        coletaDAO = new ColetaLixoDAO();
    }

    @Test
    public void testSave() {
        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_01");
        coleta = coletaDAO.save(coleta);
        assertTrue(coleta != null);

        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_02");
        coleta = coletaDAO.save(coleta);
        assertTrue(coleta != null);
        
        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_03");
        coleta = coletaDAO.save(coleta);
        assertTrue(coleta != null);
        
        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_03");
        coleta = coletaDAO.save(coleta);
        assertTrue(coleta == null);
    }
    
    @Test
    public void testRemove(){
        coleta = coletaDAO.getByID(3L);
        if (coleta != null){
            coletaDAO.remove(coleta);
        }
        coleta = coletaDAO.getByID(3L);
        assertTrue(coleta == null);
    }
    
    @Test
    public void testGetAllAndCount(){
        long count = coletaDAO.count();
        coletas = coletaDAO.getAll();
        assertTrue(coletas.size() == count);
    }
    
    @Test
    public void testFind(){
        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_01");       
        assertTrue(coletaDAO.find(coleta) != null);
        
        coleta = new ColetaLixo();
        coleta.setDescricao("COLETALIXO_04");       
        assertTrue(coletaDAO.find(coleta) == null);
        
    }

}
