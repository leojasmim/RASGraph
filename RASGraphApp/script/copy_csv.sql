COPY (SELECT * FROM municipio) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\municipio.csv' WITH CSV header;
COPY (SELECT * FROM bairro) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\bairro.csv' WITH CSV header;
COPY (SELECT * FROM coletalixo) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\coletalixo.csv' WITH CSV header;
COPY (SELECT * FROM tratamentoagua) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\tratamentoagua.csv' WITH CSV header;
COPY (SELECT * FROM tipohabitacao) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\tipohabitacao.csv' WITH CSV header;
COPY (SELECT * FROM abastecimentoagua) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\abastecimentoagua.csv' WITH CSV header;
COPY (SELECT * FROM esgotamento) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\esgotamento.csv' WITH CSV header;
COPY (SELECT * FROM residencia) TO 'C:\Users\leoja\Documents\Neo4j\rasgraph.db\import\residencia.csv' WITH CSV header;





