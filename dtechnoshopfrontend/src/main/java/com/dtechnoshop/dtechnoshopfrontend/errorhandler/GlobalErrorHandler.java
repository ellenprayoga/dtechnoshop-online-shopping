package com.dtechnoshop.dtechnoshopfrontend.errorhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
	public String Exception() {
		return "exceptionPage";
	}
}
