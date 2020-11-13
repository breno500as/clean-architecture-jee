package com.cleancode.persistence.model.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518369040045115541L;

	public abstract Long getId();

}
