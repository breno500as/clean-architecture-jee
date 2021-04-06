package com.cleancode.core.contract.model.dto;

public class LibraryDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6359285508841832844L;

	private Long id;

	private String nome;

	private String tipo;

	public LibraryDTO() {

	}

	public LibraryDTO(Long id, String nome, String tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public LibraryDTO(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
