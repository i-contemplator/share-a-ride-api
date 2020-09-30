package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.cs.iit.sar.dto.request.RideRequest;
import com.cs.iit.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.sar.dto.response.RideDetailResponse;
import com.cs.iit.sar.dto.response.ViewRidesResponse;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;
import com.cs.iit.sar.models.ViewRides;

@Mapper(uses = {CarMapper.class, LocationMapper.class, DateTimeMapper.class, RideResponseMapper.class})
public interface RideMapper {
	
	RideMapper INSTANCE = Mappers.getMapper(RideMapper.class);
	
	CreateRideRidResponse toCreateRideResponseDto(Ride ride);
	
	@Mapping(target = "joinRequests", ignore = true)
	@Mapping(target = "messages", ignore = true)
	@Mapping(target = "rid", ignore = true)
	@Mapping(target = "riders", ignore = true)
	Ride fromRideRequestDto(RideRequest ride);
	
	ViewRidesResponse toViewRidesDto(ViewRides rides);
	
	@Mapping(source = "user.picture", target = "driverPicture")
	@Mapping(source = "user.totalRidesAsDriver", target = "rides")
	@Mapping(source = "user.totalRatingsAsDriver", target = "ratings")
	@Mapping(source = "user.averageRatingAsDriver", target = "averageRating")
	@Mapping(source = "user.driversRating", target = "commentsAboutDriver")
	RideDetailResponse toRideDetailDto(Ride ride, User user);
	
}
