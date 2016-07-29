package br.com.ljasmim.rasgraph.dao;

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
    public void setUp(){
        registroDAO = new RegistroDeAtendimentoDAO();
    }

    @Test
    public void saveTest(){
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
    public void removeTest(){
        registro = registroDAO.getByID(3L);
        if(registro != null){
            registroDAO.remove(registro);
        }
        assertTrue(registroDAO.getByID(3L) == null);
    }
    
    @Test
    public void getAllTest(){
        List<RegistroDeAtendimento> registros = registroDAO.getAll();
        assertTrue(registros.size() == 2);
    }
    
}
