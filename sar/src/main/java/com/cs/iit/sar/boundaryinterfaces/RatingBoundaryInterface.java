package com.cs.iit.sar.boundaryinterfaces;

import com.cs.iit.sar.dto.request.RateAccountRequest;
import com.cs.iit.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.sar.dto.response.ViewRiderRatingsResponse;

public interface RatingBoundaryInterface {

	RateAccountSidResponse rateAccount(int aid, RateAccountRequest ratingRequest);
			
	ViewDriverRatingsResponse viewDriverRatings(int aid);
	
	ViewRiderRatingsResponse viewRiderRatings(int aid);	
	
}
