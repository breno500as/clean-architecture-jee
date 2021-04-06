package com.cleancode.core.manager;

import javax.ejb.Stateless;

import com.cleancode.core.contract.manager.TypeLibraryManager;
import com.cleancode.core.contract.qualifier.TypeLibrary;
import com.cleancode.core.contract.qualifier.TypeLibraryQualifier;

@Stateless
@TypeLibraryQualifier(TypeLibrary.BIG)
public class TypeLibraryBigManagerImpl implements TypeLibraryManager {

	@Override
	public void specificBehavior() {
		System.out.println("comportamento específico em um manager genérico big..");
	}

}
