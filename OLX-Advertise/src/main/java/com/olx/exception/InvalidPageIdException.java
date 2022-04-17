package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPageIdException extends RuntimeException{
	
	private String message;
	public InvalidPageIdException() {
		this.message = "";
	}
	public InvalidPageIdException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Page Id Exception : " +this.message;
	}
	

}

