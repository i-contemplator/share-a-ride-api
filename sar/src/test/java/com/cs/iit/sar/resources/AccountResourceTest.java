package com.cs.iit.sar.resources;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.BeforeAll;

class AccountResourceTest extends JerseyTest{

	AccountResource resource;
	@Override
	protected Application configure() {
		return new ResourceConfig(AccountResource.class);
	}
	
	@BeforeAll
	void init() {
		resource = new AccountResource();
	}
	
//	@Test
//	public void testCreateAccount_ValidRequest_ResponseCreatedAidReturn() {
//
//		AccountRequest account = new AccountRequest("John", "Smith", "312-456-7890", "http://example.com/images/john-smith.jpeg", false);
//		Response response = resource.createAccount(account, "/accounts");
//		assertEquals(201, response.getStatus());
//	}
//	
}
