package com.cleancode.core.contract.exception;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -7033808656574650320L;
	private String type;
	private String msg;

	public Mensagem() {
	}

	public Mensagem(String tipo, String msg) {
		this.type = tipo;
		this.msg = msg;
	}

	/**
	 * Retorna o tipo da mensagem.
	 * 
	 * @return tipo da mensagem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Retorna o conteúdo da mensagem.
	 * 
	 * @return conteúdo da mensagem
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg - Mensagem
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
