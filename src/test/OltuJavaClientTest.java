package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import exception.ExtracaoServidorException;
import exception.IdException;

public class OltuJavaClientTest {

	
	@Test
	public void getCursosTest(){
		try{
			assertNotEquals(OltuJavaClient.getCursos(), "");
		}catch(ExtracaoServidorException ex){
			fail("Não conectado");
		}
	}
	
	@Test
	public void getComponentesTest(){
		try{
			assertNotEquals(OltuJavaClient.getComponentes(3213), "");
		}catch(ExtracaoServidorException ex){
			fail("Não conectado");
		}catch(IdException ex){
			fail("Exceção não esperada");
		}
	}
	
	@Test
	public void getMatrizTest(){
		try{
			assertNotEquals(OltuJavaClient.getMatrizCurricular(3113), "");
		}catch(ExtracaoServidorException ex){
			fail("Não conectado");
		}catch(IdException ex){
			fail("Exceção não esperada");
		}
	}
}
