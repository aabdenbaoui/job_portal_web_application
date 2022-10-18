package com.aabdenbaoui.management.personal_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateOfBirthValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthConstraint {

	String message() default "Please enter a valid date of birth\n."
			+ " The date cannot be empty and you will have to be 18 years old to register";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
			
}
