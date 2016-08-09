package br.com.ljasmim.rasgraph.registro.test;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.GeradorDeScript;
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
    public void testGerarCreateDatabase() throws IOException {
        String sqlPath = "dist/create.sql";
        String batchPath = "dist/create.bat";
        String scriptString = GeradorDeScript.getScriptStringForCreateDatabase();
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        Assert.assertTrue(scriptSql.exists());

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);

        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
        scriptSql.delete();
    }

    @Test
    public void testGerarCopyCsvDentistas() throws IOException {
        List<String> paths = new ArrayList<>();
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";

        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_dentistas-dados_abertos.csv");

        String scriptString = GeradorDeScript.getScriptStringForCopyCvs(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        Assert.assertTrue(scriptSql.exists());

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
        scriptSql.delete();
    }

    @Test
    public void testGerarCopyCsvOutros() throws IOException {
        List<String> paths = new ArrayList<>();
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";

        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_outrosprofissionais-dados_abertos.csv");

        String scriptString = GeradorDeScript.getScriptStringForCopyCvs(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        Assert.assertTrue(scriptSql.exists());

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
        scriptSql.delete();
    }

    @Test
    public void testGerarCopyCsvEnfermeiros() throws IOException {
        List<String> paths = new ArrayList<>();
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";

        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_enfermeiros-dados_abertos.csv");

        String scriptString = GeradorDeScript.getScriptStringForCopyCvs(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        Assert.assertTrue(scriptSql.exists());

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
        scriptSql.delete();
    }

    @Test
    public void testGerarCopyCsvMedicos() throws IOException {
        List<String> paths = new ArrayList<>();
        String sqlPath = "dist/copyCsv.sql";
        String batchPath = "dist/copyCsv.bat";

        paths.add("C:\\Users\\leoja\\Desktop\\teste\\saude_medicos-dados_abertos.csv");

        String scriptString = GeradorDeScript.getScriptStringForCopyCvs(paths);
        File scriptSql = GeradorDeScript.getScriptSqlFile(scriptString, sqlPath);
        Assert.assertTrue(scriptSql.exists());

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
        scriptSql.delete();
    }

    @Test
    public void testCreateNewDatabase() throws IOException {
        File scriptSql = new File("script/create_rasgraph_db.sql");
        Assert.assertTrue(scriptSql.exists());

        String batchPath = "script/create_rasgraph_db.bat";

        File scriptBatch = GeradorDeScript.getBatchForRunSqlFile(scriptSql, batchPath);
        Assert.assertTrue(GeradorDeScript.runBatchFile(scriptBatch));

        scriptBatch.delete();
    }
}
