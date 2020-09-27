package com.cs.iit.sar.boundaryinterfaces;

import java.util.List;

import com.cs.iit.sar.dto.request.RideRequest;
import com.cs.iit.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.sar.dto.response.RideDetailResponse;
import com.cs.iit.sar.dto.response.RideResponse;

public interface RideBoundaryInterface {

	CreateRideRidResponse createRide(RideRequest rideRequest);
	
	void updateRide(int rid, RideRequest rideRequest);
	
	void deleteRide(int rid);
	
	List<RideResponse> getAllRides();
	
	List<RideResponse> searchRides(String from, String to, String date);
	
	RideDetailResponse getRide(int rid);

}
