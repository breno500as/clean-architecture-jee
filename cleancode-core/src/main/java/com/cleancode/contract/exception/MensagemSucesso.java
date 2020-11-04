package com.cleancode.contract.exception;

public class MensagemSucesso extends Mensagem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2185132695723066651L;

	public MensagemSucesso(String conteudo) {
		super("success", conteudo);
	}

}
