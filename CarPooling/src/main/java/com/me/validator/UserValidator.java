package com.me.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validate.name", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validate.username", "Your username Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "validate.gender", "Your gender Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validate.email", "Your email Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "validate.age", "Your age Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "validate.image", "Your image Is Incorrenct");
	}

}
