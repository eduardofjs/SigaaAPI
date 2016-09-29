package br.ufrn.telefoneme.exception;

/**
 * @author Marciel Leal
 *
 */
@SuppressWarnings("serial")
public class ConexaoException extends Exception {
	public ConexaoException() {
		super();
	}

	public ConexaoException(String message) {
		super(message);
	}

	public ConexaoException(Throwable cause) {
		super(cause);
	}

	public ConexaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	//

}
