package com.aabdenbaoui.management.personal_validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
@Component
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		if(password.matches(passwordPattern)) {
			return true;
		}
		return false;
	}

}
