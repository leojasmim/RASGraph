package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Doenca;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Doenca.
 *
 * @author LeonardoJasmim
 */
public class DoencaDAO extends RepositoryBaseJPA<Doenca, Long> {

    public DoencaDAO() {
        super(Doenca.class);
    }

}
