package com.cleancode.persistence.converter;

import com.cleancode.core.model.dto.BaseDTO;
import com.cleancode.persistence.entity.BaseEntity;

public abstract class BaseMapper<DTO extends BaseDTO, ENTITY extends BaseEntity> {
	
	public abstract DTO mapToDto(ENTITY entity);
	
	public abstract ENTITY mapToEntity(DTO dto);

}
