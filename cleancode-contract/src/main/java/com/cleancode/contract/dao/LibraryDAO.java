package com.cleancode.contract.dao;

import com.cleancode.contract.dto.LibraryDTO;

public interface LibraryDAO {

	public LibraryDTO persist(LibraryDTO bookDTO);
}
