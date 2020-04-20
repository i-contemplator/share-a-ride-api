package com.cs.iit.cs445.project.sar;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	
	static List<Ride> rides = new ArrayList<Ride>();
	
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
  
	public void createRide(Ride r3) {
		rides.add(r3); 
		System.out.println(rides);
	}
}
