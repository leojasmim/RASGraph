package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.registro.RegistroDeAtendimento;

/**
 * Classe DAO (Data Access Object) da entidade RegistroDeAtendimento
 * 
 * @author LeonardoJasmim
 */
public class RegistroDeAtendimentoDAO extends RepositoryBaseJPA<RegistroDeAtendimento, Long>{

    public RegistroDeAtendimentoDAO() {
        super(RegistroDeAtendimento.class);
    }
    
}
