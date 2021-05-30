package com.piggy.bank.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

@ControllerAdvice
public class AppExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<Object> handleInvalidInputException(ResourceNotFoundException ex) {
    	LOGGER.error("ResourceNotFoundException: ", ex.getMessage());
    	ExceptionBody webEx = new ExceptionBody(HttpStatus.NOT_FOUND, "ErrorCode Not Implemented", ex.getMessage());
        return new ResponseEntity<Object>(webEx, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Unauthorized.class })
    public ResponseEntity<Object> handleUnauthorizedException(Unauthorized ex) {
        LOGGER.error("Unauthorized Exception: ", ex);
        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex) {
        LOGGER.error("Exception: ", ex);
        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public HttpHeaders getResponseHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Responded", "GroupController");
		return headers;
	}
}