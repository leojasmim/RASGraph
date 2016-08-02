package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.MeioTransporte;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 persiste uma entidade MeioTransporteDAO.
 *
 * @author LeonardoJasmim
 */

public class MeioTransporteDAO extends RepositoryBaseJPA<MeioTransporte, Long>{

    public MeioTransporteDAO() {
        super(MeioTransporte.class);
    }
    
}
