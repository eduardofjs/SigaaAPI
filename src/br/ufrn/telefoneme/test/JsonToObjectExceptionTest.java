package br.ufrn.telefoneme.test;

import org.junit.Test;

import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class JsonToObjectExceptionTest {

	@Test(expected=JsonStringInvalidaException.class)
	public void testGetCursosTest() throws JsonStringInvalidaException{
		JsonToObject.toCursoDTO("");
	}

	@Test(expected=JsonStringInvalidaException.class)
	public void testGetComponentesTest() throws JsonStringInvalidaException {
		JsonToObject.toComponenteCurricularDTO(" ");
	}

	@Test(expected=JsonStringInvalidaException.class)
	public void testGetMatrizTest() throws JsonStringInvalidaException {
		JsonToObject.toMatrizCurricularDTO(" ");
	}

}
