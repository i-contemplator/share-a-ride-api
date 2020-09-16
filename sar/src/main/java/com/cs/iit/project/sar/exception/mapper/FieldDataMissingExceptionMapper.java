package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cs.iit.project.sar.exception.ExceptionResponseMaker;
import com.cs.iit.project.sar.exception.FieldDataMissingException;

@Provider
public class FieldDataMissingExceptionMapper implements ExceptionMapper<FieldDataMissingException>{

	private UriInfo uriInfo;
	
	public FieldDataMissingExceptionMapper(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	
	@Override
	public Response toResponse(FieldDataMissingException exception) {
		return ExceptionResponseMaker.create(exception.getMessage(), 
												Status.BAD_REQUEST, 
													"/" + uriInfo.getPath());
	}

}
