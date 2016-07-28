package br.com.ljasmim.rasgraph.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para ler arquivo .CSV
 *
 * @author LeonardoJasmim
 */
public class CSVReader {

    /**
     * Imprime as tuplas registradas em um arquivo .csv
     *
     * @param pathToCsv - caminho do arquivo .csv
     * @return false - caso não seja possivel ler o arquivo true - caso
     * contrário
     * @throws IOException
     */
    public static boolean printCsvFile(String pathToCsv) throws IOException {
        try {
            try (BufferedReader stream = readCsvFile(pathToCsv)) {
                String tupla;
                String[] celulasDaTupla;

                while ((tupla = stream.readLine()) != null) {
                    celulasDaTupla = tupla.split(";");
                    printLines(celulasDaTupla);
                }
                stream.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        } 
        return true;
    }

    /**
     * Imprime os valores contidos em um vetor de strings
     *
     * @param celulas - vetor de strings
     */
    public static void printLines(String[] celulas) {
        for (String celula : celulas) {
            System.out.print(celula + " | ");
        }
        System.out.println();
    }

    /**
     * Lê um arquivo csv para um stream
     *
     * @param pathToCsv - caminho para o arquivo .csv
     * @return stream - buffer com os valores lidos do arquivo
     */
    public static BufferedReader readCsvFile(String pathToCsv) {
        try {
            BufferedReader stream = new BufferedReader(new FileReader(pathToCsv));
            return stream;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Lê as tuplas de um arquivo .csv e carrega os valores para uma lista de
     * registros de atendimento.
     *
     * @param pathToCsv - caminho para o arquivo .csv
     * @return Lista com os registros
     * @throws IOException
     */
    public static List<RegistroDeAtendimento> loadCsvToRegistro(String pathToCsv)
            throws IOException {
        try {
            try (BufferedReader stream = readCsvFile(pathToCsv)) {

                String tupla;
                String[] celulasDaTupla;
                RegistroDeAtendimento registro;
                List<RegistroDeAtendimento> registros = new ArrayList();
                
                while ((tupla = stream.readLine()) != null) {
                    celulasDaTupla = tupla.split(";");
                    registro = new RegistroDeAtendimento(
                            celulasDaTupla[0], celulasDaTupla[1], celulasDaTupla[2],
                            celulasDaTupla[3], celulasDaTupla[4], celulasDaTupla[5],
                            celulasDaTupla[6], celulasDaTupla[7], celulasDaTupla[8],
                            celulasDaTupla[9], celulasDaTupla[10], celulasDaTupla[11],
                            celulasDaTupla[12], celulasDaTupla[13], celulasDaTupla[14],
                            celulasDaTupla[15], celulasDaTupla[16], celulasDaTupla[17],
                            celulasDaTupla[18], celulasDaTupla[19], celulasDaTupla[20],
                            celulasDaTupla[21], celulasDaTupla[22], celulasDaTupla[23],
                            celulasDaTupla[24], celulasDaTupla[25], celulasDaTupla[26],
                            celulasDaTupla[27], celulasDaTupla[28], celulasDaTupla[29],
                            celulasDaTupla[30], celulasDaTupla[31], celulasDaTupla[32],
                            celulasDaTupla[33], celulasDaTupla[34], celulasDaTupla[35],
                            celulasDaTupla[36]);
                    registros.add(registro);
                }
                registros.remove(0); //Retirar cabecalho
                stream.close();
                return registros;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
