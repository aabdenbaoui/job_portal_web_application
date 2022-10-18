package com.aabdenbaoui.management.personal_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {

	String message() default "Secure Password requirements: \r\n"
			+ "Password must contain at least one digit [0-9].\r\n"
			+ "Password must contain at least one lowercase Latin character [a-z].\r\n"
			+ "Password must contain at least one uppercase Latin character [A-Z].\r\n"
			+ "Password must contain at least one special character like ! @ # & ( ).\r\n"
			+ "Password must contain a length of at least 8 characters and a maximum of 20 characters."; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
			
}
