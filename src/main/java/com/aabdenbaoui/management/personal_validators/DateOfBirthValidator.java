package com.aabdenbaoui.management.personal_validators;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
@Component
public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthConstraint, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
	LocalDate todayDate = LocalDate.now();
        if(value != null && (value.plusYears(18).compareTo(todayDate) <= 0)) {
        	return true;
//        }else if(value.plusYears(18).compareTo(todayDate) > 1){
//        	return true;
//        }else if(value.plusYears(18).compareTo(todayDate) == 0){
//        	return true;
        }else {
        	return false;
        }
	}

}
