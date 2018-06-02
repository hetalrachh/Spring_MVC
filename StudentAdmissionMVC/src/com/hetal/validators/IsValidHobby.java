package com.hetal.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HobbyValidator.class)
public @interface IsValidHobby {
	
	String validHobbyList() default "music|tt";
	
	String message() default "Please provide valid hobby" + "accepted values are cricket, football, badminton";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};

}
