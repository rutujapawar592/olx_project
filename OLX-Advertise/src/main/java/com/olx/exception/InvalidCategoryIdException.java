package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCategoryIdException extends RuntimeException{
	
	private String message;
	public InvalidCategoryIdException() {
		this.message = "";
	}
	public InvalidCategoryIdException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Category Id Exception : " +this.message;
	}
	

}
