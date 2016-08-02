package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.AbastecimentoAgua;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade AbastecimentoAgua.
 *
 * @author LeonardoJasmim
 */
public class AbastecimentoAguaDAO extends RepositoryBaseJPA<AbastecimentoAgua, Long>{

    public AbastecimentoAguaDAO() {
        super(AbastecimentoAgua.class);
    }
}
