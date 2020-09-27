package com.cs.iit.sar.dto.response;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewRiderRatingsResponse {
	private Integer aid;
	@JsonbProperty("first_name")
	private String firstName;
	@JsonbProperty("rides")
	private int totalRidesAsRider;
	@JsonbProperty("ratings")
	private Integer totalRatingsAsRider;
	@JsonbProperty("average_rating")
	private Integer averageRatingAsRider;
	@JsonbProperty("detail")
	private List<RatingResponse> ridersRating;
}
