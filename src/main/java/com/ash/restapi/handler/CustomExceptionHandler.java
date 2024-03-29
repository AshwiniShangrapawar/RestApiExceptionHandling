package com.ash.restapi.handler;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ash.restapi.exception.StudentNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> showStudentNotFoundError(StudentNotFoundException snfe) {

//		return new ResponseEntity<String>(snfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<String>(snfe.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
