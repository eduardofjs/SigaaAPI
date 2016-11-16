package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.exception.ConnectionException;

public class APIConnectionTest {

	@Test
	public void test() throws ConnectionException {
		new APIConnection().getCursos("GRADUACAO");
	}

}
