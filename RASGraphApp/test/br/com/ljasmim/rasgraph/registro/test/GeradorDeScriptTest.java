package br.com.ljasmim.rasgraph.registro.test;

import br.com.ljasmim.rasgraph.registro.GeradorDeScript;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


/**
 *
 * @author LeonardoJasmim
 */
public class GeradorDeScriptTest {
    
    public GeradorDeScriptTest() {
    }

    @Test
    public void gerarScriptSQLTest(){
        List<String> paths = new ArrayList<>();
        
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_dentistas-dados_abertos.csv");
        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_outrosprofissionais-dados_abertos.csv");

        String scriptSql = GeradorDeScript.getScriptString(paths);
        GeradorDeScript.createScriptSQL(scriptSql);
    }
    
}
