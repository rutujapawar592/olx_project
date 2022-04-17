package com.olx.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = InvalidAuthTokenException.class)
	public ResponseEntity<Object> handleConflictAuthToken(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = InvalidAdvertiseIdException.class)
	public ResponseEntity<Object> handleConflictAdvertiseId(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = UserNameDoesNotExistException.class)
	public ResponseEntity<Object> handleConflictUserName(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = OnDateMissingException.class)
	public ResponseEntity<Object> handleConflictOnDateMissing(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = FromDateMissingException.class)
	public ResponseEntity<Object> handleConflictFromDateMissing(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = ToDateMissingException.class)
	public ResponseEntity<Object> handleConflictToDateMissing(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = InvalidPageIdException.class)
	public ResponseEntity<Object> handleConflictInvalidPageId(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = InvalidCategoryIdException.class)
	public ResponseEntity<Object> handleConflictInvalidCatId(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	
	@ExceptionHandler(value = InvalidStatusIdException.class)
	public ResponseEntity<Object> handleConflictInvalidStatusId(RuntimeException exception, WebRequest request) {
		String errorMessage = "{\"error\": \" "+ exception.toString() + "\"}";
		ResponseEntity<Object> response = 
				handleExceptionInternal(exception, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);
		return response;
		
	}
	


}
