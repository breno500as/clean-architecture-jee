package com.cleancode.persistence.converter;

import com.cleancode.core.contract.model.dto.BookDTO;
import com.cleancode.persistence.model.entity.BookEntity;

public class BookMapper extends BaseMapper<BookDTO, BookEntity> {

    @Override
    public BookDTO mapToDto(BookEntity entity) {
        if (entity != null) {
            return new BookDTO(entity.getId(), entity.getNome());
        }
        return new BookDTO();
    }

    @Override
    public BookEntity mapToEntity(BookDTO dto) {
        return new BookEntity(dto.getNome());
    }

}
