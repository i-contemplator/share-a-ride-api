package com.cs.iit.cs445.project.sar;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("rides")
public class RideResource {
	
	RideRepository repo = new RideRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ride> getRides() 
	{
		return repo.getRides();
	}
	
	@GET
	@Path("ride/{rid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ride getRide(@PathParam("rid") int rid) 
	{
		return repo.getRide(rid);
	}

	@POST
	@Path("ride")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Ride createRide(Ride r1) {
		System.out.println(r1);
		repo.createRide(r1);	
		return r1;
	}
}
