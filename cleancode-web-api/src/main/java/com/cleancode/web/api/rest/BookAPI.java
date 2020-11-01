package com.cleancode.web.api.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cleancode.contracts.core.IBookManager;
import com.cleancode.contracts.dto.BookDTO;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookAPI {
	
	
	@Inject
	private IBookManager ibookManager;
	
	@GET
	public Response get() {
		return Response.ok("Teste").build();
	}
	
	@POST
	public Response cria(BookDTO bookDTO) {
		return Response.status(Status.CREATED).entity(this.ibookManager.persist(bookDTO)).build();
	}

}
