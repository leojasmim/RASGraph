package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Paciente;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade do Municipio.
 *
 * @author LeonardoJasmim
 */
public class PacienteDAO extends RepositoryBaseJPA<Paciente, Long>{

    public PacienteDAO() {
        super(Paciente.class);
    }
    
}
