package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.cs.iit.sar.dto.request.RateAccountRequest;
import com.cs.iit.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.sar.dto.response.ViewRiderRatingsResponse;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.User;
import org.mapstruct.Mapping;

@Mapper(uses = {RatingResponseMapper.class})
public interface RatingMapper {

	RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);
	
	@Mapping(target = "firstName", ignore = true)
	Rating fromRateAccountRequestDto(RateAccountRequest rating);
	
	RateAccountSidResponse toRateAccountResponseDto(Rating rating);
	
	ViewRiderRatingsResponse toViewRiderRatingsDto(User user);
	
	ViewDriverRatingsResponse toViewDriverRatingsDto(User user);
	
}
