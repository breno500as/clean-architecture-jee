package com.cleancode.contract.manager;

import com.cleancode.contract.dto.LibraryDTO;

public interface LibraryManager {

	public LibraryDTO persist(LibraryDTO bookDTO);
}
