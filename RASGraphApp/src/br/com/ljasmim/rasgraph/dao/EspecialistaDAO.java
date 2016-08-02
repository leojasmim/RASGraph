package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Especialista;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Especialista.
 *
 * @author LeonardoJasmim
 */
public class EspecialistaDAO extends RepositoryBaseJPA<Especialista, Long> {

    public EspecialistaDAO() {
        super(Especialista.class);
    }

}
