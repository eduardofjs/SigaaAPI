package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.auxiliarhorario.Semana;
import br.ufrn.telefoneme.auxiliarhorario.TurnoFactory;
import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.ComponenteFactory;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;


/**
 * Somente disciplinas obrigatorias
 * @author Marciel Leal
 *
 */
public class SugestaoDeHorario {
	private final List<TabelaDeHorarios> tabelas;
	private final List<Componente> componentes;
	
	public SugestaoDeHorario(MatrizCurricularDTO matriz,List<ComponenteCurricularDTO> componentesDaGrade) throws IdException, JsonStringInvalidaException, CargaHorariaDesconhecidaException, ConexaoException{
		this.tabelas=new ArrayList<>();
		this.componentes=new ArrayList<>();
		
		//Criando horarios
		for (int nivel = 1; nivel <= matriz.getSemestreConclusaoIdeal(); nivel++) {
			tabelas.add(new TabelaDeHorarios(nivel, new TurnoFactory().geraTurno(matriz.getTurno()),
					new Semana(new Dia(2), new Dia(7))));
		}
		
		//Convertendo componentes
		for(ComponenteCurricularDTO componenteDaGrade:componentesDaGrade){
			if(componenteDaGrade.isObrigatoria())
				componentes.add(new ComponenteFactory().geraNovoComponente(componenteDaGrade, matriz.getIdCurriculo()));
		}
		
		//Ordenando componentes para facilitar a procura de componentes sem prerequisito
		componentes.sort(new Comparator<Componente>(){
			@Override
			public int compare(Componente o1, Componente o2) {
				return new Integer(o1.getPrerequisitos().size()).compareTo(new Integer(o2.getPrerequisitos().size()));
			}
		});
	}

	public List<TabelaDeHorarios> getSugestao(){
		for(Componente componente:componentes){
			if(componente.getPrerequisitos().isEmpty()){
				for(TabelaDeHorarios tabela:tabelas){
					if(tabela.getNivel().equals(componente.getNivel())){
						componente.insereNaTabelaDeHorarios(tabela,null);
						break;
					}
					//TODO Lancar excecoes
				}
			}else{
				for(TabelaDeHorarios tabela:tabelas){
					for(Componente prereq:componente.getPrerequisitos()){
						
					}
			}
			
		}//TODO lancar excecoes
		return tabelas;
	}
	
}
