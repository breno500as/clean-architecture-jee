package com.cleancode.core.manager;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cleancode.contracts.dao.LibraryDAO;
import com.cleancode.contracts.dto.LibraryDTO;
import com.cleancode.contracts.manager.LibraryManager;

@Stateless
public class LibraryManagerImpl implements LibraryManager {
	
	@Inject
	private LibraryDAO repository;

	@Override
	public LibraryDTO persist(LibraryDTO libraryDTO) {
		return  this.repository.persist(libraryDTO);

	}

}
