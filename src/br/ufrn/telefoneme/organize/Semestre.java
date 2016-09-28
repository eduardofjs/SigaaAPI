package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.auxiliarhorario.GeraTabelaDeTurno;
import br.ufrn.telefoneme.auxiliarhorario.Semana;
import br.ufrn.telefoneme.auxiliarhorario.Turno;
import br.ufrn.telefoneme.componente.Componente;
/**
 * Dada uma tabela imaginaria, ela sera "lida" de cima pra baixo em cada dia e de cada horario
 * @author Marciel Leal
 * 
 */
public class Semestre {
	private final Integer nivel;
	private final Map<Horario,Componente> tabela;
	//TODO May be add/remove this fields after
	//private final Semana semana;
	//private final Turno
	
	public Semestre(Integer nivel, Turno turno,Semana semana) {
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
	
	public List<Horario> getHorarios(List<Componente> componentes){
		List<Horario> horarios =new ArrayList<>();
		
		for(Componente componente: componentes){
			for(Horario horario: tabela.keySet()){
				if(tabela.get(horario).equals(componente)){
					horarios.add(horario);
					break;
				}
			}
		}return horarios;
		//TODO Excecao: Esse componente nao esta no horario 
	}
	
	public Set<Horario> getHorarios(){
		return tabela.keySet();
	}
	
	/**
	 * Retorna uma lista de horarios de um determinado dia
	 * @param dia
	 * @return
	 */
	public List<Horario> getHorariosPeloDia(Dia dia){
		List<Horario> horariosPorDia=new ArrayList<>();
		for(Horario hor:tabela.keySet()){
			if(hor.getDia().equals(dia))
				horariosPorDia.add(hor);
		}
		return horariosPorDia;
	}
	/**
	 * Retorna uma lista de horarios
	 * @param horario
	 * @return
	 */
	public List<Horario> getHorariosPeloHorario(/*Turno turno,*/ Integer horario){
		//TODO COlocar turno como parametro para matrizes com mais de um turno
		List<Horario> horariosPorDia=new ArrayList<>();
		for(Horario hor:tabela.keySet()){
			if(hor.getHorarioDoDia().equals(horario))
				horariosPorDia.add(hor);
		}
		return horariosPorDia;
	}

	public Map<Horario, Componente> getTabela() {
		return tabela;
	}

}
