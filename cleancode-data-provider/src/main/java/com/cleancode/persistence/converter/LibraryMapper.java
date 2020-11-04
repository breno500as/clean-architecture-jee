package com.cleancode.persistence.converter;

import com.cleancode.core.model.dto.LibraryDTO;
import com.cleancode.persistence.entity.LibraryEntity;

public class LibraryMapper extends BaseMapper<LibraryDTO, LibraryEntity> {

	@Override
	public LibraryDTO mapToDto(LibraryEntity entity) {
		return new LibraryDTO(entity.getId(),entity.getNome());
	}

	@Override
	public LibraryEntity mapToEntity(LibraryDTO dto) {
		return new LibraryEntity(dto.getNome());
	}
	
}