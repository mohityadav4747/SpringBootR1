package com.jit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadCredentialsException extends RuntimeException {
	private static final long serialVersionUID=1L;
	
	public BadCredentialsException(String msg) {
		super (msg);
	}

}
