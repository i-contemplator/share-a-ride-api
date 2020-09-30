package com.cs.iit.sar.resources;

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

import com.cs.iit.sar.boundaryinterfaces.JoinRequestBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.MessageBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.RideBoundaryInterface;
import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.dto.request.MessageRequest;
import com.cs.iit.sar.dto.request.RideRequest;
import com.cs.iit.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.sar.dto.response.JoinRequestJidResponse;
import com.cs.iit.sar.dto.response.MessageResponse;
import com.cs.iit.sar.dto.response.RideDetailResponse;
import com.cs.iit.sar.dto.response.RideResponse;
import com.cs.iit.sar.services.RideService;
import com.cs.iit.sar.utilities.Location;

import javax.ws.rs.core.UriInfo;

@Path("rides")
public class RideResource {
	
	RideBoundaryInterface rideService = new RideService();
	JoinRequestBoundaryInterface joinRequestService = new RideService();
	MessageBoundaryInterface messageService = new RideService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRide(RideRequest ride, @Context UriInfo uriInfo) {
		CreateRideRidResponse ridResponse = rideService.createRide(ride);
		String ridStr = String.valueOf(ridResponse.getRid());
		return Response.created(Location.getUri(uriInfo, ridStr))
				.status(Status.CREATED)
				.entity(ridResponse)
				.build();
	}
	
	@PUT
	@Path("{rid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRide(@PathParam("rid") int rid, RideRequest ride) {
		rideService.updateRide(rid, ride);
	}
	
	@DELETE
	@Path("{rid}")
	public void deleteRide(@PathParam("rid") int rid) {
		rideService.deleteRide(rid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RideResponse> getAllRides(@QueryParam("from") String from, 
									@QueryParam("to") String to,
									@QueryParam("date") String date) {
		if(from == null && to == null && date == null || from.isBlank() || to.isBlank() || date.isBlank()) {
			return rideService.getAllRides();
		} else {
			System.out.println(from + " " + to + " " + date);
			return rideService.searchRides(from, to, date);
		}
	}
	
	@GET
	@Path("{rid}")
	@Produces(MediaType.APPLICATION_JSON)
	public RideDetailResponse getRide(@PathParam("rid") int rid) {
		return rideService.getRide(rid);
	}
	
	@POST
	@Path("{rid}/join_requests")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response requestJoinRide(@PathParam("rid") int rid, JoinRequestRequest joinRequest, @Context UriInfo uriInfo) {
		JoinRequestJidResponse jidResponse = joinRequestService.requestToJoinRide(rid, joinRequest);
		String jidStr = String.valueOf(jidResponse.getJid());

		return Response.created(Location.getUri(uriInfo, jidStr))
				.status(Status.CREATED)
				.entity(jidResponse)
				.build();	
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{rid}/join_requests/{jid}")
	public Response respondToRideRequest(@PathParam("rid") int rid, @PathParam("jid") int jid, JoinRequestRequest patchJoinRequest) {
		if(patchJoinRequest.getRideConfirmed() != null) {
			joinRequestService.respondToRideRequest(rid, jid, patchJoinRequest);
		}
		if(patchJoinRequest.getPickupConfirmed() != null) {
			joinRequestService.confirmPassengerPickup(rid, jid, patchJoinRequest);
		} 
		return Response.status(Status.OK)
				.build();
	} 
	
	@POST
	@Path("{rid}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(@PathParam("rid") int rid, MessageRequest message, @Context UriInfo uriInfo) {
		AddMessageMidResponse midResponse = messageService.addMessage(rid, message);
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
		return messageService.getAllMessages(rid);
	}
	
}
