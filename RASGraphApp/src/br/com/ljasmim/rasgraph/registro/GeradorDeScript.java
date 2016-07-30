package br.com.ljasmim.rasgraph.registro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe Geradora dos scripts de dados
 *
 * @author LeonardoJasmim
 */
public class GeradorDeScript {

    public static String getScriptString(List<String> paths) {
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
        for (String path : paths) {
            script = script
                    + "\n"
                    + "COPY registrodeatendimento\n"
                    + "(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,\n"
                    + "proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,\n"
                    + "enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,\n"
                    + "abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,\n"
                    + "meio_transp,municipio,bairro)\n"
                    + "FROM '" + path + "'using delimiters ';' WITH NULL AS '' encoding 'latin1' CSV HEADER;\n";
        }
        return script;
    }

    public static void createScriptSQL(String scriptString) {
        File script = new File("loadCSV.sql");
        try {
            script.createNewFile();
            FileWriter escritorDoScript = new FileWriter(script, true);
            BufferedWriter buffer = new BufferedWriter(escritorDoScript);
            buffer.write(scriptString);
            buffer.newLine();
            buffer.close();
            escritorDoScript.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }           
            
}
