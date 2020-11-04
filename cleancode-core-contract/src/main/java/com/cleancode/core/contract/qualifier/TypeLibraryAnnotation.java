package com.cleancode.core.contract.qualifier;

import java.lang.annotation.Annotation;

@SuppressWarnings("all")
public class TypeLibraryAnnotation implements TypeLibraryQualifier {

	private TypeLibrary value;

	private TypeLibraryAnnotation(TypeLibrary value) {
		this.value = value;
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return TypeLibraryQualifier.class;
	}

	@Override
	public TypeLibrary value() {
		return value;
	}

	public static TypeLibraryAnnotation getInstanceByTipo(final String tipo) {
		final TypeLibrary tipoLicenca = TypeLibrary.recuperaPeloTipo(tipo);
		return tipoLicenca != null ? new TypeLibraryAnnotation(tipoLicenca) : null;
	}
}
