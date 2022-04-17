package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FromDateMissingException extends RuntimeException{
	
	private String message;
	public FromDateMissingException() {
		this.message = "";
	}
	public FromDateMissingException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "From Date Missing Exception : " +this.message;
	}
	

}
