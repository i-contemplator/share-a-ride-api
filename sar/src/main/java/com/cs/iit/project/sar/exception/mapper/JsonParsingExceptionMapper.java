package com.cs.iit.project.sar.exception.mapper;

import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonParsingExceptionMapper implements ExceptionMapper<JsonParsingException>{

	@Override
	public Response toResponse(JsonParsingException exception) {
		System.out.println("Called when invalid jsonobject is passed. cannot parse.");
		return Response.status(Status.BAD_REQUEST).build();
	}

}
