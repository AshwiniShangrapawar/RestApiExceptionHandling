package com.ash.restapi.exception;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException() {
		
	}

	public StudentNotFoundException(String msg) {

		super(msg);
	}

}
