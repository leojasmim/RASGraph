package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.TipoUnidade;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade TipoUnidade.
 *
 * @author LeonardoJasmim
 */
public class TipoUnidadeDAO extends RepositoryBaseJPA<TipoUnidade, Long> {

    public TipoUnidadeDAO() {
        super(TipoUnidade.class);
    }

    public TipoUnidade find(TipoUnidade tipo) {
        try {
            return (TipoUnidade) getEntityManager().createQuery("SELECT t FROM TipoUnidade AS t "
                    + "WHERE t.codigo like '" + tipo.getCodigo() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
