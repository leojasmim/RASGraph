package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.MunicipioDAO;
import br.com.ljasmim.rasgraph.domain.Bairro;
import br.com.ljasmim.rasgraph.domain.Municipio;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Classe de Teste da classe de persistência BairroDAO
 *
 * @author LeonardoJasmim
 */
public class BairroDAOTest {

    Bairro bairro, buscaBairro;
    BairroDAO bairroDAO;
    Municipio municipio;
    MunicipioDAO municipioDAO;

    public BairroDAOTest() {
    }

    @Before
    public void setUp() {
        bairroDAO = new BairroDAO();
        municipioDAO = new MunicipioDAO();
    }

    @Test
    public void testSave() {
        municipio = municipioDAO.getByID(1L);
        bairro = new Bairro();
        bairro.setMunicipio(municipio);
        bairro.setNome("BAIRRO_01");
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro != null);

        bairro = new Bairro();
        bairro.setMunicipio(municipio);
        bairro.setNome("BAIRRO_02");
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro != null);

        bairro = new Bairro();
        bairro.setMunicipio(municipio);
        bairro.setNome("BAIRRO_03");
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro != null);

        bairro = new Bairro();
        bairro.setMunicipio(municipio);
        bairro.setNome("BAIRRO_03");
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro == null);

        municipio = municipioDAO.getByID(2L);
        bairro = new Bairro();
        bairro.setMunicipio(municipio);
        bairro.setNome("BAIRRO_03");
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro != null);
        
        bairro = new Bairro();
        bairro = bairroDAO.save(bairro);
        assertTrue(bairro == null);
    }

    @Test
    public void testRemove() {
        bairro = bairroDAO.getByID(5L);
        municipio = bairro.getMunicipio();
        if (bairro != null) {
            bairroDAO.remove(bairro);
        }
        bairro = bairroDAO.getByID(5L);
    }

    @Test
    public void testGetAllAndCount() {
        assertTrue(bairroDAO.getAll().size() == bairroDAO.count());
    }

    @Test
    public void testFind() {
        municipio = municipioDAO.getByID(2L);
        bairro = new Bairro();
        bairro.setNome("BAIRRO_03");
        bairro.setMunicipio(municipio);
                        
        if(bairroDAO.find(bairro) == null){
           bairro = bairroDAO.save(bairro);
           assertTrue(bairro != null);
        }
        
        bairro = bairroDAO.find(bairro);
        assertTrue(bairro != null);
        
        bairro = new Bairro();
        bairro = bairroDAO.find(bairro);
        assertTrue(bairro == null);
    }
}
