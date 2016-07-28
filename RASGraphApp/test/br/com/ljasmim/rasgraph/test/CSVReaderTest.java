package br.com.ljasmim.rasgraph.test;

import br.com.ljasmim.rasgraph.util.CSVReader;
import br.com.ljasmim.rasgraph.util.RegistroDeAtendimento;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author LeonardoJasmim
 */
public class CSVReaderTest {

    public CSVReaderTest() {
    }

    @Test
    public void csvReaderTest() throws IOException {
        assertFalse(CSVReader.printCsvFile("C:/Users/leoja/Desk"));
        assertTrue(CSVReader.printCsvFile("C:/Users/leoja/Desktop/teste.csv"));
    }
    
    @Test
    public void loadCsvToRegistroTest() throws IOException{
        List<RegistroDeAtendimento> registros = CSVReader.loadCsvToRegistro
        ("C:/Users/leoja/LNCC/GA-054 - Ciencia de Redes/Trabalhos e Apresentações"
                + "/databases/saude_dentistas-dados_abertos.csv");
        assertTrue(registros.size() == 248);
        assertTrue(registros.get(247).getDataAtendimento().equals("17/05/2016 10:39:17"));
        
        registros = CSVReader.loadCsvToRegistro("C:/Users/leoja/LNCC/GA-054 - "
                + "Ciencia de Redes/Trabalhos e Apresentações"
                + "/databases/saude_outrosprofissionais-dados_abertos.csv");
        
        System.out.println(registros.size());
    }
            
            
}
