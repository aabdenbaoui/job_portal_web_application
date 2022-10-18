package com.aabdenbaoui.management.personal_validators;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.util.privilegedactions.IsClassPresent;
import org.springframework.stereotype.Component;

import com.aabdenbaoui.management.entity.seekerprofilebuilder.TimeLine;
@Component
public class StartDateEndDateValidation implements ConstraintValidator<StartDateEndDateConstraint, TimeLine>{

	@Override
	public boolean isValid(TimeLine timeLine, ConstraintValidatorContext context) {
		LocalDate todayDate = LocalDate.now();

//        if( timeLine != null && {
//        	return true;
       if(timeLine != null && todayDate.isAfter(timeLine.getEndDate()) &&  todayDate.isAfter(timeLine.getStartDate()) && timeLine.getEndDate().isAfter(timeLine.getStartDate())) {
          return true; 
       }
		return false;
	}
	

}
