package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cs.iit.sar.dto.request.AccountRequest;
import com.cs.iit.sar.dto.response.CreateAccountAidResponse;
import com.cs.iit.sar.dto.response.ViewAccountsResponse;
import com.cs.iit.sar.models.User;
import com.cs.iit.sar.models.ViewAccounts;

@Mapper(uses = {AccountResponseMapper.class})
public interface AccountMapper {
	
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
	
	CreateAccountAidResponse toCreateAccountDto(User user);
	
	User fromCreateAccountDto(AccountRequest user);
	
	ViewAccountsResponse toViewAccountsDto(ViewAccounts users);
	
}
