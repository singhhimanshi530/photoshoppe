package com.cg.productphotoshoppe.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<Object> handleApiRequestException(ResourceNotFoundException ex){
		ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),
				new Date(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> globalExceptionHandler(Exception e){
		ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),
				new Date(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
