package com.cs.iit.project.sar.resources;

import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.repositories.AccountRepository;

@Path("accounts")
public class AccountResource {

	AccountRepository repo = new AccountRepository();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAccount(User user) {
		int aid = repo.createAccount(user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("aid", aid);
		
		return Response.status(Status.CREATED)
				.entity(jsonObject.toString())
				.build();
	}
	
	
	@Path("{aid}/status")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void activeAccount(@PathParam("aid") int aid, User user) {
		user.setAid(aid);
		repo.activateAccount(aid, user);
	}
	
	@Path("{aid}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAccount(@PathParam("aid") int aid, User user) {
		user.setAid(aid);
		repo.updateAccount(aid, user);
	}
	
	@Path("{aid}")
	@DELETE
	public void deleteAccount(@PathParam("aid") int aid) {
		repo.deleteAccount(aid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> viewAllAccounts() {
		return repo.viewAllAccounts();
	}
	
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> searchAccounts(@QueryParam("key") String key) {
		if(key == null) {
			return repo.viewAllAccounts();
		}
		return repo.searchAccounts(key);
	}
	
	@Path("{aid}/ratings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response rateAccount(@PathParam("aid") int aid, Rating rating) {
		Integer sid = repo.rateAccount(aid, rating);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sid", sid);
		return Response.status(Status.CREATED)
				.entity(jsonObject.toString())
				.build();
	}
	
	@Path("{aid}/driver")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> viewDriverRatings(@PathParam("aid") int aid) {
		return repo.viewDriverRatings(aid);
	}
	
	@Path("{aid}/rider")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rating> viewRiderRatings(@PathParam("aid") int aid) {
		return repo.viewRiderRatings(aid);
	}
}
