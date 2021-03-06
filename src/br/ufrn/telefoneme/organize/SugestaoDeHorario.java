package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.auxiliarhorario.Semana;
import br.ufrn.telefoneme.auxiliarhorario.TurnoFactory;
import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.GeradorDeComponentes;
import br.ufrn.telefoneme.componente.GeradorDeTodosComponentes;
import br.ufrn.telefoneme.componente.Turma;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;


/**
 * Somente disciplinas obrigatorias
 * @author Marciel Leal
 *
 */
public class SugestaoDeHorario {
	private final List<TabelaDeNivel> tabelas;
	private final List<Componente> componentesObrigatorios;
	private final List<Componente> componentesOptativos;
	
	public SugestaoDeHorario(List<Turma> turmas,AbstractConnection connection, MatrizCurricularDTO matriz, String turno,List<ComponenteCurricularDTO> componentesDaGrade) throws IdException, JsonStringInvalidaException, CargaHorariaDesconhecidaException, ConnectionException{
		this.tabelas=new ArrayList<>();
		this.componentesObrigatorios=new ArrayList<>();
		this.componentesOptativos=new ArrayList<>();
		
		//Criando horarios
		for (int nivel = 1; nivel <= matriz.getSemestreConclusaoIdeal(); nivel++) {
			tabelas.add(new TabelaDeNivel(nivel, new TurnoFactory().geraTurno(turno),
					new Semana(new Dia(2), new Dia(7))));
		}
		
		componentesObrigatorios.addAll(new GeradorDeTodosComponentes().listBuilder(connection,matriz.getIdCurriculo()));
		
		//Ordenando componentes por CH e por quantidade de prerequisitos
		componentesObrigatorios.sort(new Comparator<Componente>(){
			@Override
			public int compare(Componente o1, Componente o2) {
				if(o1.getClass().getName().length()>o2.getClass().getName().length())
					return 1;
				else if(o1.getClass().getName().length()<o2.getClass().getName().length()){
					return -1;
				}
				if(o1.getClass().getName().compareTo(o1.getClass().getName())==0)
					return new Integer(o2.getPrerequisitos().size()).compareTo(new Integer(o1.getPrerequisitos().size()));
				return o1.getClass().getName().compareTo(o1.getClass().getName());
			}
		});
	}

	public List<TabelaDeNivel> getSugestao() {
		for (int nivel = 1; nivel <= tabelas.size(); nivel++) {
			for (Componente componente : componentesObrigatorios) {
				if (componente.getNivel().equals(nivel)) {
					for (TabelaDeNivel tabela : tabelas) {
						if (tabela.getNivel().equals(componente.getNivel())) {
							if (componente.getPrerequisitos().isEmpty()) {
								componente.insereNaTabelaDeHorarios(tabela, null);
							} else {
								componente.insereNaTabelaDeHorarios(tabela,
										tabela.getHorarios(componente.getPrerequisitos()));
							}break;
						}
						// TODO Lancar excecoes
					}
				}
			}
		} // TODO lancar excecoes
		return tabelas;
	}
	
}
