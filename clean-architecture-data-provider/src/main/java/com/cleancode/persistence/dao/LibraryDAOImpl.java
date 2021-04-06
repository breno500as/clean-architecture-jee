package com.cleancode.persistence.dao;

import javax.ejb.Stateless;

import com.cleancode.core.contract.dao.LibraryDAO;
import com.cleancode.core.contract.model.dto.LibraryDTO;
import com.cleancode.persistence.converter.BaseMapper;
import com.cleancode.persistence.converter.LibraryMapper;
import com.cleancode.persistence.model.entity.LibraryEntity;

@Stateless
public class LibraryDAOImpl extends CrudDAOImpl<LibraryDTO, LibraryEntity> implements LibraryDAO {

	@Override
	public BaseMapper<LibraryDTO, LibraryEntity> getMapper() {
		return new LibraryMapper();
	}

}
