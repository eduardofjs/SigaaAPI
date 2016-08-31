package br.ufrn.telefoneme.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JsonToObjectExceptionTest.class, JsonToObjectTest.class, OltuJavaClientExceptionTest.class,
		OltuJavaClientTest.class })
public class AllTests {

}
