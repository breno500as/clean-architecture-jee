package com.cleancode.contracts.dao;

import com.cleancode.contracts.dto.LibraryDTO;

public interface LibraryDAO {

	public LibraryDTO persist(LibraryDTO bookDTO);
}
