package com.cleancode.contracts.core;

import javax.ejb.Local;

import com.cleancode.contracts.dto.BookDTO;



public interface IBookManager {

	public BookDTO persist(BookDTO bookDTO);

}
