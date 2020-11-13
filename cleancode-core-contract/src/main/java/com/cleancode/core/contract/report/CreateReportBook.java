package com.cleancode.core.contract.report;

import com.cleancode.core.contract.model.dto.BookDTO;

public interface CreateReportBook {

	 public byte[] create(BookDTO bookDTO);
}
