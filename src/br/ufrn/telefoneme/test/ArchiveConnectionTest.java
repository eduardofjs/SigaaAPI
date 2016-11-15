package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.ArchiveConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class ArchiveConnectionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			ArchiveConnection a =new ArchiveConnection();		
			for(ComponenteCurricularDTO componente:FachadaDeDados.getInstance().getComponentes(new APIConnection(),new Long(105755388)))			
				a.getEstatisticas("", "IMD0024");
		} catch (ConnectionException | JsonStringInvalidaException | IdException e) {
			fail(e.getMessage());
		}
	}

}
