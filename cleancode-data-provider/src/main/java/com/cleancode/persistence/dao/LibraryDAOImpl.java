package com.cleancode.persistence.dao;

import javax.enterprise.context.RequestScoped;

import com.cleancode.core.contract.dao.LibraryDAO;
import com.cleancode.core.model.dto.LibraryDTO;
import com.cleancode.persistence.converter.BaseMapper;
import com.cleancode.persistence.converter.LibraryMapper;
import com.cleancode.persistence.entity.LibraryEntity;

@RequestScoped
public class LibraryDAOImpl extends CrudDAOImpl<LibraryDTO, LibraryEntity> implements LibraryDAO {

	@Override
	public BaseMapper<LibraryDTO, LibraryEntity> getMapper() {
		return new LibraryMapper();
	}

}
