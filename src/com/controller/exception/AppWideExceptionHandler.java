package com.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler(){
		System.err.println("duplicate spittle can not be passed");
		return "error/duplicate";
	}
}
