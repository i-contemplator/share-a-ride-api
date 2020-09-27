package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.RatingResponse;
import com.cs.iit.sar.models.Rating;

@Mapper
public interface RatingResponseMapper {
	
	RatingResponse toRatingResponseDto(Rating rating);
}
