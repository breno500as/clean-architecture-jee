package com.cleancode.core.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cleancode.contract.dao.BookDAO;
import com.cleancode.contract.dao.LibraryDAO;
import com.cleancode.contract.dto.BookDTO;
import com.cleancode.contract.dto.LibraryDTO;
import com.cleancode.contract.manager.BookManager;
import com.cleancode.contract.report.CreateReportBook;

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
