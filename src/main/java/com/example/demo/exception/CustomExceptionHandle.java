package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class CustomExceptionHandle {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserAlredyExist.class)
	public Map<String, String> handelUserAlredyExist(UserAlredyExist ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getMessage());
		return errors;
	}
}
