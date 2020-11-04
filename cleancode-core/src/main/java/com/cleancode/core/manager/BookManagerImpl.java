package com.cleancode.core.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cleancode.core.contract.manager.BookManager;
import com.cleancode.core.contract.manager.LibraryManager;
import com.cleancode.core.model.dto.BookDTO;
import com.cleancode.core.model.dto.LibraryDTO;

@Stateless
public class BookManagerImpl extends CrudManagerImpl<BookDTO> implements BookManager {
	
	
	@Inject
	private LibraryManager libraryManager;

	@Override
	public BookDTO save(BookDTO dto) {

		final BookDTO b = super.save(dto);

		final LibraryDTO l = this.libraryManager.save(new LibraryDTO("trump"));
		
		System.out.println(l);
		
		return b;
	}

}
