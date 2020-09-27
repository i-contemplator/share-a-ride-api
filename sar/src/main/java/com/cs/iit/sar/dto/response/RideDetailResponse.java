package com.cs.iit.sar.dto.response;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideDetailResponse {
	private Integer rid;
	@JsonbProperty("location_info")
	private LocationInfoResponse locationInfo;
	@JsonbProperty("date_time")
	private DateTimeResponse dateTime;
	@JsonbProperty("car_info")
	private CarResponse carInfo;
	@JsonbProperty("driver")
	private String firstName;
	@JsonbProperty("driver_picture")
	private String driverPicture;
	private Integer rides;
	private Integer ratings;
	@JsonbProperty("average_rating")
	private Double averageRating;
	@JsonbProperty("comments_about_driver")
	private List<CommentsAboutDriverResponse> commentsAboutDriver;
}
