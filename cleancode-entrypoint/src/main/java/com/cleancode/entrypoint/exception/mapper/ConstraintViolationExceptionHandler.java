package com.cleancode.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cleancode.core.contract.exception.MensagemErro;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException constraintViolationException) {

		List<MensagemErro> mensagens = new ArrayList<>();

		Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();

		constraintViolations.stream()
				.map(constraintViolation -> mensagens.add(new MensagemErro(constraintViolation.getMessage())))
				.collect(Collectors.toList());

		return Response.status(Status.BAD_REQUEST).entity(mensagens).type(MediaType.APPLICATION_JSON).build();

	}

}

