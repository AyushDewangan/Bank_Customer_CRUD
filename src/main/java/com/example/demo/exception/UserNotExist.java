package com.example.demo.exception;

public class UserNotExist extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotExist(String message) {
		super(message);
	}

}
