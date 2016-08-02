package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.ColetaLixo;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade ColetaLixo.
 *
 * @author LeonardoJasmim
 */
public class ColetaLixoDAO extends RepositoryBaseJPA<ColetaLixo, Long> {

    public ColetaLixoDAO() {
        super(ColetaLixo.class);
    }

    public ColetaLixo find(ColetaLixo coleta) {
        try {
            return (ColetaLixo) getEntityManager().createQuery("Select c from ColetaLixo AS c "
                    + "where c.descricao like '" + coleta.getDescricao() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
