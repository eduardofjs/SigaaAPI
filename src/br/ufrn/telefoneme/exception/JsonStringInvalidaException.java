package br.ufrn.telefoneme.exception;
/**
 * 
 * @author Marciel Leal
 *
 */
@SuppressWarnings("serial")
public class JsonStringInvalidaException extends ErroNaManipulacaoDosDados {

	public JsonStringInvalidaException() {
		super();
	}

	public JsonStringInvalidaException(String message) {
		super(message);
	}

}
