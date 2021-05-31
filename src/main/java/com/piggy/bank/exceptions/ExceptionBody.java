package com.piggy.bank.exceptions;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ExceptionBody {

	private final HttpStatus status;
	private final String code;
	private final String message;

	public ExceptionBody(final HttpStatus status, final String code, final String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
