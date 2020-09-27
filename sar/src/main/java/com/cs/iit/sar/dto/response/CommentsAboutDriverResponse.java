package com.cs.iit.sar.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsAboutDriverResponse {
	private Integer rid;
	private String date;
	private Integer rating;
	private String comment;
}
