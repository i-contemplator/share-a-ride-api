package com.cs.iit.sar.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cs.iit.sar.boundaryinterfaces.AccountBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.RatingBoundaryInterface;
import com.cs.iit.sar.dto.request.AccountRequest;
import com.cs.iit.sar.dto.request.RateAccountRequest;
import com.cs.iit.sar.dto.response.AccountResponse;
import com.cs.iit.sar.dto.response.CreateAccountAidResponse;
import com.cs.iit.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.sar.dto.response.ViewRiderRatingsResponse;
import com.cs.iit.sar.services.AccountService;
import com.cs.iit.sar.utilities.Location;

import javax.ws.rs.core.UriInfo;

@Path("accounts")
public class AccountResource {

	AccountBoundaryInterface accountService = new AccountService();
	RatingBoundaryInterface ratingService = new AccountService();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAccount(AccountRequest userRequest, @Context UriInfo uriInfo) {
		CreateAccountAidResponse aidResponse = accountService.createAccount(userRequest);
		String aidStr = String.valueOf(aidResponse.getAid());
		
		return Response.created(Location.getUri(uriInfo, aidStr))
				.status(Status.CREATED)
				.entity(aidResponse)
				.build();
	}
	
	@Path("{aid}/status")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void activeAccount(@PathParam("aid") int aid, AccountRequest user) {
		user.setAid(aid);
		accountService.activateAccount(aid, user);
	}
	
	@Path("{aid}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAccount(@PathParam("aid") Integer aid, AccountRequest user) {
		user.setAid(aid);
		accountService.updateAccount(aid, user);
	}
	
	@Path("{aid}")
	@DELETE
	public void deleteAccount(@PathParam("aid") int aid) {
		accountService.deleteAccount(aid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountResponse> viewAllAccounts() {
		return accountService.viewAllAccounts();
	}
	
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountResponse> searchAccounts(@QueryParam("key") String key) {
		if(key == null || key.isBlank()) {
			return accountService.viewAllAccounts();
		}
		return accountService.searchAccounts(key);
	}
	
	@Path("{aid}/ratings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response rateAccount(@PathParam("aid") int aid, RateAccountRequest rating, @Context UriInfo uriInfo) {
		
		RateAccountSidResponse sidResponse = ratingService.rateAccount(aid, rating);
		String sidStr = String.valueOf(sidResponse);
		
		return Response.created(Location.getUri(uriInfo, sidStr))
				.status(Status.CREATED)
				.entity(sidResponse)
				.build();
	}
	
	@Path("{aid}/driver")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ViewDriverRatingsResponse viewDriverRatings(@PathParam("aid") int aid) {
		return ratingService.viewDriverRatings(aid);
	}
	
	@Path("{aid}/rider")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ViewRiderRatingsResponse viewRiderRatings(@PathParam("aid") int aid) {
		return ratingService.viewRiderRatings(aid);
	}
}
