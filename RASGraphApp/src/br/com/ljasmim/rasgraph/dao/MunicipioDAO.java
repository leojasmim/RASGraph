package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Municipio;

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
    public Municipio find(Municipio municipio) {
        try {
            return (Municipio) getEntityManager().createQuery("Select m from Municipio AS m "
                    + "where m.nome like '" + municipio.getNome() + "'").getSingleResult();
        } catch (Exception e) {
            return (Municipio) getEntityManager().createQuery("Select m from Municipio AS m "
                    + "where m.ibge = 0000000").getSingleResult();
        }
    }
}
