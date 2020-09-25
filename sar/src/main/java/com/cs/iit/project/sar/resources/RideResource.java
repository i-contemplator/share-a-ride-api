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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.cs.iit.project.sar.dto.request.JoinRequestRequest;
import com.cs.iit.project.sar.dto.request.MessageRequest;
import com.cs.iit.project.sar.dto.request.RideRequest;
import com.cs.iit.project.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.project.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.project.sar.dto.response.JoinRequestJidResponse;
import com.cs.iit.project.sar.dto.response.MessageResponse;
import com.cs.iit.project.sar.dto.response.RideDetailResponse;
import com.cs.iit.project.sar.dto.response.RideResponse;
import com.cs.iit.project.sar.dto.response.ViewMessagesResponse;
import com.cs.iit.project.sar.services.RideService;
import com.cs.iit.project.sar.utilities.Location;

@Path("rides")
public class RideResource {
	
	RideService repo = new RideService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRide(RideRequest ride, @Context UriInfo uriInfo) {
		CreateRideRidResponse ridRequest = repo.createRide(ride);
		String ridStr = String.valueOf(ridRequest.getRid());
		return Response.created(Location.getUri(uriInfo, ridStr))
				.status(Status.CREATED)
				.entity(ridRequest)
				.build();
	}
	
	@PUT
	@Path("{rid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRide(@PathParam("rid") int rid, RideRequest ride) {
		repo.updateRide(rid, ride);
	}
	
	@DELETE
	@Path("{rid}")
	public void deleteRide(@PathParam("rid") int rid) {
		repo.deleteRide(rid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RideResponse> getAllRides(@QueryParam("from") String from, 
									@QueryParam("to") String to,
									@QueryParam("date") String date) {
		if(from == null && to == null && date == null || from.isBlank() || to.isBlank() || date.isBlank()) {
			return repo.getAllRides();
		} else {
			System.out.println(from + " " + to + " " + date);
			return repo.searchRides(from, to, date);
		}
	}
	
	@GET
	@Path("{rid}")
	@Produces(MediaType.APPLICATION_JSON)
	public RideDetailResponse getRide(@PathParam("rid") int rid) {
		System.out.println("in getRide resource");
		return repo.getRide(rid);
	}
	
	@POST
	@Path("{rid}/join_requests")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response requestJoinRide(@PathParam("rid") int rid, JoinRequestRequest joinRequest, @Context UriInfo uriInfo) {
		JoinRequestJidResponse jidResponse = repo.requestToJoinRide(rid, joinRequest);
		String jidStr = String.valueOf(jidResponse.getJid());

		return Response.created(Location.getUri(uriInfo, jidStr))
				.status(Status.CREATED)
				.entity(jidResponse)
				.build();	
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{rid}/join_requests/{jid}")
	public void respondToRideRequest(@PathParam("rid") int rid, @PathParam("jid") int jid, JoinRequestRequest patchJoinRequest) {
		if(patchJoinRequest.getRideConfirmed() != null) {
			repo.respondToRideRequest(rid, jid, patchJoinRequest);
		}
		if(patchJoinRequest.getPickupConfirmed() != null) {
			repo.confirmPassengerPickup(rid, jid, patchJoinRequest);
		} 
	} 
	
	@POST
	@Path("{rid}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(@PathParam("rid") int rid, MessageRequest message, @Context UriInfo uriInfo) {
		AddMessageMidResponse midResponse = repo.addMessage(rid, message);
		String midStr = String.valueOf(midResponse.getMid());

		return Response.created(Location.getUri(uriInfo, midStr))
				.status(Status.CREATED)
				.entity(midResponse)
				.build();	
	}
	
	@GET
	@Path("{rid}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageResponse> getAllMessages(@PathParam("rid") int rid) {
		return repo.getAllMessages(rid);
	}
	
}
