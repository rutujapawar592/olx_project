package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameDoesNotExistException extends RuntimeException{
	
	private String message;
	public UserNameDoesNotExistException() {
		this.message = "";
	}
	public UserNameDoesNotExistException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "User Name Does Not Exists Exception : " +this.message;
	}
	

}
