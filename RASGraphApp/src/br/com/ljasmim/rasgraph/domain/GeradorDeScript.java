package br.com.ljasmim.rasgraph.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Geradora dos scripts de dados
 *
 * @author LeonardoJasmim
 */
public class GeradorDeScript {

    /**
     * Cria o arquivo .sql
     *
     * @param scriptSqlString Conteudo do script em linguagem sql
     * @param sqlPath Caminho para arquivo .sql gerado
     *
     * @return arquivo .sql com script
     */
    public static File getScriptSqlFile(String scriptSqlString, String sqlPath) {
        File sqlFile = new File(sqlPath);
        try {
            sqlFile.createNewFile();
            FileWriter writer = new FileWriter(sqlFile, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(scriptSqlString);
            buffer.newLine();
            buffer.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return sqlFile;
    }

    /**
     * Cria arquivo .bat para executar o script .sql
     *
     * @param sqlFile Arquivo .sql com script de criação da base de dados
     * @param batchPath nome do arquivo de saída para o arquivo
     *
     * @return arquivo .bat
     *
     * @throws IOException
     */
    public static File getBatchForRunSqlFile(File sqlFile, String batchPath) throws IOException {
        File batchFile = new File(batchPath);
        try {
            batchFile.createNewFile();
        } catch (IOException ex) {
            return null;
        }
        FileWriter writer = new FileWriter(batchFile, true);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("@echo off\n"
                + "C:\\\"Arquivos de programas\"\\PostgreSQL\\9.3\\bin\\psql.exe -U postgres -f "
                + sqlFile.getPath()
                + "\n");
        buffer.newLine();
        buffer.close();
        writer.close();

        return batchFile;
    }

    /**
     * Executa rotina sql
     *
     * @param batchFile arquivo .bat para execução do script sql
     *
     * @return true caso execute o arquivo, false caso contrário
     *
     * @throws IOException
     */
    public static boolean runBatchFile(File batchFile) throws IOException {
        try {
            Process proc = Runtime.getRuntime().exec(batchFile.getPath());
            Scanner retorno = new Scanner(proc.getInputStream());
            while (retorno.hasNextLine()) {
                System.out.println(retorno.nextLine());
            }
            switch (proc.exitValue()) {
                case 0:
                    return true;
                default:
                    return false;
            }
        } catch (IOException ex) {
            return false;
        }
    }

    //CRIAÇÃO DA BASE DE DADOS
    /**
     * Gerar o conteudo do script para a criação da base de dados rasgraph e da
     * tabela de registros de atendimento
     *
     * @return Conteúdo do script para criação da rasgraph_db
     */
    public static String getScriptStringForCreateDatabase() {
        String script = "DROP DATABASE rasgraph_db;\n"
                + "CREATE DATABASE rasgraph_db\n"
                + "  WITH OWNER = postgres\n"
                + "       ENCODING = 'UTF8'\n"
                + "       TABLESPACE = pg_default\n"
                + "       LC_COLLATE = 'Portuguese_Brazil.1252'\n"
                + "       LC_CTYPE = 'Portuguese_Brazil.1252'\n"
                + "       CONNECTION LIMIT = -1;\n"
                + "	  \n"
                + "\\c rasgraph_db\n"
                + "\n"
                + "DROP TABLE IF EXISTS registrodeatendimento CASCADE;\n"
                + "\n"
                + "CREATE TABLE registrodeatendimento\n"
                + "(\n"
                + "  id bigserial NOT NULL,\n"
                + "  abast_agua character varying(255),\n"
                + "  area_atuacao character varying(255),\n"
                + "  bairro character varying(255),\n"
                + "  cbo_cod character varying(255),\n"
                + "  cbo_desc character varying(255),\n"
                + "  cid_cod character varying(255),\n"
                + "  cid_desc character varying(255),\n"
                + "  cid_inter character varying(255),\n"
                + "  comodos character varying(255),\n"
                + "  dt_atend character varying(255),\n"
                + "  dt_inter character varying(255),\n"
                + "  dt_nasc character varying(255),\n"
                + "  dest_lixo character varying(255),\n"
                + "  caso_doenca character varying(255),\n"
                + "  enc_esp character varying(255),\n"
                + "  enc_inter character varying(255),\n"
                + "  energia character varying(255),\n"
                + "  fezes_urina character varying(255),\n"
                + "  grupo_comun character varying(255),\n"
                + "  meio_comun character varying(255),\n"
                + "  meio_transp character varying(255),\n"
                + "  municipio character varying(255),\n"
                + "  proc_cod character varying(255),\n"
                + "  proc_desc character varying(255),\n"
                + "  qtdmed_disp character varying(255),\n"
                + "  qtdmed_npadrao character varying(255),\n"
                + "  qtdmed_presc character varying(255),\n"
                + "  sexo character varying(255),\n"
                + "  sol_exame character varying(255),\n"
                + "  tipo_hab character varying(255),\n"
                + "  tipounid_cod character varying(255),\n"
                + "  tipounid_desc character varying(255),\n"
                + "  trat_agua character varying(255),\n"
                + "  unid_cod character varying(255),\n"
                + "  unid_desc character varying(255),\n"
                + "  unid_dest_inter character varying(255),\n"
                + "  unid_sol_inter character varying(255),\n"
                + "  CONSTRAINT registrodeatendimento_pkey PRIMARY KEY (id)\n"
                + ") WITH (OIDS=FALSE);\n"
                + "ALTER TABLE registrodeatendimento OWNER TO postgres;\n";
        return script;
    }

    //CARREGAMENTO DE DADOS
    /**
     * Gera o conteudo do script sql para copiar os arquivos .csv para a tabela
     * registro de atendimentos
     *
     * @param paths Lista com caminhos para os arquivos .cvs
     *
     * @return Conteúdo do script para criação da rasgraph_db
     */
    public static String getScriptStringForCopyCvs(List<String> paths) {
        String script = "\\c rasgraph_db \n\n";
        for (String path : paths) {
            script = script
                    + "COPY registrodeatendimento\n"
                    + "(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,\n"
                    + "proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,\n"
                    + "enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,\n"
                    + "abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,\n"
                    + "meio_transp,municipio,bairro)\n"
                    + "FROM '" + path + "' using delimiters ';' WITH NULL AS '' encoding 'latin1' CSV HEADER;\n\n";
        }

        script += "vacuum;\n\n";
        return script;
    }

    public static void createNewDatabase() throws IOException {
        File scriptSql = new File("script/create_rasgraph_db.sql");
        String batchPath = "script/create_rasgraph_db.bat";

        File scriptBatch = getBatchForRunSqlFile(scriptSql, batchPath);
        runBatchFile(scriptBatch);
        if(!scriptBatch.delete()){
            System.out.println("Problema para deletar o script .bat");;
        }
    }
}
