package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Atendimento;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Atendimento.
 *
 * @author LeonardoJasmim
 */
public class AtendimentoDAO extends RepositoryBaseJPA<Atendimento, Long>{

    public AtendimentoDAO() {
        super(Atendimento.class);
    }
}
