package br.ufrn.telefoneme.exception;

/**
 * @author Marciel Leal
 *
 */
@SuppressWarnings("serial")
public class ConnectionException extends Exception {
	public ConnectionException() {
		super();
	}

	public ConnectionException(String message) {
		super(message);
	}

	public ConnectionException(Throwable cause) {
		super(cause);
	}

	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	//

}
