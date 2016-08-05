package br.com.ljasmim.rasgraph.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Classe JPA que implementa a interface IRepositoryBase para as negociações com
 * a base de dados.
 *
 * @author LeonardoJasmim
 * @since Abril/2016
 * @version 1.0
 * @param <T> Classe que herda de RepositoryBaseJPA
 * @param <PK> Tipo do ID chave primária
 */
public class RepositoryBaseJPA< T, PK extends Serializable> implements IRepositoryBase<T, PK> {

    static JPAConnectionManager connection;
    private Class<T> entityClass;

    public RepositoryBaseJPA(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public EntityManager getEntityManager() {
        if (connection == null) {
            connection = new JPAConnectionManager();
        }
        return connection.getEntityManager();
    }

    @Override
    public T save(T entity) {
        T saved = null;
        try {
            getEntityManager().getTransaction().begin();
            saved = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
        return saved;
    }

    @Override
    public void remove(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public T getByID(PK pk) {
        try {
            return getEntityManager().find(entityClass, pk);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        return getEntityManager().createQuery("Select o from " + entityClass.getSimpleName() + " o").getResultList();
    }

    @Override
    public Long count() {
        TypedQuery<Long> query = getEntityManager().createQuery("Select count(o) from " + entityClass.getSimpleName() + " o", Long.class);
        return query.getSingleResult();
    }

    /**
     * Retorna uma conexão estabelecida atraves do método
     * DriverManager.getConnection().
     *
     * @return Objeto Connection com a conexão estabelecida; Objeto null caso
     * contrário
     * @throws SQLException
     */
    public static Connection getDataConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/rasgraph_db", "postgres", "postgres");
    }

    /**
     * Testa se a conexão com a base vigdengue_db é valida.
     *
     * @return true se a conexão for válida; false caso contrário;
     */
    public static boolean isConexaoValida() {
        try {
            return getDataConnection().isValid(0);
        } catch (Exception e) {
            return false;
        }
    }
}
