package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.PerfilSaude;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade PerfilSaude.
 *
 * @author LeonardoJasmim
 */
public class PerfilSaudeDAO extends RepositoryBaseJPA<PerfilSaude, Long> {

    public PerfilSaudeDAO() {
        super(PerfilSaude.class);
    }

}
