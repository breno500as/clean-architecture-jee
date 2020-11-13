package com.cleancode.entrypoint.api.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cleancode.core.contract.manager.LibraryManager;
import com.cleancode.core.contract.model.dto.LibraryDTO;

@Path("/libraries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class LibraryAPI {

	@Inject
	private LibraryManager libraryManager;

	@POST
	public Response save(@Valid LibraryDTO library) {
		return Response.status(Status.CREATED).entity(this.libraryManager.save(library)).build();
	}

}
