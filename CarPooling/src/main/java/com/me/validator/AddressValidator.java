package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Address;
import com.me.pojo.CardDetails;

public class AddressValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "validate.street", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "validate.city", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "validate.state", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "validate.country", "Field Cannot be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "validate.zip", "Field Cannot be Empty");
	}

}
