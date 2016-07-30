package br.com.ljasmim.rasgraph.registro.test;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.registro.GeradorDeScript;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
    
    @Test
    public void gerarCreateDatabase() throws IOException{
        String sqlPath = "dist/create.sql";
        String scriptString = GeradorDeScript.getScriptStringForCreateDatabase();
        File scriptSql = GeradorDeScript.getScriptSqlForCreateDatabase(scriptString,sqlPath);
        Assert.assertTrue(scriptSql.exists());
        
        File scriptBatch = GeradorDeScript.getBatchForCreateDatabase(scriptSql);
        
        Assert.assertFalse(RepositoryBaseJPA.isConexaoValida());
        Assert.assertTrue(GeradorDeScript.runCreateDatabaseBatchFile(scriptBatch));
        Assert.assertTrue(RepositoryBaseJPA.isConexaoValida());
        
        scriptBatch.delete();
        scriptSql.delete();
    }
    
}
