package com.cleancode.contracts.manager;

import com.cleancode.contracts.dto.LibraryDTO;

public interface LibraryManager {

	public LibraryDTO persist(LibraryDTO bookDTO);
}
