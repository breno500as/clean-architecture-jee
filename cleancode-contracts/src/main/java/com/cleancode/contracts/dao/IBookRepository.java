package com.cleancode.contracts.dao;

import javax.ejb.Local;

import com.cleancode.contracts.dto.BookDTO;

@Local
public interface IBookRepository {
	
	
	public BookDTO persist(BookDTO bookDTO);

}
