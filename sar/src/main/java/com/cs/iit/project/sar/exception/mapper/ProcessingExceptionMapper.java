package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProcessingExceptionMapper implements ExceptionMapper<ProcessingException>{

	@Override
	public Response toResponse(ProcessingException exception) {
		System.out.println("Called when different data type passed");
		return Response.status(Status.BAD_REQUEST).build();
	}

}
