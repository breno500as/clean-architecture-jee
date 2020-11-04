package com.cleancode.core.model.dto;

public class LibraryDTO extends BaseDTO {

	private Long id;

	private String nome;

	public LibraryDTO() {

	}

	public LibraryDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public LibraryDTO(String nome) {
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
