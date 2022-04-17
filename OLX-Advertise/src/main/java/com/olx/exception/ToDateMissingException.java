package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ToDateMissingException extends RuntimeException{
	
	private String message;
	public ToDateMissingException() {
		this.message = "";
	}
	public ToDateMissingException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "To Date Missing Exception : " +this.message;
	}
	

}
