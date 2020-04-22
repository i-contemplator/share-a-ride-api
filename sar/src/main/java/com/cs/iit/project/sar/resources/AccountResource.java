package com.cs.iit.project.sar.resources;

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
import javax.ws.rs.core.MediaType;

import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.repositories.AccountRepository;

@Path("accounts")
public class AccountResource {

	AccountRepository repo = new AccountRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAccount(User user) {
		int num;
		num = repo.createAccount(user);
		return "{\n\t\"aid\": " + num + "\n}";
	}
	
	
	@Path("{aid}/status")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void activeAccount(@PathParam("aid") int aid, User user) {
		repo.activateAccount(aid, user);
	}
	
	@Path("{aid}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAccount(@PathParam("aid") int aid, User user) {
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> searchAccounts(@QueryParam("key") String key) {
		return repo.searchAccounts(key);
	}
	
	@Path("{aid}/ratings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String rateAccount(@PathParam("aid") int aid, Rating rating) {
		int sid;
		sid = repo.rateAccount(aid, rating);
		return "{\n\t\"sid\": " + sid + "\n}";
	}
}
