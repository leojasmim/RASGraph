package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Bairro;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade Bairro.
 *
 * @author LeonardoJasmim
 */
public class BairroDAO extends RepositoryBaseJPA<Bairro, Long> {

    public BairroDAO() {
        super(Bairro.class);
    }

    public Bairro find(Bairro bairro) {
        try {
            return (Bairro) getEntityManager().createQuery("Select b from Bairro b"
                    + " where b.nome like '" + bairro.getNome() + "' AND"
                    + " b.municipio.id = " + bairro.getMunicipio().getId()).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
