package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cs.iit.project.sar.exception.DataNotFoundException;

public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		return Response.status(Status.BAD_REQUEST).build();
	}

}
