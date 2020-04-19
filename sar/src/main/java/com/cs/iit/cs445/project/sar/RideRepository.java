package com.cs.iit.cs445.project.sar;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	
	List<Ride> rides;
	
	public RideRepository() {
		rides = new ArrayList<>();
		
		Ride r1 = new Ride();
		r1.setRid(1);
		r1.setName("Chintan");
		
		Ride r2 = new Ride();
		r2.setRid(2);
		r2.setName("Tejasvi");
		
		rides.add(r1);
		rides.add(r2);
		
	}
	
	public List<Ride> getRides() {
		return rides;
	}
	
	public Ride getRide(int rid) {
		for(Ride r : rides) {
			if(r.getRid()==rid) {
				return r;
			}
		}
		
		return new Ride();
	}

	public void createRide(Ride r1) {
		rides.add(r1); 
	}
}
