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

    public static void readCsvFile(String path) throws IOException {
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

        }
    }

    public static void printCsvLine(String[] celulas) {
        for (String celula : celulas) {
            System.out.println(celula + " ");
        }
        System.out.println("\n");
    }
}
