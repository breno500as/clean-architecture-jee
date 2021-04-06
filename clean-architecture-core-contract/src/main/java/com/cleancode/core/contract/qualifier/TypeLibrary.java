package com.cleancode.core.contract.qualifier;

import java.util.Arrays;

public enum TypeLibrary {

	SMALL("small"), BIG("big");

	private String tipo;

	TypeLibrary(final String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static TypeLibrary recuperaPeloTipo(final String tipo) {
		return tipo != null
                ? Arrays.stream(TypeLibrary.values()).filter(tipoLibrary -> tipoLibrary.tipo.equals(tipo)).findFirst().orElse(null)
				: null;
	}

}
