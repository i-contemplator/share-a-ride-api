package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.LocationInfoResponse;
import com.cs.iit.sar.models.LocationInfo;

@Mapper
public interface LocationMapper {

	LocationInfoResponse toLocationDto(LocationInfo location);
}
