package com.cleancode.contract.manager;

import com.cleancode.contract.dto.BookDTO;


public interface BookManager {

	public BookDTO persist(BookDTO bookDTO);

}
