package com.aabdenbaoui.management.personal_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = StartDateEndDateValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StartDateEndDateConstraint {

	String message() default "Please check your start and end dates."; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
			
}
