package com.cleancode.contract.exception;

public class MensagemErro extends Mensagem {
 
	private static final long serialVersionUID = 5655701331709842801L;

	public MensagemErro(String conteudo) {
		super("error", conteudo);
	}

}
