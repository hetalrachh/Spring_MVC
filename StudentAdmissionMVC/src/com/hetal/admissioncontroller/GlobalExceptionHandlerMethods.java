package com.hetal.admissioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) throws Exception {
		System.out.println("Null pointer exception occured " + e);
		return "null-pointer-exception";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String handleGenericException(Exception ex) throws Exception {
		System.out.println("arithmetic exception occured " + ex);
		return "generic-exception";
	}

}
