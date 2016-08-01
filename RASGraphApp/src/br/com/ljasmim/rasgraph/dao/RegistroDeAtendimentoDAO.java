package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.registro.RegistroDeAtendimento;
import java.util.List;

/**
 * Classe DAO (Data Access Object) da entidade RegistroDeAtendimento
 * 
 * @author LeonardoJasmim
 */
public class RegistroDeAtendimentoDAO extends RepositoryBaseJPA<RegistroDeAtendimento, Long>{

    public RegistroDeAtendimentoDAO() {
        super(RegistroDeAtendimento.class);
    }
    
    public RegistroDeAtendimento getFirst() {
        List<RegistroDeAtendimento> registros = getEntityManager().createQuery("Select r from "
                + "RegistroDeAtendimento AS r "
                + "order by r.id asc ").setMaxResults(1).getResultList();
        return registros.get(0);
    }
}
