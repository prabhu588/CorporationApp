package com.example.exception;

public class NotSufficentFundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NotSufficentFundException(String message) {
		super(message);
	}
	
	public NotSufficentFundException(String message, Throwable t) {
		super(message, t);
	}
}
