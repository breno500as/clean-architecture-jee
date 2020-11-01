package com.cleancode.contracts.dto;

public class BookDTO {

	private Long id;

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
