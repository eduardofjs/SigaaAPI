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
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
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
	public void test() throws JsonStringInvalidaException, ConnectionException, IdException {
	
			ArchiveConnection a =new ArchiveConnection();		
			for(CursoDTO curso:FachadaDeDados.getInstance().getCursos(a))
				System.out.println(curso.getCurso());
			for(MatrizCurricularDTO matriz:FachadaDeDados.getInstance().getMatrizes(a, 92127264))
				System.out.println(matriz.getNome());
			for(ComponenteCurricularDTO componente:FachadaDeDados.getInstance().getComponentes(a,new Long(105755388)))			
				System.out.println(componente.getNome());
			try{
				for(EstatisticasTurmasDTO estatistica:FachadaDeDados.getInstance().getEstatisticas(a, "GRADUACAO", "IMD0012.1"))
					System.out.println(estatistica.getCodigoComponente());
			}catch(JsonStringInvalidaException e){
				
			}
	
	}

}
