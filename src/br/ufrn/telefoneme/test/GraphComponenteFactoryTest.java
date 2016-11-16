package br.ufrn.telefoneme.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.GraphComponenteFactory;
import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class GraphComponenteFactoryTest {

	GraphComponenteFactory fac=new GraphComponenteFactory();
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
*/
	@Test
	public void test() throws IdException{
		try {
			for(Componente comp: fac.listBuilder(new APIConnection(), new Long(105755388))){
				System.out.println(comp.getNome()+
						"\n->"+comp.getPrerequisitos()+
						"\n->"+comp.getCorrequisitos()+
						//"\n->"+comp.getSubComponente()+
						"\n->"+comp.getEstatisticas()+"\n\n\n");
			}
		} catch (JsonStringInvalidaException | ConnectionException | CargaHorariaDesconhecidaException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		
	}

}
