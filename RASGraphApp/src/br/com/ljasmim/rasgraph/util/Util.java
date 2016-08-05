package br.com.ljasmim.rasgraph.util;

/**
 * Classe com métodos utilitários
 *
 * @author LeonardoJasmim
 */
public class Util {

    public static boolean converteStringSimOuNaoToBoolean(String decisao) {
        try {
            decisao = decisao.toUpperCase();
            return decisao.equals("SIM");
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
