package exception;

public class IdException extends Exception {

	public IdException() {
		super();
	}

	public IdException(String message) {
		super(message);
	}

	public IdException(Throwable cause) {
		super(cause);
	}

	public IdException(String message, Throwable cause) {
		super(message, cause);
	}

}
