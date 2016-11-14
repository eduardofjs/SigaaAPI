package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.ComponenteFactory;
import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class ComponenteFactoryTest {
	ComponenteFactory ren=new ComponenteFactory();
	@Test
	public void test() {		
		try {
			ComponenteCurricularDTO componente= FachadaDeDados.getInstance().getComponentes(new Long(102200805)).get(0);
			Componente compGerado=ren.geraNovoComponente(componente, new Long(102200805));
			verificaComponente(compGerado, componente);			
			
		} catch (JsonStringInvalidaException | CargaHorariaDesconhecidaException | IdException | ConnectionException e) {
			e.printStackTrace();
		}
		
	}
	private void verificaComponente(Componente compGerado, ComponenteCurricularDTO componente) throws JsonStringInvalidaException, ConnectionException, IdException{
		assertEquals(compGerado.getCodigo(),componente.getCodigo());
		assertEquals(new Integer(compGerado.getNivel()),new Integer(componente.getSemetreOferta()));
		assertEquals(compGerado.getNome(),componente.getNome());
		
		for(ComponenteCurricularDTO c2: new StringToComponente().getComponentes(componente.getPreRequisitos(), new Long(102200805))){
			for(Componente c1:compGerado.getPrerequisitos()){
				this.verificaComponente(c1, c2);
			}
		}
		for(ComponenteCurricularDTO c2: new StringToComponente().getComponentes(componente.getCoRequisitos(), new Long(102200805))){
			for(Componente c1:compGerado.getCorequisitos()){
				this.verificaComponente(c1, c2);
			}
		}
		for(ComponenteCurricularDTO c2: componente.getComponentesBloco()){
			for(Componente c1:compGerado.getCorequisitos()){
				this.verificaComponente(c1, c2);
			}
		}
	}

}
