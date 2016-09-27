package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Dada uma tabela imaginaria, ela sera "lida" de cima pra baixo em cada dia e de cada horario
 * @author Marciel Leal
 * 
 */
public class TabelaDeHorarios {
	private final Integer nivel;
	private final List<Horario> horarios;
	//TODO May be add/remove this fields after
	//private final Semana semana;
	//private final Turno
	
	public TabelaDeHorarios(Integer nivel, Turno turno,Semana semana) {
		this.nivel=nivel;
		this.horarios=turno.getHorarios(semana);
	}
	public Integer getNivel() {
		return nivel;
	}
	public List<Horario> getHorarios(){
		return horarios;
	}
	
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
	}

}
