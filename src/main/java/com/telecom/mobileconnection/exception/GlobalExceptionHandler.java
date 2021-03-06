package com.telecom.mobileconnection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(InfoException.class)
	public ResponseEntity<ErrorResponse> infoExistException(InfoException e, WebRequest request) {

		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(UserRegistrationException.class)
	public ResponseEntity<ErrorResponse> invalidUserDetails(UserRegistrationException e, WebRequest request) {

		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidTrackIdException.class)
	public ResponseEntity<ErrorResponse> invalidTrackId(InvalidTrackIdException e, WebRequest request) {

		ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
