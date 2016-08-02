package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Residencia;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Residencia.
 *
 * @author LeonardoJasmim
 */
public class ResidenciaDAO extends RepositoryBaseJPA<Residencia, Long> {

    public ResidenciaDAO() {
        super(Residencia.class);
    }

}
