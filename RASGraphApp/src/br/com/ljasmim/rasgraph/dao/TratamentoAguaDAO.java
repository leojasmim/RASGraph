package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.TratamentoAgua;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade TratamentoAgua.
 *
 * @author LeonardoJasmim
 */
public class TratamentoAguaDAO extends RepositoryBaseJPA<TratamentoAgua, Long> {

    public TratamentoAguaDAO() {
        super(TratamentoAgua.class);
    }

    public TratamentoAgua find(TratamentoAgua tratamentoAgua) {
        try {
            return (TratamentoAgua) getEntityManager().createQuery("Select t from TratamentoAgua AS t"
                    + " where t.descricao like '" + tratamentoAgua.getDescricao() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
