package br.ufrn.telefoneme.exception;

public class JsonStringInvalidaException extends Exception {

	public JsonStringInvalidaException() {
		super();
	}

	public JsonStringInvalidaException(String message) {
		super(message);
	}

	public JsonStringInvalidaException(Throwable cause) {
		super(cause);
	}

	public JsonStringInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonStringInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
