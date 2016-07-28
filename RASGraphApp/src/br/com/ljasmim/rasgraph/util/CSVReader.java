package br.com.ljasmim.rasgraph.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe para ler arquivo .CSV
 *
 * @author LeonardoJasmim
 */
public class CSVReader {

    public static boolean readCsvFile(String path) throws IOException {
        try {
            try (BufferedReader stream = new BufferedReader(new FileReader(path))) {
                String tupla;
                String[] celulasDaTupla;

                while ((tupla = stream.readLine()) != null) {
                    celulasDaTupla = tupla.split(";");
                    printCsvLine(celulasDaTupla);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static void printCsvLine(String[] celulas) {
        for (String celula : celulas) {
            System.out.print(celula + " | ");
        }
        System.out.println();
    }
}
