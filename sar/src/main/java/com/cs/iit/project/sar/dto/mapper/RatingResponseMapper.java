package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.RatingResponse;
import com.cs.iit.project.sar.models.Rating;

@Mapper
public interface RatingResponseMapper {
	
	RatingResponse toRatingResponseDto(Rating rating);
}
