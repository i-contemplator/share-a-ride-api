package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cs.iit.project.sar.exception.FieldDataMissingException;

public class FieldDataMissingExceptionMapper implements ExceptionMapper<FieldDataMissingException>{

	@Override
	public Response toResponse(FieldDataMissingException exception) {
		return Response.status(Status.BAD_REQUEST).build();
	}

}
