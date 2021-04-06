package com.cleancode.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cleancode.core.contract.dao.CrudDAO;
import com.cleancode.core.contract.model.dto.BaseDTO;
import com.cleancode.persistence.converter.BaseMapper;
import com.cleancode.persistence.model.entity.BaseEntity;

public abstract class CrudDAOImpl<DTO extends BaseDTO, ENTITY extends BaseEntity> implements CrudDAO<DTO> {

	@PersistenceContext
	private EntityManager entityManager;

	public abstract BaseMapper<DTO, ENTITY> getMapper();
	
	private Class<ENTITY> entityClass() {
		final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<ENTITY>) parameterizedType.getActualTypeArguments()[1];
	}

	@Override
	public List<DTO> findAll(final int startPosition, final int maxResult) {
		final CriteriaQuery<ENTITY> query = this.entityManager.getCriteriaBuilder().createQuery(this.entityClass());
		final Root<? extends ENTITY> root = query.from(this.entityClass());
		query.select(root);
		List<ENTITY> listEntity = this.entityManager.createQuery(query).setFirstResult(startPosition).setMaxResults(maxResult).getResultList();
		return listEntity.stream().map(E -> getMapper().mapToDto(E)).collect(Collectors.toList());
	}

	@Override
	public DTO save(DTO dto) {
		ENTITY entity = getMapper().mapToEntity(dto);

		if (entity.getId() == null) {
			this.entityManager.persist(entity);
			return this.getMapper().mapToDto(entity);
		} else {
			return this.getMapper().mapToDto(this.entityManager.merge(entity));
		}

	}

	@Override
	public DTO findById(Long id) {
		ENTITY entity =  this.entityManager.find(this.entityClass(), id);
		return this.getMapper().mapToDto(entity);
	}

	@Override
	public void delete(DTO dto) {
		final ENTITY entity = this.entityManager.merge(this.getMapper().mapToEntity(dto));
		this.entityManager.remove(entity);
		 
	}

	@Override
	public void deleteById(Long id) {
		ENTITY entity =  this.entityManager.find(this.entityClass(), id);
		this.entityManager.remove(entity);
		
	}

	@Override
	public Optional<DTO> findOptionalById(Long id) {
		return Optional.ofNullable(this.findById(id));
	}

}
