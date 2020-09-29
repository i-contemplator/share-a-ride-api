package com.cs.iit.sar.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {
	private Integer aid;
	private String msg;
	
	public MessageRequest(Integer aid, String msg) {
		super();
		this.aid = aid;
		this.msg = msg;
	}
}
