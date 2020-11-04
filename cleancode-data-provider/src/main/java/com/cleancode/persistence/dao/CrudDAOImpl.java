package com.cleancode.persistence.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.cleancode.core.contract.dao.CrudDAO;
import com.cleancode.core.contract.dto.BaseDTO;
import com.cleancode.persistence.converter.BaseMapper;
import com.cleancode.persistence.entity.BaseEntity;

public abstract class CrudDAOImpl<DTO extends BaseDTO, ENTITY extends BaseEntity> implements CrudDAO<DTO> {

	@Inject
	private DAOUtils<ENTITY> dao;

	public abstract BaseMapper<DTO, ENTITY> getMapper();

	@Override
	public List<DTO> findAll(int startPosition, int maxResult) {
		return this.dao.findAll(startPosition, maxResult)
				       .stream().map(E -> getMapper().mapToDto(E))
				       .collect(Collectors.toList());
	}

	@Override
	public DTO save(DTO dto) {
		ENTITY entity = getMapper().mapToEntity(dto);
		return this.getMapper().mapToDto(this.dao.save(entity));
	}

	@Override
	public DTO findById(Long id) {
		ENTITY entity = this.dao.findById(id);
		return this.getMapper().mapToDto(entity);
	}

	@Override
	public void delete(DTO dto) {
		this.dao.delete(getMapper().mapToEntity(dto));
	}

	@Override
	public void deleteById(Long id) {
		this.dao.deleteById(id);
	}

	@Override
	public Optional<DTO> findOptionalById(Long id) {
		 return Optional.ofNullable(this.findById(id));
	}

}
