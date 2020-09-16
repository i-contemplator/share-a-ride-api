package com.cs.iit.project.sar.exception.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cs.iit.project.sar.exception.DataNotFoundException;
import com.cs.iit.project.sar.repositories.response.ExceptionResponseMaker;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	private UriInfo uriInfo;
	
	public DataNotFoundExceptionMapper(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		return ExceptionResponseMaker.create(exception.getMessage(), 
												Status.NOT_FOUND, 
													"/" + uriInfo.getPath());
	}

}
