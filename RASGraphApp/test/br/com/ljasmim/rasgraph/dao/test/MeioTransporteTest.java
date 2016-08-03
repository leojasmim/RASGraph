package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.MeioTransporteDAO;
import br.com.ljasmim.rasgraph.domain.MeioTransporte;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste de persistencia da classe MeioTransporte
 *
 * @author LeonardoJasmim
 */
public class MeioTransporteTest {

    MeioTransporte meioTransporte;
    MeioTransporteDAO meioTransporteDAO;
    List<MeioTransporte> meiosTransporte;

    public MeioTransporteTest() {
    }

    @Before
    public void setUp() {
        meioTransporteDAO = new MeioTransporteDAO();
    }

    @Test
    public void testSave() {
        meioTransporte = new MeioTransporte();
        meioTransporte.setDescricao("MEIOTRANS_01");
        meioTransporte = meioTransporteDAO.save(meioTransporte);
        assertTrue(meioTransporte != null);
        meioTransporte = new MeioTransporte();
        meioTransporte.setDescricao("MEIOTRANS_02");
        meioTransporte = meioTransporteDAO.save(meioTransporte);
        assertTrue(meioTransporte != null);
        meioTransporte = new MeioTransporte();
        meioTransporte.setDescricao("MEIOTRANS_03");
        meioTransporte = meioTransporteDAO.save(meioTransporte);
        assertTrue(meioTransporte != null);
        meioTransporte = new MeioTransporte();
        meioTransporte.setDescricao("MEIOTRANS_03");
        meioTransporte = meioTransporteDAO.save(meioTransporte);
        assertTrue(meioTransporte == null);
    }

    @Test
    public void testRemove() {
        meioTransporte = meioTransporteDAO.getByID(3L);
        if (meioTransporte != null) {
            meioTransporteDAO.remove(meioTransporte);
        }
        meioTransporte = meioTransporteDAO.getByID(3L);
        assertTrue(meioTransporte == null);
    }

    @Test
    public void testGetAllAndCount() {
        long count = meioTransporteDAO.getCount();
        meiosTransporte = meioTransporteDAO.getAll();
        assertTrue(meiosTransporte.size() == count);
        assertTrue(count == 2);
    }
    
    @Test
    public void testFind(){
        meioTransporte = new MeioTransporte();
        meioTransporte.setDescricao("MEIOTRANS_05");
        assertTrue(meioTransporteDAO.find(meioTransporte) == null);
        meioTransporte.setDescricao("MEIOTRANS_01");
        assertTrue(meioTransporteDAO.find(meioTransporte) != null);
        assertTrue(meioTransporteDAO.find(meioTransporte).getId() == 1);
    }
}
