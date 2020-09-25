package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cs.iit.project.sar.dto.request.MessageRequest;
import com.cs.iit.project.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.project.sar.dto.response.ViewMessagesResponse;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Ride;
import org.mapstruct.Mapping;

@Mapper(uses = {MessageResponseMapper.class})
public interface MessageMapper {

	MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
	
	@Mapping(target = "date", ignore = true)
	@Mapping(target = "mid", ignore = true)
	Message fromMessageDto(MessageRequest message);
	
	AddMessageMidResponse toMessageMidDto(Message message);
	
	ViewMessagesResponse toAllMessagesDto(Ride ride);
	
}
