package com.cs.iit.project.sar.dto.response;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class ViewDriverRatingsResponse {
	private Integer aid;
	@JsonbProperty("first_name")
	private String firstName;
	@JsonbProperty("rides")
	private int totalRidesAsDriver;
	@JsonbProperty("ratings")
	private Integer totalRatingsAsDriver;
	@JsonbProperty("average_rating")
	private Integer averageRatingAsDriver;
	@JsonbProperty("detail")
	private List<RatingResponse> driversRating;
}
