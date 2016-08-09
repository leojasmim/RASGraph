package br.com.ljasmim.rasgraph.app;

import java.io.IOException;


/**
 * 
 * @author LeonardoJasmim
 */
public class RasGraphApp {
       
    public static void main(String[] args) throws IOException {
        RASGraphConverter rasgc = new RASGraphConverter();
        rasgc.start();
    }
}
