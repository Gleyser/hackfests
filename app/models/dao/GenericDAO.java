package models.dao;

import java.util.List;

import javax.persistence.Query;

/**
 * Serviços simples de um Data Access Object (DAO)
 */
public interface GenericDAO {
	/**
	 * Persiste uma entidade no Banco de Dados.
	 */
	boolean persist(Object e);

	/**
	 * Espelha o estado do DAO com o banco de Dados, deve ser feito após um
	 * persist, ou merge.
	 */
	void flush();

	/**
	 * Atualiza a informação da entidade do código com a do banco de dados.
	 */
	void merge(Object e);

	/**
	 * Procura uma certa {@code clazz} pelo seu {@code id}.
	 */
	<T> T findByEntityId(Class<T> clazz, Long id);

	/**
	 * Procura todos os objetos de uma certa classe pelo seu {@code className}
	 * descrito na Entidade.
	 */
	<T> List<T> findAllByClassName(String className);

	/**
	 * Deleta do banco de dados uma {@code classe} referenciada pelo seu
	 * {@code id}.
	 */
	<T> void removeById(Class<T> classe, Long id);

	/**
	 * Remove o respectivo {@code objeto} do banco de dados.
	 */
	void remove(Object objeto);

	/**
	 * Procura uma certa {@code className} pelo seu {@code attributeName}.
	 */
	<T> List<T> findByAttributeName(String className, String attributeName,
			String attributeValue);

	/**
	 * Cria uma Query HQL
	 */
	Query createQuery(String query);
}
