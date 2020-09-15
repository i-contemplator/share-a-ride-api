package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cs.iit.project.sar.exception.FieldDataInvalidException;

public class FieldDataInvalidExceptionMapper implements ExceptionMapper<FieldDataInvalidException> {

	@Override
	public Response toResponse(FieldDataInvalidException exception) {
		return Response.status(Status.BAD_REQUEST).build();
	}

}
