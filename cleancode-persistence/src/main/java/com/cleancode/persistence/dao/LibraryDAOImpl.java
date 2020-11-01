package com.cleancode.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cleancode.contracts.dao.LibraryDAO;
import com.cleancode.contracts.dto.LibraryDTO;
import com.cleancode.persistence.entity.LibraryEntity;

@Stateless
public class LibraryDAOImpl implements LibraryDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public LibraryDTO persist(LibraryDTO lDTO) {
	    final LibraryEntity lEntity = new LibraryEntity(lDTO.getNome());
		this.em.persist(lEntity);
		return new LibraryDTO(lEntity.getNome());
	}

}
