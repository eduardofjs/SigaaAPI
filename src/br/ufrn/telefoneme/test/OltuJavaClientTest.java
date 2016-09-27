package br.ufrn.telefoneme.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

public class OltuJavaClientTest {

	
	@Test
	public void getCursosTest(){
		try{
			assertNotEquals(OltuJavaClient.getCursos(), "");
		}catch(ConexaoException ex){
			fail("Não conectado");
		}
	}
	
	@Test
	public void getComponentesTest(){
		try{
			assertNotEquals(OltuJavaClient.getComponentes(3213), "");
		}catch(ConexaoException ex){
			fail("Não conectado");
		}catch(IdException ex){
			fail("Exceção não esperada");
		}
	}
	
	@Test
	public void getMatrizTest(){
		try{
			assertNotEquals(OltuJavaClient.getMatrizCurricular(3113), "");
		}catch(ConexaoException ex){
			fail("Não conectado");
		}catch(IdException ex){
			fail("Exceção não esperada");
		}
	}
}
