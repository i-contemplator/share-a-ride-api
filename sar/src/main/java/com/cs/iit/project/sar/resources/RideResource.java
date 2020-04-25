package com.cs.iit.project.sar.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.cs.iit.project.sar.models.JoinRequest;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.repositories.RideRepository;

@Path("rides")
public class RideResource {
	
	RideRepository repo = new RideRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRide(Ride ride) {
		int rid;
		rid = repo.createRide(ride);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rid", rid);
		return Response.status(Status.CREATED)
				.entity(jsonObject.toString())
				.build();
	}
	
	@PUT
	@Path("{rid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRide(@PathParam("rid") int rid, Ride ride) {
		repo.updateRide(rid, ride);
	}
	
	@DELETE
	@Path("{rid}")
	public void deleteRide(@PathParam("rid") int rid) {
		repo.deleteRide(rid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ride> getAllRides() {
		return repo.getAllRides();
	}
	
	@GET
	@Path("{rid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ride getRide(@PathParam("rid") int rid) {
		return repo.getRide(rid);
	}
	
	@POST
	@Path("{rid}/join_requests")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestJoinRide(@PathParam("rid") int rid, JoinRequest joinRequest) {
		System.out.println("Entered request Join Request...");
		int jid;
		jid = repo.requesetToJoinRide(rid, joinRequest);
		System.out.println("AFter repo...");
		return "{\n\t\"jid\": " + jid + "\n}";	
	}
	
//	@PATCH
//	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
//	@Path("{rid}/join_requests/{jid}")
//	public void respondToRideRequest(@PathParam("rid") int rid, @PathParam("jid") int jid, PatchData patched) {
//		repo.respondToRideRequest(rid, jid, patched);
//	}
//	
//	@PATCH
//	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
//	@Path("{rid}/join_requests/{jid}")
//	public void confirmPassengerPickup(@PathParam("rid") int rid, @PathParam("jid") int jid, PatchData patched) {
//		repo.confirmPassengerPickup(rid, jid, patched);
//	}
	
	@POST
	@Path("{rid}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addMessage(@PathParam("rid") int rid, Message message) {
		int mid;
		mid = repo.addMessage(rid, message);
		return "{\n\t\"mid\": " + mid + "\n}";	
	}
	
	@GET
	@Path("{rid}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@PathParam("rid") int rid) {
		return repo.getAllMessages(rid);
	}
	
}
