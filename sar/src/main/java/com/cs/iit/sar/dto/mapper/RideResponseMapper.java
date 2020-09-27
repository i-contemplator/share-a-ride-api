package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.CommentsAboutDriverResponse;
import com.cs.iit.sar.dto.response.RideResponse;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.Ride;

@Mapper
public interface RideResponseMapper {

	RideResponse toRideDto(Ride ride);
	
	CommentsAboutDriverResponse toCommentsAboutDriverDto(Rating rating);

}
