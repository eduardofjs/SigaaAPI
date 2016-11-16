package br.ufrn.telefoneme.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.componente.GeradorDeTodosComponentes;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.connection.ArchiveConnection;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.organize.GeradorDeTurmas;
import br.ufrn.telefoneme.organize.GeradorTurmasProximoSemestre;

public class SugestaoAbrirDisciplinasTest {
	GeradorDeTurmas sugestao=new GeradorTurmasProximoSemestre();
	AbstractConnection connection=new ArchiveConnection();
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
	public void test() throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException {
		
		System.out.println(sugestao.gerar(new GeradorDeTodosComponentes().listBuilder(connection, new Long(105755388)), 2));
	}

}
