package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Internacao;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Internacao.
 *
 * @author LeonardoJasmim
 */
public class InternacaoDAO extends RepositoryBaseJPA<Internacao, Long>{

    public InternacaoDAO() {
        super(Internacao.class);
    }
    
}
