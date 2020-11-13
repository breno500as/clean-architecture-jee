package com.cleancode.report;

import javax.enterprise.context.ApplicationScoped;

import com.cleancode.core.contract.dto.BookDTO;
import com.cleancode.core.contract.report.CreateReportBook;

@ApplicationScoped
public class CreateReportBookImpl implements CreateReportBook {

	@Override
	public byte[] create(BookDTO bookDTO) {
		System.out.println("criando relatorio..");
		return new byte[] {};
	}

}
