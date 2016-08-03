package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.MeioTransporte;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade MeioTransporteDAO.
 *
 * @author LeonardoJasmim
 */
public class MeioTransporteDAO extends RepositoryBaseJPA<MeioTransporte, Long> {

    public MeioTransporteDAO() {
        super(MeioTransporte.class);
    }

    public MeioTransporte find(MeioTransporte meioTrans) {
        try {
            return (MeioTransporte) getEntityManager().createQuery("Select mt from MeioTransporte AS mt "
                    + "where mt.descricao like'" + meioTrans.getDescricao() + "'").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
