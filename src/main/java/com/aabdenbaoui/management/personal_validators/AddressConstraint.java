package com.aabdenbaoui.management.personal_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AddressValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AddressConstraint {

	String message() default "Please check your state and zip code information and try again."; 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
			
}
