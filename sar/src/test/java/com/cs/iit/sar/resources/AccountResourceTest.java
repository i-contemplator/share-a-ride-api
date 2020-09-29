package com.cs.iit.sar.resources;

import static org.junit.jupiter.api.Assertions.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import com.cs.iit.sar.dto.request.AccountRequest;

class AccountResourceTest extends JerseyTest{

	@Override
	protected Application configure() {
		// TODO Auto-generated method stub
		return new ResourceConfig(AccountResource.class);
	}
	
	@Test
	public void testCreateAccount_ValidRequest_ResponseCreatedAidReturn() {

		AccountRequest account = new AccountRequest("John", "Smith", "312-456-7890", "http://example.com/images/john-smith.jpeg", false);
		Response response = target("/sar/accounts").request().post(Entity.entity(account, MediaType.APPLICATION_JSON));
		assertEquals(201, response.getStatus());
	}
	
}
