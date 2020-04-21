package com.cs.iit.project.sar;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens()
	{
		System.out.println("Get Aliens called....");
		
		return repo.getAliens();
	}
	
	@POST
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien a1)
	{
		System.out.println("Get Alien called....");
		repo.create(a1);
		return a1;
	}
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") int id)
	{		
		return repo.getAlien(id);
	}
}
