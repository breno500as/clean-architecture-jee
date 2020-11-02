package com.cleancode.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cleancode.contract.dao.BookDAO;
import com.cleancode.contract.dto.BookDTO;
import com.cleancode.persistence.entity.BookEntity;

@RequestScoped
public class BookDAOImpl implements BookDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public BookDTO persist(BookDTO bookDTO) {
	    final BookEntity bEntity = new BookEntity(bookDTO.getNome());
		this.em.persist(bEntity);
		return new BookDTO(bEntity.getNome());
	}

}
