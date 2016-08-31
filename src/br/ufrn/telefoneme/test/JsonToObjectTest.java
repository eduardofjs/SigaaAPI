package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.exception.ExtracaoServidorException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class JsonToObjectTest {

	@Test()
	public void testToCursoDTO() {
		String text="";
		
		try {
			text = OltuJavaClient.getCursos();
			assertNotNull(JsonToObject.toCursoDTO(text));
			assertFalse(JsonToObject.toCursoDTO(text).isEmpty());
		} catch (ExtracaoServidorException e) {
			fail("Não conectado");
		} catch (JsonStringInvalidaException e) {
			fail("String seguinte é inválida: "+text);
		}
		
	}

	@Test
	public void testToComponenteCurricularDTO() throws  IdException {
		String text="";
		try {
			text=OltuJavaClient.getComponentes(102200805);
			assertNotNull(JsonToObject.toComponenteCurricularDTO(text));
			assertFalse(JsonToObject.toComponenteCurricularDTO(text).isEmpty());
		} catch (ExtracaoServidorException e) {
			fail("N�o conectado");
		} catch (JsonStringInvalidaException e) {
			fail("String seguinte � inv�lida: "+text);
		}
	}

	@Test
	public void testToMatrizCurricularDTO() throws IdException {
		String text="";
		try {
			text=OltuJavaClient.getMatrizCurricular(92127264);
			assertNotNull(JsonToObject.toMatrizCurricularDTO(text));
			assertNotNull(JsonToObject.toMatrizCurricularDTO(text).isEmpty());
		} catch (ExtracaoServidorException e) {
			fail("Não conectado");
		} catch (JsonStringInvalidaException e) {
			fail("String seguinte é inválida: "+text);
		}
	}

}
