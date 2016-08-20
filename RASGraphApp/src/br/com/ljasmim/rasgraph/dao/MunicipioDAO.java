package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Municipio;
import java.util.List;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade do Municipio.
 *
 * @author LeonardoJasmim
 */
public class MunicipioDAO extends RepositoryBaseJPA<Municipio, Long> {

    public MunicipioDAO() {
        super(Municipio.class);
    }

    //MODIFICAR FIND
    public List<Municipio> find(Municipio municipio) {
        try {
            return getEntityManager().createQuery("Select m from Municipio AS m "
                    + "where m.nome like '" + municipio.getNome() + "'").getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
