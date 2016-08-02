package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.UnidadeSaude;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade UnidadeSaude.
 *
 * @author LeonardoJasmim
 */
public class UnidadeSaudeDAO extends RepositoryBaseJPA<UnidadeSaude, Long> {

    public UnidadeSaudeDAO() {
        super(UnidadeSaude.class);
    }
}
