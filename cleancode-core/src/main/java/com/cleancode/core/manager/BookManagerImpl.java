package com.cleancode.core.manager;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.cleancode.core.contract.dto.BookDTO;
import com.cleancode.core.contract.dto.LibraryDTO;
import com.cleancode.core.contract.manager.BookManager;
import com.cleancode.core.contract.manager.LibraryManager;
import com.cleancode.core.contract.manager.TypeLibraryManager;
import com.cleancode.core.contract.qualifier.TypeLibraryAnnotation;

@Stateless
public class BookManagerImpl extends CrudManagerImpl<BookDTO> implements BookManager {
	
	
	@Inject
	private LibraryManager libraryManager;
	
	@Inject
	@Any
	private Instance<TypeLibraryManager> typeLibraryManager;

	@Override
	public BookDTO save(BookDTO dto) {
		
		final BookDTO b = super.save(dto);

		//test..
		final LibraryDTO l = this.libraryManager.save(new LibraryDTO("trump","small"));
		
		final TypeLibraryManager typeLibrary = this.typeLibraryManager.select(TypeLibraryAnnotation.getInstanceByTipo(l.getTipo())).get();
		typeLibrary.specificBehavior();
		 
		
		return b;
	}
	
	

}
