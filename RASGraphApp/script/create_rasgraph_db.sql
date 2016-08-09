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
CREATE TABLE registrodeatendimento(
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
)WITH(OIDS=FALSE);
ALTER TABLE registrodeatendimento OWNER TO postgres;

DROP TABLE IF EXISTS municipio CASCADE;
CREATE TABLE municipio(
  id bigserial NOT NULL,
  nome character varying(255) NOT NULL,
  CONSTRAINT municipio_pkey PRIMARY KEY (id),
  CONSTRAINT uk_pas4awibw1tkx1cg5ga055gmm UNIQUE (nome)
)WITH(OIDS=FALSE);
ALTER TABLE municipio OWNER TO postgres;

DROP TABLE IF EXISTS bairro CASCADE;
CREATE TABLE bairro(
  id bigserial NOT NULL,
  nome character varying(255) NOT NULL,
  municipio_id bigint,
  CONSTRAINT bairro_pkey PRIMARY KEY (id),
  CONSTRAINT fk_3rys0fdylc9is4dk0cem4ssu5 FOREIGN KEY (municipio_id)
      REFERENCES municipio (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_legk2antvivsrqlnqxvvavdou UNIQUE (nome, municipio_id)
)WITH(OIDS=FALSE);
ALTER TABLE bairro OWNER TO postgres;

DROP TABLE IF EXISTS coletalixo CASCADE;
CREATE TABLE coletalixo(
  id bigserial NOT NULL,
  descricao character varying(255) NOT NULL,
  CONSTRAINT coletalixo_pkey PRIMARY KEY (id),
  CONSTRAINT uk_sfi7vy5cg6gva0ymn420vp4d6 UNIQUE (descricao)
)WITH(OIDS=FALSE);
ALTER TABLE coletalixo OWNER TO postgres;

DROP TABLE IF EXISTS tratamentoagua CASCADE;
CREATE TABLE tratamentoagua(
  id bigserial NOT NULL,
  descricao character varying(255) NOT NULL,
  CONSTRAINT tratamentoagua_pkey PRIMARY KEY (id),
  CONSTRAINT uk_3sncvj4urmktw07fg7p112323 UNIQUE (descricao)
)WITH(OIDS=FALSE);
ALTER TABLE tratamentoagua OWNER TO postgres;

DROP TABLE IF EXISTS tipohabitacao CASCADE;
CREATE TABLE tipohabitacao(
  id bigserial NOT NULL,
  descricao character varying(255) NOT NULL,
  CONSTRAINT tipohabitacao_pkey PRIMARY KEY (id),
  CONSTRAINT uk_862iajp0vxk323bqf8muwyoc2 UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE tipohabitacao OWNER TO postgres;

DROP TABLE IF EXISTS abastecimentoagua CASCADE;
CREATE TABLE abastecimentoagua(
  id bigserial NOT NULL,
  descricao character varying(255) NOT NULL,
  CONSTRAINT abastecimentoagua_pkey PRIMARY KEY (id),
  CONSTRAINT uk_i7j9gd3cnhy9sjy7h7qlwt2h7 UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE abastecimentoagua OWNER TO postgres;

DROP TABLE IF EXISTS esgotamento CASCADE;
CREATE TABLE esgotamento(
  id bigserial NOT NULL,
  descricao character varying(255),
  CONSTRAINT esgotamento_pkey PRIMARY KEY (id),
  CONSTRAINT uk_tbfu8k6k5ojyjpworvvs7hety UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE esgotamento OWNER TO postgres;

DROP TABLE IF EXISTS residencia CASCADE;
CREATE TABLE residencia(
  id bigserial NOT NULL,
  comodos integer,
  energia boolean,
  abastecimentoagua_id bigint,
  bairro_id bigint,
  coletalixo_id bigint,
  esgotamento_id bigint,
  tipohab_id bigint,
  tratamentoagua_id bigint,
  CONSTRAINT residencia_pkey PRIMARY KEY (id),
  CONSTRAINT fk_1el1ue6sydrl3hx94fsace8sd FOREIGN KEY (tipohab_id)
      REFERENCES tipohabitacao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_72cp9rmdidp6syanm85l3adhm FOREIGN KEY (esgotamento_id)
      REFERENCES esgotamento (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_esqaph3wk6fcd3t54die0j8ws FOREIGN KEY (tratamentoagua_id)
      REFERENCES tratamentoagua (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_fg7mdc6gigyq3eb1gagt37d4b FOREIGN KEY (coletalixo_id)
      REFERENCES coletalixo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_i4m8dda3dxtyll4kj8effaljg FOREIGN KEY (bairro_id)
      REFERENCES bairro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_sdxa7f1c8bgwsp362rfbqgi95 FOREIGN KEY (abastecimentoagua_id)
      REFERENCES abastecimentoagua (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);
ALTER TABLE residencia OWNER TO postgres;

DROP TABLE IF EXISTS grupocomunitario CASCADE;
CREATE TABLE grupocomunitario(
  id bigserial NOT NULL,
  descricao character varying(255),
  CONSTRAINT grupocomunitario_pkey PRIMARY KEY (id),
  CONSTRAINT uk_mk4mkg6spk3r92a8eo9bi49k8 UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE grupocomunitario OWNER TO postgres;

DROP TABLE IF EXISTS meiocomunicacao CASCADE;
CREATE TABLE meiocomunicacao(
  id bigserial NOT NULL,
  descricao character varying(255),
  CONSTRAINT meiocomunicacao_pkey PRIMARY KEY (id),
  CONSTRAINT uk_p1ryiat6s30iybwupel2uxa3e UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE meiocomunicacao OWNER TO postgres;

DROP TABLE IF EXISTS meiotransporte CASCADE;
CREATE TABLE meiotransporte(
  id bigserial NOT NULL,
  descricao character varying(255),
  CONSTRAINT meiotransporte_pkey PRIMARY KEY (id),
  CONSTRAINT uk_dgivqfpxpqya7lejafxc8xgdu UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE meiotransporte OWNER TO postgres;

DROP TABLE IF EXISTS perfilsaude CASCADE;
CREATE TABLE perfilsaude(
  id bigserial NOT NULL,
  descricao character varying(255),
  CONSTRAINT perfilsaude_pkey PRIMARY KEY (id),
  CONSTRAINT uk_bg6xmx1imtwe3s5skjkwx3400 UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE perfilsaude OWNER TO postgres;

DROP TABLE IF EXISTS paciente CASCADE;
CREATE TABLE paciente(
  id bigserial NOT NULL,
  codigo integer NOT NULL,
  datanascimento date,
  sexo character varying(255),
  grupocomunitario_id bigint,
  meiocomunicacao_id bigint,
  meiotransporte_id bigint,
  perfilsaude_id bigint,
  residencia_id bigint,
  CONSTRAINT paciente_pkey PRIMARY KEY (id),
  CONSTRAINT fk_5kb8u4xuo7ijtk30bgt9s4bio FOREIGN KEY (residencia_id)
      REFERENCES residencia (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_82nh101nemcebkwtgvb7am3sd FOREIGN KEY (meiocomunicacao_id)
      REFERENCES meiocomunicacao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_g9lk3xmj07hueo8u9s1qgxqav FOREIGN KEY (meiotransporte_id)
      REFERENCES meiotransporte (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_kwms2rvo3f4kthqe9aw8mfl7c FOREIGN KEY (grupocomunitario_id)
      REFERENCES grupocomunitario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_of804g3pp1xm2oijnp0w00rwc FOREIGN KEY (perfilsaude_id)
      REFERENCES perfilsaude (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);
ALTER TABLE paciente OWNER TO postgres;

DROP TABLE IF EXISTS procedimento CASCADE;
CREATE TABLE procedimento(
  id bigserial NOT NULL,
  codigo character varying(255),
  descricao character varying(255),
  CONSTRAINT procedimento_pkey PRIMARY KEY (id),
  CONSTRAINT uk_kk6rwjftubpqd1g14ean2aq7v UNIQUE (codigo)
) WITH (OIDS=FALSE);
ALTER TABLE procedimento OWNER TO postgres;

DROP TABLE IF EXISTS profissionalsaude CASCADE;
CREATE TABLE profissionalsaude(
  id bigserial NOT NULL,
  cbo character varying(255),
  descricao character varying(255),
  CONSTRAINT profissionalsaude_pkey PRIMARY KEY (id),
  CONSTRAINT uk_ajpxhrq27so53tq0vhldnfe0g UNIQUE (descricao),
  CONSTRAINT uk_klfw1rigvt7vn28yemxrobmoq UNIQUE (cbo)
) WITH (OIDS=FALSE);
ALTER TABLE profissionalsaude OWNER TO postgres;

DROP TABLE IF EXISTS especialidade CASCADE;
CREATE TABLE especialidade(
  id bigserial NOT NULL,
  area character varying(255),
  CONSTRAINT especialidade_pkey PRIMARY KEY (id),
  CONSTRAINT uk_kxjqchwqjhlxo7b59g7p3wim4 UNIQUE (area)
) WITH (OIDS=FALSE);
ALTER TABLE especialidade OWNER TO postgres;

DROP TABLE IF EXISTS doenca CASCADE;
CREATE TABLE doenca(
  id bigserial NOT NULL,
  cid character varying(255),
  descricao character varying(255),
  CONSTRAINT doenca_pkey PRIMARY KEY (id),
  CONSTRAINT uk_5cjq1gkdr5y2w98keb1ed19d4 UNIQUE (cid, descricao)
) WITH (OIDS=FALSE);
ALTER TABLE doenca OWNER TO postgres;

DROP TABLE IF EXISTS tipounidade CASCADE;
CREATE TABLE tipounidade(
  id bigserial NOT NULL,
  codigo character varying(255),
  descricao character varying(255),
  CONSTRAINT tipounidade_pkey PRIMARY KEY (id),
  CONSTRAINT uk_3uvwt7g97y41ikn6bx4tbsf3c UNIQUE (codigo),
  CONSTRAINT uk_g7raf39bbm9pjsuaguk5jc39u UNIQUE (descricao)
) WITH (OIDS=FALSE);
ALTER TABLE tipounidade OWNER TO postgres;

DROP TABLE IF EXISTS unidadesaude CASCADE;
CREATE TABLE unidadesaude(
  id bigserial NOT NULL,
  cnes character varying(255),
  nome character varying(255),
  tipounidade_id bigint,
  CONSTRAINT unidadesaude_pkey PRIMARY KEY (id),
  CONSTRAINT fk_mem0kevpud2xbs15o411pokow FOREIGN KEY (tipounidade_id)
      REFERENCES tipounidade (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_s2y1ybsjh9gr8x5mwgrqkylg4 UNIQUE (nome)
) WITH (OIDS=FALSE);
ALTER TABLE unidadesaude OWNER TO postgres;

DROP TABLE IF EXISTS internacao CASCADE;
CREATE TABLE internacao(
  id bigserial NOT NULL,
  datainternacao timestamp without time zone,
  doenca_id bigint,
  unid_dest_id bigint,
  unid_solic_id bigint,
  CONSTRAINT internacao_pkey PRIMARY KEY (id),
  CONSTRAINT fk_aoctwpbukgrf69oovafs9fb5n FOREIGN KEY (unid_dest_id)
      REFERENCES unidadesaude (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_closdei4d86digv48yc2ks0mx FOREIGN KEY (unid_solic_id)
      REFERENCES unidadesaude (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ml1dq2as8ceyb6mcq3i4lja0w FOREIGN KEY (doenca_id)
      REFERENCES doenca (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);
ALTER TABLE internacao OWNER TO postgres;

DROP TABLE IF EXISTS atendimento CASCADE;
CREATE TABLE atendimento(
  id bigserial NOT NULL,
  dataatendimento timestamp without time zone,
  qtd_med_dispensada integer,
  qtd_med_npadrao integer,
  qtd_med_prescrita integer,
  solicitadoexame boolean NOT NULL,
  doenca_id bigint,
  especialidade_id bigint,
  internacao_id bigint,
  paciente_id bigint,
  procedimento_id bigint,
  profsaude_id bigint,
  unid_atend_id bigint,
  CONSTRAINT atendimento_pkey PRIMARY KEY (id),
  CONSTRAINT fk_a6emee9500tkw1wy27a8eyxyd FOREIGN KEY (unid_atend_id)
      REFERENCES unidadesaude (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_a7fyaw2cjdylp6q9l8lrinh3v FOREIGN KEY (profsaude_id)
      REFERENCES profissionalsaude (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_dacbn4qoatoenq73mpqvywfkr FOREIGN KEY (especialidade_id)
      REFERENCES especialidade (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_fw2povxobemqk6728pl76krs7 FOREIGN KEY (doenca_id)
      REFERENCES doenca (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ite0qr8hbpj9x6cor0sjwvii4 FOREIGN KEY (procedimento_id)
      REFERENCES procedimento (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_l28sk0yqtopbmcmab3vkh37pf FOREIGN KEY (paciente_id)
      REFERENCES paciente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_rvb4k7t7fp8lj774pxa6ckjm FOREIGN KEY (internacao_id)
      REFERENCES internacao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);
ALTER TABLE atendimento OWNER TO postgres;





