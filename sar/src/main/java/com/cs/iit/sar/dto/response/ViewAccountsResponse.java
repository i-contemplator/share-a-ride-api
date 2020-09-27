package com.cs.iit.sar.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewAccountsResponse {
	private List<AccountResponse> accounts;
}
