package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufrn.telefoneme.auxiliarhorario.GeraTabelaDeTurno;
import br.ufrn.telefoneme.auxiliarhorario.Semana;
import br.ufrn.telefoneme.auxiliarhorario.Turno;
import br.ufrn.telefoneme.componente.Componente;
/**
 * Dada uma tabela imaginaria, ela sera "lida" de cima pra baixo em cada dia e de cada horario
 * @author Marciel Leal
 * 
 */
public class TabelaDeHorarios {
	private final Integer nivel;
	private final Map<Horario,Componente> tabela;
	//TODO May be add/remove this fields after
	//private final Semana semana;
	//private final Turno
	
	public TabelaDeHorarios(Integer nivel, Turno turno,Semana semana) {
		this.nivel=nivel;
		this.tabela=new TreeMap<>();
		
		for(Horario horario:new GeraTabelaDeTurno().getHorariosDoTurno(semana, turno)){
			this.tabela.put(horario, null);
		}
	}
	public Integer getNivel() {
		return nivel;
	}
	
	public Componente getComponente(Horario horario) {
		return tabela.get(horario);
	}
	
	public Horario getHorario(Componente componente){
		for(Horario horario: tabela.keySet()){
			if(tabela.get(horario).equals(componente)){
				return horario;
			}
		}return null;
		//TODO Excecao: Esse componente nao esta no horario 
	}
	
	
	
	/*
	public List<Horario> getHorariosPeloDia(Dia dia){
		List<Horario> horariosPorDia=new ArrayList<>();
		for(Horario hor:horarios){
			if(hor.getDia().equals(dia))
				horariosPorDia.add(hor);
		}
		return horariosPorDia;
	}
	public List<Horario> getHorariosPeloHorario(Integer horario){
		List<Horario> horariosPorDia=new ArrayList<>();
		for(Horario hor:horarios){
			if(hor.getHorarioDoDia().equals(horario))
				horariosPorDia.add(hor);
		}
		return horariosPorDia;
	}*/

}
