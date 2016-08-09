package br.com.ljasmim.rasgraph.util;

import java.sql.Date;
import java.sql.Timestamp;

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

    public static Date parseLocalToDateSql(String dataLocal) {
        if (!dataLocal.isEmpty()) {
            String dia = dataLocal.substring(0, 2);
            String mes = dataLocal.substring(3, 5);
            String ano = dataLocal.substring(6, 10);
            return Date.valueOf(ano + "-" + mes + "-" + dia);
        } else {
            return null;
        }
    }

    public static Timestamp parseLocalToTimestampSql(String timesLocal) {
        if (timesLocal == null) {
            return null;
        }
        if (!timesLocal.isEmpty()) {
            String dia = timesLocal.substring(0, 2);
            String mes = timesLocal.substring(3, 5);
            String ano = timesLocal.substring(6, 10);
            String tempo = timesLocal.substring(11);
            return Timestamp.valueOf(ano + "-" + mes + "-" + dia + " " + tempo);
        }
        return null;
    }
}
