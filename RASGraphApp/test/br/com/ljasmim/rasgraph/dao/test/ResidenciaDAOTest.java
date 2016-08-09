/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ljasmim.rasgraph.dao.test;

import br.com.ljasmim.rasgraph.dao.AbastecimentoAguaDAO;
import br.com.ljasmim.rasgraph.dao.BairroDAO;
import br.com.ljasmim.rasgraph.dao.ColetaLixoDAO;
import br.com.ljasmim.rasgraph.dao.EsgotamentoDAO;
import br.com.ljasmim.rasgraph.dao.ResidenciaDAO;
import br.com.ljasmim.rasgraph.dao.TipoHabitacaoDAO;
import br.com.ljasmim.rasgraph.dao.TratamentoAguaDAO;
import br.com.ljasmim.rasgraph.domain.Residencia;
import br.com.ljasmim.rasgraph.util.Util;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Teste da classe de persistência ResidenciaDAO
 * @author LeonardoJasmim
 */
public class ResidenciaDAOTest {

    Residencia residencia;

    BairroDAO bairroDAO;
    ColetaLixoDAO coletaLixoDAO;
    TratamentoAguaDAO tratamentoAguaDAO;
    TipoHabitacaoDAO tipoHabitacaoDAO;
    AbastecimentoAguaDAO abastecimentoAguaDAO;
    EsgotamentoDAO esgotamentoDAO;
    ResidenciaDAO residenciaDAO;

    public ResidenciaDAOTest() {
    }

    @Before
    public void setUp() {
        bairroDAO = new BairroDAO();
        coletaLixoDAO = new ColetaLixoDAO();
        tratamentoAguaDAO = new TratamentoAguaDAO();
        tipoHabitacaoDAO = new TipoHabitacaoDAO();
        abastecimentoAguaDAO = new AbastecimentoAguaDAO();
        esgotamentoDAO = new EsgotamentoDAO();
        residenciaDAO = new ResidenciaDAO();
    }

    @Test
    public void testSave() {
        residencia = new Residencia();
        residencia.setAbastecimentoAgua(abastecimentoAguaDAO.getByID(1L));
        residencia.setBairro(bairroDAO.getByID(1L));
        residencia.setColetaLixo(coletaLixoDAO.getByID(1L));
        residencia.setComodos(3);
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean("SIM"));
        residencia.setEsgotamento(esgotamentoDAO.getByID(1L));
        residencia.setTipo(tipoHabitacaoDAO.getByID(1L));
        residencia.setTratamentoAgua(tratamentoAguaDAO.getByID(1L));
        residencia = residenciaDAO.save(residencia);
        assertTrue(residencia != null);

        residencia = new Residencia();
        residencia.setAbastecimentoAgua(abastecimentoAguaDAO.getByID(2L));
        residencia.setBairro(bairroDAO.getByID(2L));
        residencia.setColetaLixo(coletaLixoDAO.getByID(2L));
        residencia.setComodos(2);
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean("NÃO"));
        residencia.setEsgotamento(esgotamentoDAO.getByID(2L));
        residencia.setTipo(tipoHabitacaoDAO.getByID(2L));
        residencia.setTratamentoAgua(tratamentoAguaDAO.getByID(2L));
        residencia = residenciaDAO.save(residencia);
        assertTrue(residencia != null);
        
        residencia = new Residencia();
        residencia.setAbastecimentoAgua(abastecimentoAguaDAO.getByID(2L));
        residencia.setBairro(bairroDAO.getByID(2L));
        residencia.setColetaLixo(coletaLixoDAO.getByID(2L));
        residencia.setComodos(2);
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean("NÃO"));
        residencia.setEsgotamento(esgotamentoDAO.getByID(2L));
        residencia.setTipo(tipoHabitacaoDAO.getByID(2L));
        residencia.setTratamentoAgua(tratamentoAguaDAO.getByID(2L));
        residencia = residenciaDAO.save(residencia);
        assertTrue(residencia != null);

        residencia = new Residencia();
        residencia.setAbastecimentoAgua(abastecimentoAguaDAO.getByID(2L));
        residencia.setBairro(bairroDAO.getByID(2L));
        residencia.setColetaLixo(coletaLixoDAO.getByID(2L));
        residencia.setComodos(2);
        residencia.setEnergiaEletrica(Util.converteStringSimOuNaoToBoolean("NÃO"));
        residencia.setEsgotamento(esgotamentoDAO.getByID(2L));
        residencia.setTipo(tipoHabitacaoDAO.getByID(2L));
        residencia.setTratamentoAgua(tratamentoAguaDAO.getByID(2L));
        residencia = residenciaDAO.save(residencia);
        assertTrue(residencia != null);

        residencia = new Residencia();
        residencia.setBairro(bairroDAO.getByID(2L));
        residencia = residenciaDAO.save(residencia);
        assertTrue(residencia != null);
    }

    @Test
    public void testRemove() {
        residencia = residenciaDAO.getByID(5L);
        if (residencia != null) {
            residenciaDAO.remove(residencia);
        }
        residencia = residenciaDAO.getByID(5L);
        assertTrue(residencia == null);
        residencia = residenciaDAO.getByID(4L);
        if (residencia != null) {
            residenciaDAO.remove(residencia);
        }
        residencia = residenciaDAO.getByID(4L);
        assertTrue(residencia == null);
        assertTrue(bairroDAO.getByID(2L) != null);
    }

    @Test
    public void testGetAllAndCount(){
        assertTrue(residenciaDAO.count() == residenciaDAO.getAll().size());
        assertTrue(residenciaDAO.count() == 3);
    }
    
    @Test
    public void testEquals(){
        assertTrue(residenciaDAO.getByID(1L).equals(residenciaDAO.getByID(2L)));
        assertTrue(residenciaDAO.getByID(1L).equals(residenciaDAO.getByID(3L)));
        assertTrue(residenciaDAO.getByID(1L).equals(residenciaDAO.getByID(4L)));
        assertTrue(residenciaDAO.getByID(1L).equals(residenciaDAO.getByID(5L)));
        assertTrue(!residenciaDAO.getByID(1L).equals(residenciaDAO.getByID(7L)));
    }
}
