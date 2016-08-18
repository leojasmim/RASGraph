//Create Municipio
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/municipio.csv" AS row
CREATE (:Municipio {nome: row.nome, municipioID: row.id});
// Create Bairro
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/bairro.csv" AS row
CREATE (:Bairro {nome: row.nome, bairroID: row.id});
// Create Lixo
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/coletalixo.csv" AS row
CREATE (:Lixo {descricao: row.descricao, lixoID: row.id});
// Create TratamentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/tratamentoagua.csv" AS row
CREATE (:TratamentoAgua {descricao: row.descricao, tratamentoaguaID: row.id});
// Create AbastecimentoAgua
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/abastecimentoagua.csv" AS row
CREATE (:AbastecimentoAgua {descricao: row.descricao, abastecimentoaguaID: row.id});
// Create TipoHabitacao
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/tipohabitacao.csv" AS row
CREATE (:TipoHabitacao {descricao: row.descricao, tipohabitacaoID: row.id});
// Create Esgotamento
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/esgotamento.csv" AS row
CREATE (:Esgotamento {descricao: row.descricao, esgotamentoID: row.id});
// Create Residencia
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/residencia.csv" AS row
CREATE (:Residencia {residenciaID: row.id, energiaEletrica: row.energiaeletrica, comodos: row.comodos});

//
CREATE INDEX ON :Municipio(municipioID);
CREATE INDEX ON :Municipio(nome);
CREATE INDEX ON :Bairro (bairroID);
CREATE INDEX ON :Lixo (lixoID);
CREATE INDEX ON :TratamentoAgua (tratamentoaguaID);
CREATE INDEX ON :AbastecimentoAgua (abastecimentoaguaID));
CREATE INDEX ON :TipoHabitacao (tipohabitacaoID));
CREATE INDEX ON :Esgotamento (esgotamentoID);
CREATE INDEX ON :Residencia (residenciaID);


//Relationship Municipio->Bairro
USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:///rasgraphCsv/bairro.csv" AS row
MATCH (bairro:Bairro {bairroId: row.id})
MATCH (municipio:Municipio {municipioId: row.municipio_id})
MERGE (bairro)-[:LOCALIZADO_EM]->(municipio);