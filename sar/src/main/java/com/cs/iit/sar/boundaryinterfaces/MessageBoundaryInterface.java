package com.cs.iit.sar.boundaryinterfaces;

import java.util.List;

import com.cs.iit.sar.dto.request.MessageRequest;
import com.cs.iit.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.sar.dto.response.MessageResponse;

public interface MessageBoundaryInterface {

	AddMessageMidResponse addMessage(int rid, MessageRequest messageRequest);
	
	List<MessageResponse> getAllMessages(int rid);
	
}
