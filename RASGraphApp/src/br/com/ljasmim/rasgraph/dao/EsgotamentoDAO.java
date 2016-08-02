package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Esgotamento;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Esgotamento.
 *
 * @author LeonardoJasmim
 */
public class EsgotamentoDAO extends RepositoryBaseJPA<Esgotamento, Long> {

    public EsgotamentoDAO() {
        super(Esgotamento.class);
    }

}
