package com.pleo.uitest

class RetryException extends RuntimeException {

	Throwable lastFailureCause

    RetryException(String message, Throwable cause) {
		super(message)
		this.lastFailureCause = cause	
	}
}
