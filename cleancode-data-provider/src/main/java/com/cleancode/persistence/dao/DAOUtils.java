package com.cleancode.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cleancode.persistence.model.entity.BaseEntity;

@Stateless
public class DAOUtils <ENTITY extends BaseEntity> {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	private Class<ENTITY> entityClass() {
		final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<ENTITY>) parameterizedType.getActualTypeArguments()[0];
	}

	public List<ENTITY> findAll(final int startPosition, final int maxResult) {
		final CriteriaQuery<ENTITY> query = this.entityManager.getCriteriaBuilder().createQuery(this.entityClass());
		final Root<? extends ENTITY> root = query.from(this.entityClass());
		query.select(root);
		return this.entityManager.createQuery(query).setFirstResult(startPosition).setMaxResults(maxResult)
				.getResultList();
	}

	public ENTITY save(final ENTITY entity) {
		if (entity.getId() == null) {
			this.entityManager.persist(entity);

			return entity;
		} else {
			return this.entityManager.merge(entity);
		}
	}

	public ENTITY findById(final Long id) {
		return this.entityManager.find(this.entityClass(), id);
	}

	public void delete(final ENTITY entity) {
		final ENTITY _entity = this.entityManager.merge(entity);
		this.entityManager.remove(_entity);
	}

	public void deleteById(final Long id) {
		final ENTITY _entity = this.findById(id);
		this.entityManager.remove(_entity);
	}

	public Optional<ENTITY> findOptionalById(final Long id) {
		return Optional.ofNullable(this.findById(id));
	}

	public Stream<ENTITY> stream() {
		final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		final CriteriaQuery<ENTITY> q = cb.createQuery(this.entityClass());
		q.from(this.entityClass());

		return this.entityManager.createQuery(q).getResultStream();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
