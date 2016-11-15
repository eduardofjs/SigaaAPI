package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.ArchiveConnection;
import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConnectionException;
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
	public void testGetComponentesAPI() {

		try {
			List<ComponenteCurricularDTO> certa = conv.getComponentes(new APIConnection(), "( IMD0011 ) OU ( DIM0600 )",
					new Long(102200805));
			assertEquals(certa.size(), 2);
		} catch (JsonStringInvalidaException | ConnectionException | IdException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testGetComponentesArch() {

		try {
			List<ComponenteCurricularDTO> certa = conv.getComponentes(new ArchiveConnection(), "( IMD0011 ) OU ( DIM0600 )",
					new Long(102200805));
			assertEquals(certa.size(), 2);
		} catch (JsonStringInvalidaException | ConnectionException | IdException e) {
			e.printStackTrace();
			fail();
		}

	}

}
