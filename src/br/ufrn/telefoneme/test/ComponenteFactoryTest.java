package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.ComponenteFactory;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

public class ComponenteFactoryTest {
	ComponenteFactory ren=new ComponenteFactory();
	@Test
	public void test() {
		ComponenteCurricularDTO componente=new ComponenteCurricularDTO();
		ren.geraNovoComponente(componente, idCurriculo);
	}

}
