package com.cleancode.core.contract.dao;

import java.util.List;
import java.util.Optional;

import com.cleancode.core.contract.model.dto.BaseDTO;


public interface CrudDAO  <T extends BaseDTO>  {

	public List<T> findAll(final int startPosition, final int maxResult);

	public T save(final T dto);

	public T findById(final Long id);

	public void delete(final T dto);

	public void deleteById(final Long id);

	public Optional<T> findOptionalById(final Long id);
	
}
