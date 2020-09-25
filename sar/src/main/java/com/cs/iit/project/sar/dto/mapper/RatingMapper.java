package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cs.iit.project.sar.dto.request.RateAccountRequest;
import com.cs.iit.project.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.project.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.project.sar.dto.response.ViewRiderRatingsResponse;
import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;

@Mapper(uses = {RatingResponseMapper.class})
public interface RatingMapper {

	RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);
	
	Rating fromRateAccountRequestDto(RateAccountRequest rating);
	
	RateAccountSidResponse toRateAccountResponseDto(Rating rating);
	
	ViewRiderRatingsResponse toViewRiderRatingsDto(User user);
	
	ViewDriverRatingsResponse toViewDriverRatingsDto(User user);
	
}
