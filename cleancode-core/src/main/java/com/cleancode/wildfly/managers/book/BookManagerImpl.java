package com.cleancode.wildfly.managers.book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import com.cleancode.contracts.core.IBookManager;
import com.cleancode.contracts.dao.IBookRepository;
import com.cleancode.contracts.dto.BookDTO;

//@Stateless
@ApplicationScoped
public class BookManagerImpl implements IBookManager {

	@EJB
	private IBookRepository repository;

	@Override
	public BookDTO persist(BookDTO bookDTO) {
		return  this.repository.persist(bookDTO);

	}

}
