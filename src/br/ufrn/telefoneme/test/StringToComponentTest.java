package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class StringToComponentTest {

	private StringToComponente conv=new StringToComponente();
	@Test
	public void testGetComponentes() throws IdException, JsonStringInvalidaException, ConexaoException {
		//
	}

}
