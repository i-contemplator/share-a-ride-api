package com.cs.iit.sar.boundaryinterfaces;

import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.dto.response.JoinRequestJidResponse;

public interface JoinRequestBoundaryInterface {

	JoinRequestJidResponse requestToJoinRide(int rid, JoinRequestRequest joinRequestReq);
	
	void respondToRideRequest(int rid, int jid, JoinRequestRequest patchRideRequestConfirm);
	
	void confirmPassengerPickup(int rid, int  jid, JoinRequestRequest confirmRidePickup);
	
}
