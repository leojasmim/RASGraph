package br.com.ljasmim.rasgraph.dao;

import br.com.ljasmim.rasgraph.connection.RepositoryBaseJPA;
import br.com.ljasmim.rasgraph.domain.Paciente;
import java.util.List;

/**
 * Classe padrão DAO(Data Access Object) que herda de RepositoryBaseJPA e
 * persiste uma entidade do Municipio.
 *
 * @author LeonardoJasmim
 */
public class PacienteDAO extends RepositoryBaseJPA<Paciente, Long> {

    public PacienteDAO() {
        super(Paciente.class);
    }

    public List<Paciente> find(Paciente p) {
        try {
            return getEntityManager().createQuery("SELECT p FROM Paciente AS p "
                    + "WHERE p.dataNascimento = '" + p.getDataNascimento() + "' AND "
                    + "p.sexo like '" + p.getSexo() + "' "
                    + "ORDER BY p.codigo").getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
