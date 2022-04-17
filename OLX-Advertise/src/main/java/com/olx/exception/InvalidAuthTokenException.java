package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAuthTokenException extends RuntimeException{
	
	private String message;
	public InvalidAuthTokenException() {
		this.message = "";
	}
	public InvalidAuthTokenException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Authentication Token : " +this.message;
	}
	

}
