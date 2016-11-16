package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.componente.GraphComponenteFactory;
import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.connection.ArchiveConnection;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.organize.SugestaoAbrirDisciplinas;

public class SugestaoAbrirDisciplinasTest {
	SugestaoAbrirDisciplinas sugestao=new SugestaoAbrirDisciplinas();
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
		System.out.println(sugestao.gerarSugestao(new GraphComponenteFactory().listBuilder(connection, new Long(105755388)), 2));
	}

}
