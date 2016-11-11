package br.ufrn.telefoneme.test;

import org.junit.Test;

import br.ufrn.telefoneme.connection.Connection;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

public class OltuJavaClientExceptionTest {//Separadamente?
	

	@Test(expected=IdException.class)
	public void negativeIdMatrizTest() throws Exception {
		Connection.getMatrizCurricular(-12);
	}
	
	@Test(expected=IdException.class)
	public void negativeIdCompTest() throws Exception {
		Connection.getComponentes(-12);
	}
	
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziaCompTest() throws Exception {
		Connection.getComponentes(0);
	}
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziaCursosTest() throws Exception {
		Connection.getCursos();
	}
	
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziamatrizTest() throws Exception {
		Connection.getMatrizCurricular(0);
	}
}
