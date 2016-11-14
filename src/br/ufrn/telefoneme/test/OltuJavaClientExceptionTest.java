package br.ufrn.telefoneme.test;

import org.junit.Test;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

public class OltuJavaClientExceptionTest {//Separadamente?
	

	@Test(expected=IdException.class)
	public void negativeIdMatrizTest() throws Exception {
		APIConnection.getMatrizCurricular(-12);
	}
	
	@Test(expected=IdException.class)
	public void negativeIdCompTest() throws Exception {
		APIConnection.getComponentes(-12);
	}
	
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziaCompTest() throws Exception {
		APIConnection.getComponentes(0);
	}
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziaCursosTest() throws Exception {
		APIConnection.getCursos();
	}
	
	//Deve ser testado sem haver conexão com o servidor
	@Test(expected=ConexaoException.class)
	public void urlVaziamatrizTest() throws Exception {
		APIConnection.getMatrizCurricular(0);
	}
}
