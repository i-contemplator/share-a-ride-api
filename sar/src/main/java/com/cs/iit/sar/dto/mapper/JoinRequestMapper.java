package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.dto.response.JoinRequestJidResponse;
import com.cs.iit.sar.models.JoinRequest;

import org.mapstruct.Mapping;

@Mapper
public interface JoinRequestMapper {

	JoinRequestMapper INSTANCE = Mappers.getMapper(JoinRequestMapper.class);
	
	@Mapping(target = "jid", ignore = true)
	@Mapping(target = "rid", ignore = true)
	JoinRequest fromJoinRequestDto(JoinRequestRequest joinRequest);
	
	JoinRequestJidResponse toJoinResponseDto(JoinRequest joinRequest);
}
