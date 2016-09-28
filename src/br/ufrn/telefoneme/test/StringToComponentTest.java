package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * 
 * @author Marciel Leal
 *
 */
public class StringToComponentTest {

	private StringToComponente conv = new StringToComponente();

	@Test
	public void testGetComponentes() {

		try {
			List<ComponenteCurricularDTO> certa = conv.getComponentes("( IMD0011 ) OU ( DIM0600 )",
					new Long(102200805));
			assertEquals(certa.size(), 2);
		} catch (JsonStringInvalidaException | ConexaoException | IdException e) {
			e.printStackTrace();
			fail();
		}

	}

}
