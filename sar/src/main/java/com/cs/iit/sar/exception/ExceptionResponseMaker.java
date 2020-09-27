package com.cs.iit.sar.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cs.iit.sar.models.ErrorMessage;

public class ExceptionResponseMaker {

	public static Response create(String detail, Status status, String instance){
		ErrorMessage errMessage = new ErrorMessage("http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation",
													"Your request data didn't pass validation",
													detail,
													status.getStatusCode(),
													instance);
		return Response.status(status)
				.entity(errMessage)
				.build();
	}
}
