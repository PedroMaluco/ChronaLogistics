package com.pratica.trains.services.exceptions;

public class LocoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LocoNotFoundException(String msg) {
		super(msg);
	}

}
