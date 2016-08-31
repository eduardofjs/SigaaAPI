package test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import exception.ExtracaoServidorException;
import exception.IdException;
import exception.JsonStringInvalidaException;

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
			text=OltuJavaClient.getComponentes(232132);
			assertNotNull(JsonToObject.toComponenteCurricularDTO(text));
			assertFalse(JsonToObject.toComponenteCurricularDTO(text).isEmpty());
		} catch (ExtracaoServidorException e) {
			fail("Não conectado");
		} catch (JsonStringInvalidaException e) {
			fail("String seguinte é inválida: "+text);
		}
	}

	@Test
	public void testToMatrizCurricularDTO() throws IdException {
		String text="";
		try {
			text=OltuJavaClient.getMatrizCurricular(3342324);
			assertNotNull(JsonToObject.toMatrizCurricularDTO(text));
			assertNotNull(JsonToObject.toMatrizCurricularDTO(text).isEmpty());
		} catch (ExtracaoServidorException e) {
			fail("Não conectado");
		} catch (JsonStringInvalidaException e) {
			fail("String seguinte é inválida: "+text);
		}
	}

}
