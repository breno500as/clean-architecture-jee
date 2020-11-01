package com.cleancode.contracts.dao;

import com.cleancode.contracts.dto.BookDTO;


public interface BookDAO {
	
	public BookDTO persist(BookDTO bookDTO);

}
