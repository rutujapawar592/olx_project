package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OnDateMissingException extends RuntimeException{
	
	private String message;
	public OnDateMissingException() {
		this.message = "";
	}
	public OnDateMissingException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "On Date Missing Exception : " +this.message;
	}
	

}

