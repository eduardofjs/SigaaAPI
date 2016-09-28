package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.auxiliarhorario.Manha;
import br.ufrn.telefoneme.auxiliarhorario.Turno;
import br.ufrn.telefoneme.componente.Componente120h;
import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class StringToComponentTest {

	private StringToComponente conv=new StringToComponente();
	@Test
	public void testGetComponentes() throws IdException, JsonStringInvalidaException, ConexaoException {
		
	}

}
