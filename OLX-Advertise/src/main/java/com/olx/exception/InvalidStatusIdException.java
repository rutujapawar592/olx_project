package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStatusIdException extends RuntimeException{
	
	private String message;
	public InvalidStatusIdException() {
		this.message = "";
	}
	public InvalidStatusIdException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Status Id Exception : " +this.message;
	}
	

}