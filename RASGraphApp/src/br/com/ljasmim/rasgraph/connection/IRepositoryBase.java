package br.com.ljasmim.rasgraph.connection;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Interface JPA de métodos básicos para a negociações com a base de dados.
 *
 * @author Bruno Costa
 * @version 1.0
 * @param <T> Classe genérica que representa uma entidade da base de dados.
 * @param <PK> Chave primária da entidade.
 */
public interface IRepositoryBase< T, PK extends Serializable> {

    /**
     * Método abstrato que provê a API EntityManager conectada ao banco para as
     * operações CRUD.
     *
     * @return Objeto entityManager conectado.
     */
    public EntityManager getEntityManager();

    /**
     * Método abstrato para persistir um objeto na base de dados.
     *
     * @param entity Objeto instanciado.
     * @return Instância do objeto da classe T que foi persistido.
     */
    public T save(T entity);

    /**
     * Método abstrato para remover um objeto da base de dados.
     *
     * @param entity Objeto instanciado.
     */
    public void remove(T entity);

    /**
     * Método abstrato que retorna uma tupla de uma entidade referente ao ID
     * fornecido.
     *
     * @param pk ID que representa a chave primária.
     * @return Objeto instanciado.
     */
    public T getByID(PK pk);

    /**
     * Método abstrato que retorna todas as tuplas de uma entidade.
     *
     * @return Lista de objetos instanciados
     */
    public List<T> getAll();

    /**
     * Método abstrato que retorna o numero de tuplas de uma entidade.
     *
     * @return Número de objetos
     */
    public Long getCount();

}
