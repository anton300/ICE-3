package com.java;

public class BadChangeException extends Exception {

	private static final long serialVersionUID = 7232945668074721133L;

	public BadChangeException(String errorMessage) {
        super(errorMessage);
    }
}
