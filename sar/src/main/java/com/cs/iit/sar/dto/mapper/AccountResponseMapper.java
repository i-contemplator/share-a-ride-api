package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.AccountResponse;
import com.cs.iit.sar.models.User;

@Mapper
public interface AccountResponseMapper {
	
//	AccountResponse toAccountResponseDto(User user);
	default AccountResponse toAccountResponseDto(User user) {
		return AccountResponse.builder()
				.aid(user.getAid())
				.name(user.getFirstName() + " " + user.getLastName())
				.dateCreated(user.getDateCreated())
				.active(user.getActive())
				.build();
	}
}
