package com.nissan.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.exception.SalesVisitException;
import com.nissan.model.SalesVisit;



public class validateVisitDetails {
	
	public static void detailsValidation(SalesVisit salesVisit) throws SalesVisitException{
		validateName(salesVisit.getCust_name());
		validateContactNumber(salesVisit.getContact_no());
	}

	//method to validate name
	private static void validateName(String cust_name) throws SalesVisitException{
		//pattern matching using regex
		Pattern pattern=Pattern.compile("[A-Za-z]");
		Matcher matcherCustomerName=pattern.matcher(cust_name);
		
		boolean matchCustomerNameFound=matcherCustomerName.find();
		
		if(!matchCustomerNameFound) {
			throw new SalesVisitException("Name must be in aplhabets");
		}
			
	}

	private static void validateContactNumber(Long contact_no) throws SalesVisitException{
		if(contact_no<7000000000l && contact_no>9999999999l) {
			throw new SalesVisitException("Put a valid phone number of 10 digits");
		}
		
		
	}

}
