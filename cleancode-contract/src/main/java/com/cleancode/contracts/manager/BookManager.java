package com.cleancode.contracts.manager;

import com.cleancode.contracts.dto.BookDTO;


public interface BookManager {

	public BookDTO persist(BookDTO bookDTO);

}
