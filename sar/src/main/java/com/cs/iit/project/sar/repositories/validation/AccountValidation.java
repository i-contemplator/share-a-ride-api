package com.cs.iit.project.sar.repositories.validation;

public class AccountValidation {
	
	public static boolean isNameValid(String name) {
		char[] charArr = name.toCharArray();
		for(Character c : charArr) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPhoneValid(String phone) {
		String phoneRegex = "\\d{3}-\\d{3}-\\d{4}";
		if(phone.matches(phoneRegex)) {
			return true;
		}
		return false;
	}
	
	public static boolean isAccountActive(Boolean isActive) {
		if(isActive == true) {
			return true;
		}
		return false;
	}
	
	public static boolean isRatingAmountValid(Integer rating) {
		if(rating >= 0 && rating <= 5) {
			return true;
		}
		return false;
	}

}
