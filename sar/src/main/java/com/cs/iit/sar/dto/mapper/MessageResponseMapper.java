package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.MessageResponse;
import com.cs.iit.sar.models.Message;

@Mapper
public interface MessageResponseMapper {

	default MessageResponse toMessageDto(Message message) {
		return MessageResponse.builder()
		.mid(message.getMid())
		.sentByAid(message.getAid())
		.date(message.getDate())
		.body(message.getMsg())
		.build();
	}
}
