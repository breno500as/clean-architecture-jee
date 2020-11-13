package com.cleancode.core.manager;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.cleancode.core.contract.dao.CrudDAO;
import com.cleancode.core.contract.manager.CrudManager;
import com.cleancode.core.contract.model.dto.BaseDTO;

public class CrudManagerImpl<T extends BaseDTO> implements CrudManager<T> {
	
	@Inject
	private CrudDAO<T> dao;


	@Override
	public List<T> findAll(int startPosition, int maxResult) {
		return this.dao.findAll(startPosition, maxResult);
	}

	@Override
	public T save(T dto) {
		return this.dao.save(dto);
	}

	@Override
	public T findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public void delete(T dto) {
		 this.dao.delete(dto);
	}

	@Override
	public void deleteById(Long id) {
		 this.dao.deleteById(id);
	}

	@Override
	public Optional<T> findOptionalById(Long id) {
		return this.findOptionalById(id);
	}

}
