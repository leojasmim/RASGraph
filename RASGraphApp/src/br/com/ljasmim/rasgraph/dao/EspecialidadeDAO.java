package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Especialidade;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Especialidade.
 *
 * @author LeonardoJasmim
 */
public class EspecialidadeDAO extends RepositoryBaseJPA<Especialidade, Long> {

    public EspecialidadeDAO() {
        super(Especialidade.class);
    }

    public Especialidade find(Especialidade especialidade) {
        try {
            return (Especialidade) getEntityManager().createQuery("Select e from Especialidade AS e "
                    + "where e.area like '" + especialidade.getArea() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
