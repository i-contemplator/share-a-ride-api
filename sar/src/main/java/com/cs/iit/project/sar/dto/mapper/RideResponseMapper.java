package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.CommentsAboutDriverResponse;
import com.cs.iit.project.sar.dto.response.RideResponse;
import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.Ride;

@Mapper
public interface RideResponseMapper {

	RideResponse toRideDto(Ride ride);
	
	CommentsAboutDriverResponse toCommentsAboutDriverDto(Rating rating);

}
