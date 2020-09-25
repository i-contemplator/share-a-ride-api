package com.cs.iit.project.sar.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class ViewRidesResponse {

	private List<RideResponse> rides;
}
