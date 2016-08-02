package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.ProfissionalSaude;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade ProfissionalSaude.
 *
 * @author LeonardoJasmim
 */
public class ProfissionalSaudeDAO extends RepositoryBaseJPA<ProfissionalSaude, Long> {

    public ProfissionalSaudeDAO() {
        super(ProfissionalSaude.class);
    }

}
