//QUERIES

//Todos os bairros do municipio do Rio de Janeiro
MATCH p=()-[r:LOCALIZADO_EM]->(m:Municipio) WHERE m.nome = 'RIO DE JANEIRO' RETURN p LIMIT 25

//Atendimento dos pacientes residentes na cidade do Rio de Janeiro
MATCH n = (m:Municipio{nome:'RIO DE JANEIRO'})<-[:LOCALIZADO_EM]-(b:Bairro)<-[:SITUADA_EM]-(r:Residencia)<-[:MORA_EM]-(p:Paciente)-[:BUSCA]->(a:Atendimento)-[:IDENTIFICA]->(d:Doenca) MATCH n1 = (a:Atendimento)<-[:PRESTA_UM]-(u:UnidadeSaude) RETURN n,n1

//Atendimentos de Zika Vírus
MATCH n = (t:TipoUnidade)<-[:E_DO_TIPO]-(u:UnidadeSaude)-[:PRESTA_UM]->(a:Atendimento)-[:IDENTIFICA]->(d:Doenca) WHERE d.cid CONTAINS 'A928'
RETURN n

//Atendimentos de Zika e Microcefalia
MATCH n = (m:Municipio)<-[:LOCALIZADO_EM]-(b:Bairro)<-[:SITUADA_EM]-(r:Residencia)<-[:MORA_EM]-(p:Paciente)-[:BUSCA]->(a:Atendimento)-[:IDENTIFICA]->(d:Doenca) WHERE d.cid CONTAINS 'A928' OR d.cid CONTAINS 'Q02' return n

//Unidades por Tipo
MATCH n = (u:UnidadeSaude)-[:E_DO_TIPO]->(t:TipoUnidade)
RETURN n

//Fluxo do paciente 95165 na rede
MATCH n = (p:Paciente)-[:BUSCA]->(a:Atendimento)-[:ENCAMINHA_PARA]->(e:Especialidade)
MATCH n1 = (p:Paciente)-[:BUSCA]->(a:Atendimento)-[:REALIZADO_POR_UM]->(prof:ProfissionalSaude)
MATCH n2 = (p:Paciente)-[:BUSCA]->(a:Atendimento)<-[:PRESTA_UM]-(u:UnidadeSaude)-[:E_DO_TIPO]->(t:TipoUnidade)
WHERE p.codigo = '95165'
return n,n1,n2