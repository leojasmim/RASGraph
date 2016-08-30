//CREATE_RASGRAPH

//CREATE NODES

//Create Municipio
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///municipio.csv" AS row
CREATE (:Municipio {nome: row.nome, municipioID: row.id, codigoUF: row.codigouf, 
ibge: row.ibge, populacao2015: row.populacao2015, regiaoFederal: row.regiaofederal, uf: row.uf});

// Create Bairro
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///bairro.csv" AS row
CREATE (:Bairro {nome: row.nome, bairroID: row.id});

// Create Lixo
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///coletalixo.csv" AS row
CREATE (:Lixo {descricao: row.descricao, lixoID: row.id});

// Create TratamentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///tratamentoagua.csv" AS row
CREATE (:TratamentoAgua {descricao: row.descricao, tratamentoaguaID: row.id});

// Create AbastecimentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///abastecimentoagua.csv" AS row
CREATE (:AbastecimentoAgua {descricao: row.descricao, abastecimentoaguaID: row.id});

// Create TipoHabitacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///tipohabitacao.csv" AS row
CREATE (:TipoHabitacao {descricao: row.descricao, tipohabitacaoID: row.id});

// Create Esgotamento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///esgotamento.csv" AS row
CREATE (:Esgotamento {descricao: row.descricao, esgotamentoID: row.id});

// Create Residencia
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
CREATE (:Residencia {residenciaID: row.id, energiaEletrica: row.energia, comodos: row.comodos});

// Create GrupoComunitario
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///grupocomunitario.csv" AS row
CREATE (:GrupoComunitario {grupocomunitarioID: row.id, descricao: row.descricao});

// Create MeioComunicacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///meiocomunicacao.csv" AS row
CREATE (:MeioComunicacao {meiocomunicacaoID: row.id, descricao: row.descricao});

// Create MeioTransporte
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///meiotransporte.csv" AS row
CREATE (:MeioTransporte {meiotransporteID: row.id, descricao: row.descricao});

// Create PerfilSaude
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///perfilsaude.csv" AS row
CREATE (:PerfilSaude {perfilsaudeID: row.id, descricao: row.descricao});

// Create Paciente
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///paciente.csv" AS row
CREATE (:Paciente {pacienteID: row.id, codigo: row.codigo, dataNascimento: row.datanascimento, sexo: row.sexo});

// Create TipoUnidade
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///tipounidade.csv" AS row
CREATE (:TipoUnidade {tipounidadeID: row.id, codigo: row.codigo, descricao: row.descricao});

// Create UnidadeSaude
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///unidadesaude.csv" AS row
CREATE (:UnidadeSaude {unidadesaudeID: row.id, cnes: row.cnes, nome: row.nome});

// Create ProfissionalSaude
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///profissionalsaude.csv" AS row
CREATE (:ProfissionalSaude {profissionalsaudeID: row.id, cbo: row.cbo, descricao: row.descricao});

// Create Procedimento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///procedimento.csv" AS row
CREATE (:Procedimento {procedimentoID: row.id, descricao: row.descricao, codigo: row.codigo});

// Create Especialidade
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///especialidade.csv" AS row
CREATE (:Especialidade {especialidadeID: row.id, area: row.area});

// Create Doenca
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///doenca.csv" AS row
CREATE (:Doenca {doencaID: row.id, cid: row.cid, descricao: row.descricao});

// Create Internacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///internacao.csv" AS row
CREATE (:Internacao {internacaoID: row.id, dataInternacao: row.datainternacao});

// Create Atendimento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
CREATE (:Atendimento {atendimentoID: row.id, dataAtendimento: row.dataatendimento, solicitadoExame: row.solicitadoexame, 
QtdMedicacaoPrescrita: row.qtd_med_prescrita, QtdMedicacaoDispensada: row.qtd_med_dispensada, QtdMedicacaoNaoPadrao: row.qtd_med_npadrao});

//CREATE INDEXES

CREATE INDEX ON :Municipio(municipioID);
CREATE INDEX ON :Municipio(ibge);
CREATE INDEX ON :Bairro (bairroID);
CREATE INDEX ON :Lixo (lixoID);
CREATE INDEX ON :TratamentoAgua (tratamentoaguaID);
CREATE INDEX ON :AbastecimentoAgua (abastecimentoaguaID);
CREATE INDEX ON :TipoHabitacao (tipohabitacaoID);
CREATE INDEX ON :Esgotamento (esgotamentoID);
CREATE INDEX ON :Residencia (residenciaID);
CREATE INDEX ON :GrupoComunitario (grupocomunitarioID);
CREATE INDEX ON :MeioComunicacao (meiocomunicacaoID);
CREATE INDEX ON :MeioTransporte (meiotransporteID);
CREATE INDEX ON :PerfilSaude (perfilsaudeID);
CREATE INDEX ON :Paciente (pacienteID);
CREATE INDEX ON :Paciente (codigo);
CREATE INDEX ON :TipoUnidade (tipounidadeID);
CREATE INDEX ON :TipoUnidade (codigo);
CREATE INDEX ON :UnidadeSaude (unidadesaudeID);
CREATE INDEX ON :UnidadeSaude (cnes);
CREATE INDEX ON :ProfissionalSaude (profissionalsaudeID);
CREATE INDEX ON :ProfissionalSaude (cbo);
CREATE INDEX ON :Procedimento (procedimentoID);
CREATE INDEX ON :Procedimento (codigo);
CREATE INDEX ON :Especialidade (especialidadeID);
CREATE INDEX ON :Doenca (doencaID);
CREATE INDEX ON :Doenca (cid);
CREATE INDEX ON :Internacao (internacaoID);
CREATE INDEX ON :Atendimento (atendimentoID);

//CREATE RELATIONSHIP

//Bairro->Municipio
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///bairro.csv" AS row
MATCH (bairro:Bairro {bairroID: row.id})
MATCH (municipio:Municipio {municipioID: row.municipio_id})
MERGE (bairro)-[:LOCALIZADO_EM]->(municipio);

//Residencia -> Bairro
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (bairro:Bairro {bairroID: row.bairro_id})
MERGE (residencia)-[:SITUADA_EM]->(bairro)

//Residencia -> Lixo
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (lixo:Lixo {lixoID: row.coletalixo_id})
MERGE (residencia)-[:DA_DESTINO_AO]->(lixo)

//Residencia -> AbastecimentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (abastecimentoagua:AbastecimentoAgua {abastecimentoaguaID: row.abastecimentoagua_id})
MERGE (residencia)-[:ABASTECIDA_POR]->(abastecimentoagua)

//Residencia -> TratamentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (tratamentoagua:TratamentoAgua {tratamentoaguaID: row.tratamentoagua_id})
MERGE (residencia)-[:FAZ]->(tratamentoagua)

//Residencia -> TipoHabitacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (tipohabitacao:TipoHabitacao {tipohabitacaoID: row.tipohab_id})
MERGE (residencia)-[:E_DE_UM]->(tipohabitacao)

//Residencia -> Esgotamento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///residencia.csv" AS row
MATCH (residencia:Residencia {residenciaID: row.id})
MATCH (esgotamento:Esgotamento {esgotamentoID: row.esgotamento_id})
MERGE (residencia)-[:CONTEM_UM_SISTEMA]->(esgotamento);

//Paciente Relationships
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///paciente.csv" AS row
MATCH (paciente:Paciente {pacienteID: row.id})
MATCH (residencia:Residencia {residenciaID: row.residencia_id})
MATCH (grupocomunitario:GrupoComunitario {grupocomunitarioID: row.grupocomunitario_id})
MATCH (meiocomunicacao:MeioComunicacao {meiocomunicacaoID: row.meiocomunicacao_id})
MATCH (meiotransporte:MeioTransporte {meiotransporteID: row.meiotransporte_id})
MATCH (perfilsaude:PerfilSaude {perfilsaudeID: row.perfilsaude_id})
MERGE (paciente)-[:MORA_EM]->(residencia)
MERGE (paciente)-[:PARTICIPA_DE]->(grupocomunitario)
MERGE (paciente)-[:ACESSA]->(meiocomunicacao)
MERGE (paciente)-[:UTILIZA]->(meiotransporte)
MERGE (paciente)-[:TEM]->(perfilsaude);

//UnidadeSaude->Tipo
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///unidadesaude.csv" AS row
MATCH (unidadesaude:UnidadeSaude {unidadesaudeID: row.id})
MATCH (tipounidade:TipoUnidade {tipounidadeID: row.tipounidade_id})
MERGE (unidadesaude)-[:E_DO_TIPO]->(tipounidade)

//UnidadeSaude->Bairro
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///unidadesaude.csv" AS row
MATCH (unidadesaude:UnidadeSaude {unidadesaudeID: row.id})
MATCH (bairro:Bairro {bairroID: row.bairro_id})
MERGE (unidadesaude)-[:INSTALADA_EM]->(bairro);

//Internacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///internacao.csv" AS row
MATCH (internacao:Internacao {internacaoID: row.id})
MATCH (unidadesaude:UnidadeSaude {unidadesaudeID: row.unid_solic_id})
MATCH (unidadesaude:UnidadeSaude {unidadesaudeID: row.unid_dest_id})
MATCH (doenca:Doenca {doencaID: row.doenca_id})
MERGE (unidadesaude)-[:SOLICITA_UMA]->(internacao)
MERGE (unidadesaude)-[:RECEBE_UMA]->(internacao)
MERGE (internacao)-[:EM_DECORRENCIA_DE_UMA]->(doenca);

//Atendimento->Doenca
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (doenca:Doenca {doencaID: row.doenca_id})
MERGE (atendimento)-[:IDENTIFICA]->(doenca);

//Atendimento->Especialidade
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (especialidade:Especialidade {especialidadeID: row.especialidade_id})
MERGE (atendimento)-[:ENCAMINHA_PARA]->(especialidade);

//Atendimento->Internacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (internacao:Internacao {internacaoID: row.internacao_id})
MERGE (atendimento)-[:GERA_UMA]->(internacao);

//Paciente->Atendimento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (paciente:Paciente {pacienteID: row.paciente_id})
MERGE (paciente)-[:BUSCA]->(atendimento);

//Atendimento->Procedimento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (procedimento:Procedimento {procedimentoID: row.procedimento_id})
MERGE (atendimento)-[:GERA_UM]->(procedimento);

//Atendimento->ProfissionalSaude
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (profissionalsaude:ProfissionalSaude {profissionalsaudeID: row.profsaude_id})
MERGE (atendimento)-[:REALIZADO_POR_UM]->(profissionalsaude);

//UnidadeSaude->Atendimento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///atendimento.csv" AS row
MATCH (atendimento:Atendimento {atendimentoID: row.id})
MATCH (unidadesaude: UnidadeSaude {unidadesaudeID: row.unid_atend_id})
MERGE (unidadesaude)-[:PRESTA_UM]->(atendimento)

//QUERIES
//Todos os bairros do municipio do Rio de Janeiro
MATCH p=()-[r:LOCALIZADO_EM]->(m:Municipio) WHERE m.nome = 'RIO DE JANEIRO' RETURN p LIMIT 25
