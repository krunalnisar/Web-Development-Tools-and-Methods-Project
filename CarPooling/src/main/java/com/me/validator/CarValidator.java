package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Car;
import com.me.pojo.User;

public class CarValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Car.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
			// TODO Auto-generated method stub
			Car car = (Car)target;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.name", "Field Cannot be Empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacity", "validate.capacity", "Field Cannot be Empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelNo", "validate.modelNo", "Field Cannot be Empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "validate.color", "Field Cannot be Empty");

		

		
	}

}
