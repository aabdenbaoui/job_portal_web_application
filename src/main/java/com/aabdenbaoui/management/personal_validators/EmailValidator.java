package com.aabdenbaoui.management.personal_validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aabdenbaoui.management.service.UsersService;
@Component
public class EmailValidator  implements ConstraintValidator<EmailUniqueValidator, String>{

//
	@Autowired
	UsersService usersService;
	
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

        if(usersService.isFound(email)) {
        	return false;
        }else {
        	return true;
        }
	}

}
