package com.cleancode.core.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cleancode.contracts.dao.BookDAO;
import com.cleancode.contracts.dao.LibraryDAO;
import com.cleancode.contracts.dto.BookDTO;
import com.cleancode.contracts.dto.LibraryDTO;
import com.cleancode.contracts.manager.BookManager;
import com.cleancode.contracts.report.CreateReportBook;

@Stateless
public class BookManagerImpl implements BookManager {

	@Inject
	private BookDAO repository;

	@Inject
	private LibraryDAO libraryRepository;

	@Inject
	private CreateReportBook createReportBook;

	@Override
	public BookDTO persist(BookDTO bookDTO) {
		BookDTO b = this.repository.persist(bookDTO);
		this.createReportBook.create();
		this.libraryRepository.persist(new LibraryDTO("teste"));
		this.createReportBook.create();
		return b;

	}

}
