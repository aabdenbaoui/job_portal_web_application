package com.aabdenbaoui.management.personal_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUniqueValidator {

	
	String message() default "Please enter the a valid email or this email is already taken\n.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
