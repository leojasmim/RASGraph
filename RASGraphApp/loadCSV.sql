DROP DATABASE rasgraph_db;
CREATE DATABASE rasgraph_db
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
	  
\c rasgraph_db

DROP TABLE IF EXISTS registrodeatendimento CASCADE;

CREATE TABLE registrodeatendimento
(
  id bigserial NOT NULL,
  abast_agua character varying(255),
  area_atuacao character varying(255),
  bairro character varying(255),
  cbo_cod character varying(255),
  cbo_desc character varying(255),
  cid_cod character varying(255),
  cid_desc character varying(255),
  cid_inter character varying(255),
  comodos character varying(255),
  dt_atend character varying(255),
  dt_inter character varying(255),
  dt_nasc character varying(255),
  dest_lixo character varying(255),
  caso_doenca character varying(255),
  enc_esp character varying(255),
  enc_inter character varying(255),
  energia character varying(255),
  fezes_urina character varying(255),
  grupo_comun character varying(255),
  meio_comun character varying(255),
  meio_transp character varying(255),
  municipio character varying(255),
  proc_cod character varying(255),
  proc_desc character varying(255),
  qtdmed_disp character varying(255),
  qtdmed_npadrao character varying(255),
  qtdmed_presc character varying(255),
  sexo character varying(255),
  sol_exame character varying(255),
  tipo_hab character varying(255),
  tipounid_cod character varying(255),
  tipounid_desc character varying(255),
  trat_agua character varying(255),
  unid_cod character varying(255),
  unid_desc character varying(255),
  unid_dest_inter character varying(255),
  unid_sol_inter character varying(255),
  CONSTRAINT registrodeatendimento_pkey PRIMARY KEY (id)
) WITH (OIDS=FALSE);
ALTER TABLE registrodeatendimento OWNER TO postgres;
COPY registrodeatendimento
(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,
proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,
enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,
abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,
meio_transp,municipio,bairro)
FROM 'C:\Users\leoja\Desktop\teste\saude_dentistas-dados_abertos.csv'using delimiters ';' WITH NULL AS '' encoding 'windows-1251' CSV HEADER;
COPY registrodeatendimento
(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,
proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,
enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,
abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,
meio_transp,municipio,bairro)
FROM 'C:\Users\leoja\Desktop\teste\saude_outrosprofissionais-dados_abertos.csv'using delimiters ';' WITH NULL AS '' encoding 'windows-1251' CSV HEADER;

DROP DATABASE rasgraph_db;
CREATE DATABASE rasgraph_db
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
	  
\c rasgraph_db

DROP TABLE IF EXISTS registrodeatendimento CASCADE;

CREATE TABLE registrodeatendimento
(
  id bigserial NOT NULL,
  abast_agua character varying(255),
  area_atuacao character varying(255),
  bairro character varying(255),
  cbo_cod character varying(255),
  cbo_desc character varying(255),
  cid_cod character varying(255),
  cid_desc character varying(255),
  cid_inter character varying(255),
  comodos character varying(255),
  dt_atend character varying(255),
  dt_inter character varying(255),
  dt_nasc character varying(255),
  dest_lixo character varying(255),
  caso_doenca character varying(255),
  enc_esp character varying(255),
  enc_inter character varying(255),
  energia character varying(255),
  fezes_urina character varying(255),
  grupo_comun character varying(255),
  meio_comun character varying(255),
  meio_transp character varying(255),
  municipio character varying(255),
  proc_cod character varying(255),
  proc_desc character varying(255),
  qtdmed_disp character varying(255),
  qtdmed_npadrao character varying(255),
  qtdmed_presc character varying(255),
  sexo character varying(255),
  sol_exame character varying(255),
  tipo_hab character varying(255),
  tipounid_cod character varying(255),
  tipounid_desc character varying(255),
  trat_agua character varying(255),
  unid_cod character varying(255),
  unid_desc character varying(255),
  unid_dest_inter character varying(255),
  unid_sol_inter character varying(255),
  CONSTRAINT registrodeatendimento_pkey PRIMARY KEY (id)
) WITH (OIDS=FALSE);
ALTER TABLE registrodeatendimento OWNER TO postgres;

COPY registrodeatendimento
(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,
proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,
enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,
abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,
meio_transp,municipio,bairro)
FROM 'C:\Users\leoja\Desktop\teste\saude_dentistas-dados_abertos.csv'using delimiters ';' WITH NULL AS '' encoding 'latin1' CSV HEADER;
COPY registrodeatendimento
(dt_atend,dt_nasc,sexo,tipounid_cod,tipounid_desc,unid_cod,unid_desc,proc_cod,
proc_desc,cbo_cod,cbo_desc,cid_cod,cid_desc,sol_exame,qtdmed_presc,qtdmed_disp,qtdmed_npadrao,
enc_esp,area_atuacao,enc_inter,dt_inter,unid_sol_inter,unid_dest_inter,cid_inter,trat_agua,
abast_agua,energia,tipo_hab,dest_lixo,fezes_urina,comodos,caso_doenca,grupo_comun,meio_comun,
meio_transp,municipio,bairro)
FROM 'C:\Users\leoja\Desktop\teste\saude_outrosprofissionais-dados_abertos.csv'using delimiters ';' WITH NULL AS '' encoding 'latin1' CSV HEADER;

