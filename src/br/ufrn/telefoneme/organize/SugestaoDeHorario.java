package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.dto.MatrizCurricularDTO;

/**
 * 
 * @author Marciel Leal
 *
 */
public class SugestaoDeHorario {
	private final List<TabelaDeHorarios> tabelas;
	
	public SugestaoDeHorario(MatrizCurricularDTO matriz){
		this.tabelas=new ArrayList<>();
		
	}

	public List<TabelaDeHorarios> getTabelas() {
		return tabelas;
	}
	
}
