package com.cs.iit.sar.boundaryinterfaces;

import java.util.List;

import com.cs.iit.sar.dto.request.AccountRequest;
import com.cs.iit.sar.dto.response.AccountResponse;
import com.cs.iit.sar.dto.response.CreateAccountAidResponse;

public interface AccountBoundaryInterface {
	
	CreateAccountAidResponse createAccount(AccountRequest userRequest);
	
	void activateAccount(int aid, AccountRequest userRequest);
	
	void updateAccount(int aid, AccountRequest userRequest);
	
	void deleteAccount(int aid);
	
	List<AccountResponse> viewAllAccounts();
	
	List<AccountResponse> searchAccounts(String key);
	
}
