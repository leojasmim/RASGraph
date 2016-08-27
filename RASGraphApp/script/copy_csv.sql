COPY (SELECT * FROM municipio) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\municipio.csv' WITH CSV header;
COPY (SELECT * FROM bairro) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\bairro.csv' WITH CSV header;
COPY (SELECT * FROM coletalixo) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\coletalixo.csv' WITH CSV header;
COPY (SELECT * FROM tratamentoagua) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\tratamentoagua.csv' WITH CSV header;
COPY (SELECT * FROM tipohabitacao) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\tipohabitacao.csv' WITH CSV header;
COPY (SELECT * FROM abastecimentoagua) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\abastecimentoagua.csv' WITH CSV header;
COPY (SELECT * FROM esgotamento) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\esgotamento.csv' WITH CSV header;
COPY (SELECT * FROM residencia) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\residencia.csv' WITH CSV header;

COPY (SELECT * FROM grupocomunitario) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\grupocomunitario.csv' WITH CSV header;
COPY (SELECT * FROM meiocomunicacao) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\meiocomunicacao.csv' WITH CSV header;
COPY (SELECT * FROM meiotransporte) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\meiotransporte.csv' WITH CSV header;
COPY (SELECT * FROM perfilsaude) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\perfilsaude.csv' WITH CSV header;
COPY (SELECT * FROM paciente) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\paciente.csv' WITH CSV header;

COPY (SELECT * FROM tipounidade) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\tipounidade.csv' WITH CSV header;
COPY (SELECT * FROM unidadesaude) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\unidadesaude.csv' WITH CSV header;
COPY (SELECT * FROM profissionalsaude) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\profissionalsaude.csv' WITH CSV header;
COPY (SELECT * FROM procedimento) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\procedimento.csv' WITH CSV header;
COPY (SELECT * FROM especialidade) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\especialidade.csv' WITH CSV header;
COPY (SELECT * FROM doenca) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\doenca.csv' WITH CSV header;
COPY (SELECT * FROM internacao) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\internacao.csv' WITH CSV header;

COPY (SELECT * FROM atendimento) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\atendimento.csv' WITH CSV header;