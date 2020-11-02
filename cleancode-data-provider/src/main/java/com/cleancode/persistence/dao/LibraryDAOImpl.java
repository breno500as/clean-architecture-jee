package com.cleancode.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cleancode.contract.dao.LibraryDAO;
import com.cleancode.contract.dto.LibraryDTO;
import com.cleancode.persistence.entity.LibraryEntity;

@RequestScoped
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
