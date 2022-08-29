package com.example.demo.exception;

public class UserAlredyExist extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlredyExist(String s){
		super(s);
	}

}
