package com.cleancode.core.manager;

import javax.ejb.Stateless;

import com.cleancode.core.contract.manager.LibraryManager;
import com.cleancode.core.contract.model.dto.LibraryDTO;

@Stateless
public class LibraryManagerImpl extends CrudManagerImpl<LibraryDTO> implements LibraryManager {
	
	 

}
