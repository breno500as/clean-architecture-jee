package com.cleancode.persistence.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cleancode.contracts.dao.IBookRepository;
import com.cleancode.contracts.dto.BookDTO;
import com.cleancode.persistence.entity.BookEntity;

@Stateless
public class BookRepositoryImpl implements IBookRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public BookDTO persist(BookDTO bookDTO) {
	    final BookEntity bEntity = new BookEntity(bookDTO.getNome());
		this.em.persist(bEntity);
		return new BookDTO(bEntity.getNome());
	}

}
