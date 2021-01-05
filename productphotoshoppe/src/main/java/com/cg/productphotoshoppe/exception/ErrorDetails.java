package com.cg.productphotoshoppe.exception;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
//	private Date timestamp;
//	private String message;
//	private String details;
	private final String message;
	private final Date timestamp;
	private final HttpStatus httpStatus;
	public ErrorDetails(String message,  Date timestamp, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
	}
	
	
	public String getMessage() {
		return message;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	

//	public ErrorDetails(Date timestamp, String message, String details) {
//		super();
//		this.timestamp = timestamp;
//		this.message = message;
//		this.details = details;
//	}
//
//	public Date getTimestamp() {
//		return timestamp;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public String getDetails() {
//		return details;
//	}
}
