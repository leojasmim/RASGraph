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

    public Doenca find(Doenca doenca) {
        try {
            return (Doenca) getEntityManager().createQuery("SELECT d from Doenca AS d "
                    + "where d.cid like '" + doenca.getCid() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
