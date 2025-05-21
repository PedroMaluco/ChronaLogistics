package com.pratica.trains.services.exceptions;

public class UnsavedObjException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UnsavedObjException(String msg) {
		super(msg);
	}

}
