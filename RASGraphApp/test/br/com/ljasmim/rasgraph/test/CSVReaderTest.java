package br.com.ljasmim.rasgraph.test;

import br.com.ljasmim.rasgraph.util.CSVReader;
import java.io.IOException;
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
        assertFalse(CSVReader.readCsvFile("C:/Users/leoja/Desk"));
        assertTrue(CSVReader.readCsvFile("C:/Users/leoja/Desktop/teste.csv"));
    }
}
