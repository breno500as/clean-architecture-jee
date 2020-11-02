package com.cleancode.contract.dao;

import com.cleancode.contract.dto.BookDTO;


public interface BookDAO {
	
	public BookDTO persist(BookDTO bookDTO);

}
