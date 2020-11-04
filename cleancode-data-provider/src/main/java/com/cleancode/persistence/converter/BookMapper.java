package com.cleancode.persistence.converter;

import com.cleancode.core.model.dto.BookDTO;
import com.cleancode.persistence.entity.BookEntity;

public class BookMapper extends BaseMapper<BookDTO, BookEntity> {

	@Override
	public BookDTO mapToDto(BookEntity entity) {
		return new BookDTO(entity.getId(), entity.getNome());
	}

	@Override
	public BookEntity mapToEntity(BookDTO dto) {
		return new BookEntity(dto.getNome());
	}

}
