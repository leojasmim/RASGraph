package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.DoencaDAO;
import br.com.ljasmim.rasgraph.domain.Doenca;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistência da Classe DoencaDAO
 * @author LeonardoJasmim
 */
public class DoencaTest {

    Doenca doenca;
    DoencaDAO doencaDAO;
    List<Doenca> doeancas;
    
    public DoencaTest() {
    }

    @Before
    public void SetUp(){
        doencaDAO = new DoencaDAO();
    }
    
    @Test
    public void testSave(){
        doenca = new Doenca();
        doenca.setCid("A01");
        doenca.setDescricao("DOENCA_01");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);
        
        doenca = new Doenca();
        
        doenca.setDescricao("DOENCA_02");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);
        
        doenca = new Doenca();
        doenca.setCid("A01");
        
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca != null);
        
        doenca = new Doenca();
        doenca.setCid("A01");
        doenca.setDescricao("DOENCA_03");
        doenca = doencaDAO.save(doenca);
        assertTrue(doenca == null);
    }
    

}
