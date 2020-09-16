package com.cs.iit.project.sar.exception.mapper;

import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cs.iit.project.sar.exception.ExceptionResponseMaker;

@Provider
public class JsonParsingExceptionMapper implements ExceptionMapper<JsonParsingException>{

	private UriInfo uriInfo;
	
	public JsonParsingExceptionMapper(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	@Override
	public Response toResponse(JsonParsingException exception) {
		return ExceptionResponseMaker.create(exception.getMessage(),
												Status.BAD_REQUEST,
													"/" + uriInfo.getPath());
	}

}
