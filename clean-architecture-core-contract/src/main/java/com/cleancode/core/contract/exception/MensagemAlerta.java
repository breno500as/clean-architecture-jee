package com.cleancode.core.contract.exception;

public class MensagemAlerta extends Mensagem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5949862212376076483L;

	 
    public MensagemAlerta(String conteudo) {
        super("warning", conteudo);
    }


}
