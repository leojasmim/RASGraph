package br.com.ljasmim.rasgraph.app;

import br.com.ljasmim.rasgraph.util.Util;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author LeonardoJasmim
 */
public class RasGraphApp {
       
    public static void main(String[] args) throws IOException {
        RASGraphConverter rasgc = new RASGraphConverter();
        
        //Caminhos relativos no formato: csv/<nome do arquivo>.csv        
        List<String> relativePaths = Util.getRelativePathsFromFile(args[0]);      
        
        rasgc.start(relativePaths);
    }
}
