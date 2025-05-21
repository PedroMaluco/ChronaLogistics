package com.pratica.trains.services.exceptions;

public class InvalidAcessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidAcessException(String msg) {
		super(msg);
	}

}
