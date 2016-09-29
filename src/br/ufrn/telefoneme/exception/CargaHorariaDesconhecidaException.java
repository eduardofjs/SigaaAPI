package br.ufrn.telefoneme.exception;
/**
 * 
 * @author Marciel Leal
 *
 */
@SuppressWarnings("serial")
public class CargaHorariaDesconhecidaException extends Exception {

	public CargaHorariaDesconhecidaException() {
		super();
	}

	public CargaHorariaDesconhecidaException(String message) {
		super(message);
	}

}
