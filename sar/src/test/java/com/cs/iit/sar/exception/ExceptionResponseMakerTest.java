package com.cs.iit.sar.exception;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Test;

class ExceptionResponseMakerTest extends ExceptionResponseMaker{

	@Test
	void testCreate_CreateErrorResponse_Success() {
		Response response = ExceptionResponseMaker.create("Invalid value for pickup_confirmed", Status.BAD_REQUEST, "/rides");
		assertEquals(400, response.getStatus());
	}
}
