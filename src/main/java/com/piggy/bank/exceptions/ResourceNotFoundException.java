package com.piggy.bank.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
	public ResourceNotFoundException(Throwable ex) {
		super(ex);
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException() {
		super();
	}

}
