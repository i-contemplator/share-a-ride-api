package com.cs.iit.sar.exception.mapper;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cs.iit.sar.exception.ExceptionResponseMaker;

@Provider
public class ProcessingExceptionMapper implements ExceptionMapper<ProcessingException>{

	private UriInfo uriInfo;
	
	public ProcessingExceptionMapper(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	
	@Override
	public Response toResponse(ProcessingException exception) {
		return ExceptionResponseMaker.create(exception.getMessage(),
												Status.BAD_REQUEST,
													"/" + uriInfo.getPath());
	}

}
