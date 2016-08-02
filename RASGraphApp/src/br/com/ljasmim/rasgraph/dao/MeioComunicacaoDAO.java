package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.MeioComunicacao;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade MeioComnunicacao.
 *
 * @author LeonardoJasmim
 */
public class MeioComunicacaoDAO extends RepositoryBaseJPA<MeioComunicacao, Long>{

    public MeioComunicacaoDAO() {
        super(MeioComunicacao.class);
    }
    
}
