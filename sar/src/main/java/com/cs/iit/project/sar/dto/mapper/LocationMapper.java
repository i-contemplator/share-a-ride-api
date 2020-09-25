package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.LocationInfoResponse;
import com.cs.iit.project.sar.models.LocationInfo;

@Mapper
public interface LocationMapper {

	LocationInfoResponse toLocationDto(LocationInfo location);
}
