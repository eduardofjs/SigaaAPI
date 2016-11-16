package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.Componente30h;
import br.ufrn.telefoneme.componente.Componente60h;

public class ComponenteTest {
	
	@Test
	public void equalsCOD() {
		Componente a=new Componente30h(0, "IMD0012", "", true);
		Componente b=new Componente60h(0, "IMD0014", "", true);
		//assertTrue(a.equals(b));
		List<Componente> lista=new ArrayList<>();
		lista.add(a);
		lista.add(b);
		
	}

}
