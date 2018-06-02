package com.hetal.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{
	
	private String listOfValidHobbies;

	@Override
	public void initialize(IsValidHobby arg0) {
		this.listOfValidHobbies = arg0.validHobbyList();
		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		if(studentHobby == null) {
			return false;
		}
		if(studentHobby.matches(listOfValidHobbies)) {
			return true;
		} else {
			return false;
		}
	}

}
