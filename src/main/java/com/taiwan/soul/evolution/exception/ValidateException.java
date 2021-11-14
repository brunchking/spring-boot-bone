package com.taiwan.soul.evolution.exception;

public class ValidateException extends Exception {
	private String message;

	public ValidateException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
