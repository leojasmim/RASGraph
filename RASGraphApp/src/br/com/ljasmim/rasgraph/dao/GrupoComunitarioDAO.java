package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.GrupoComunitario;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade GrupoComunitario.
 *
 * @author LeonardoJasmim
 */
public class GrupoComunitarioDAO extends RepositoryBaseJPA<GrupoComunitario, Long>{

    public GrupoComunitarioDAO() {
        super(GrupoComunitario.class);
    }
}
