package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.TipoHabitacao;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade TipoHabitacao.
 *
 * @author LeonardoJasmim
 */
public class TipoHabitacaoDAO extends RepositoryBaseJPA<TipoHabitacao, Long> {

    public TipoHabitacaoDAO() {
        super(TipoHabitacao.class);
    }

    public TipoHabitacao find(TipoHabitacao tipoHabitacao) {
        try {
            return (TipoHabitacao) getEntityManager().createQuery("Select th from TipoHabitacao AS th "
                    + "where th.descricao like '" + tipoHabitacao.getDescricao() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
