package com.cs.iit.project.sar.models;

import java.util.List;
import java.util.Map;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class Ride {
	private Integer rid;
	private Integer aid;
	@JsonbProperty("location_info")
	private LocationInfo locationInfo;
	@JsonbProperty("date_time")
	private DateTime dateTime;
	@JsonbProperty("car_info")
	private Car carInfo;
	@JsonbProperty("max_passengers")
	private Integer maxPassengers;
	@JsonbProperty("amount_per_passenger")
	private Double amountPerPassenger;
	private String conditions;
	@JsonbProperty("join_requests")
	private Map<Integer, JoinRequest> joinRequests;
	private Map<Integer, User> riders;
	private List<Message> messages;
	private boolean isTripCompleted;
}
