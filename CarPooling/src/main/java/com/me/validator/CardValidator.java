package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.me.pojo.CardDetails;

public class CardValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CardDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CardDetails cardDetail = (CardDetails)target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardHolder", "validate.capacity", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNo", "validate.capacity", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "validate.capacity", "Field Cannot be Empty");
	}

}
