package com.cleancode.core.model.dto;

import javax.validation.constraints.NotNull;

public class BookDTO extends BaseDTO {

	private Long id;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2050808459071457482L;

	@NotNull(message = "Falhou")
	private String nome;

	public BookDTO() {

	}

	public BookDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public BookDTO(String nome) {

		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
