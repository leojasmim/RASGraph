package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.MunicipioDAO;
import br.com.ljasmim.rasgraph.domain.Municipio;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Classe de Teste da Classe MunicipioDAO
 *
 * @author LeonardoJasmim
 */
public class MunicipioDAOTest {

    Municipio municipio;
    MunicipioDAO municipioDAO;
    List<Municipio> municipios;

    public MunicipioDAOTest() {
    }

    @Before
    public void setUp() {
        municipioDAO = new MunicipioDAO();
    }

    @Test
    public void testSave() {
        municipio = new Municipio();
        municipio.setIbge(1111111);
        municipio.setRegiaoFederal("1 - Regiao Um");
        municipio.setCodigoUf(1);
        municipio.setUf("UM");
        municipio.setPopulacao2015(111111);
        municipio.setNome("MUNICIPIO_01");
        municipio = municipioDAO.save(municipio);
        assertTrue(municipio.getId() != 0);
        
        municipio = new Municipio();
        municipio.setIbge(2222222);
        municipio.setRegiaoFederal("2 - Regiao Dois");
        municipio.setCodigoUf(2);
        municipio.setUf("DO");
        municipio.setPopulacao2015(222222);
        municipio.setNome("MUNICIPIO_02");
        municipio = municipioDAO.save(municipio);
        assertTrue(municipio.getId() != 0);
        
        municipio = new Municipio();
        municipio.setIbge(3333333);
        municipio.setRegiaoFederal("3 - Regiao Tres");
        municipio.setCodigoUf(3);
        municipio.setUf("TR");
        municipio.setPopulacao2015(3333333);
        municipio.setNome("MUNICIPIO_03");
        municipio = municipioDAO.save(municipio);
        assertTrue(municipio.getId() != 0);
        
        municipio = new Municipio();
        municipio.setIbge(3333333);
        municipio.setRegiaoFederal("3 - Regiao Tres");
        municipio.setCodigoUf(3);
        municipio.setUf("TR");
        municipio.setPopulacao2015(3333333);
        municipio.setNome("MUNICIPIO_03");
        municipio = municipioDAO.save(municipio);
        assertTrue(municipio == null);
        
        municipio = new Municipio();
        municipio = municipioDAO.save(municipio);
        assertTrue(municipio == null);
    }
    
    @Test
    public void testRemove(){
        municipio = municipioDAO.getByID(3L);
        if(municipio != null){
            municipioDAO.remove(municipio);
        }
        municipio = municipioDAO.getByID(3L);
        assertTrue(municipio == null);
    }
    
    @Test
    public void testGetAllAndCount(){
        assertTrue(municipioDAO.getAll().size() == municipioDAO.count());
    }
    
    @Test
    public void testFind(){
        municipio = new Municipio();
        municipio.setNome("MUNICIPIO_04");
        municipio = municipioDAO.find(municipio);
        assertTrue(municipio == null);
        
        municipio = new Municipio();
        municipio.setNome("MUNICIPIO_01");
        municipio = municipioDAO.find(municipio);
        assertTrue(municipio != null);
        
        municipio = new Municipio();
        municipio = municipioDAO.find(municipio);
        assertTrue(municipio == null);
    }
}
