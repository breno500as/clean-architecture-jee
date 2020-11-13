package com.cleancode.persistence.dao;

import javax.enterprise.context.RequestScoped;

import com.cleancode.core.contract.dao.BookDAO;
import com.cleancode.core.contract.model.dto.BookDTO;
import com.cleancode.persistence.converter.BookMapper;
import com.cleancode.persistence.model.entity.BookEntity;

@RequestScoped
public class BookDAOImpl extends CrudDAOImpl<BookDTO, BookEntity> implements BookDAO {

	@Override
	public BookMapper getMapper() {
		return new BookMapper();
	}

}
