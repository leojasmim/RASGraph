package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Procedimento;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Procedimento.
 *
 * @author LeonardoJasmim
 */
public class ProcedimentoDAO extends RepositoryBaseJPA<Procedimento, Long> {

    public ProcedimentoDAO() {
        super(Procedimento.class);
    }

}
