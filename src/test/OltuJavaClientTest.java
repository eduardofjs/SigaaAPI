package test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import exception.ExtracaoServidorException;
import exception.IdException;

public class OltuJavaClientTest {

	@Test(expected=IdException.class)
	public void negativeIdTest() throws Exception {
		OltuJavaClient.getComponentes(-12);
		OltuJavaClient.getMatrizCurricular(-12);
	}
	
	//Deve ser testado sem ter haver conexão com o servidor
	@Test(expected=ExtracaoServidorException.class)
	public void urlVaziaTest() throws Exception {
		OltuJavaClient.getComponentes(0);
		OltuJavaClient.getEstruturaCurricular();
		OltuJavaClient.getMatrizCurricular(0);
	}
}
