package com.cs.iit.project.sar.exception.mapper;

import javax.json.bind.JsonbException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonbExceptionMapper implements ExceptionMapper<JsonbException>{

	@Override
	public Response toResponse(JsonbException exception) {
		System.out.println("In JsonbException");
		return Response.status(Status.BAD_REQUEST)
				.build();
	}

}
