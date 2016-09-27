package br.ufrn.telefoneme.organize;

import java.util.Map;
import java.util.TreeMap;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.turno.Turno;
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
		
		for(Horario horario: turno.getHorarios(semana))
			this.tabela.put(horario, null);
	}
	public Integer getNivel() {
		return nivel;
	}
	
	public Map<Horario, Componente> getTabela() {
		return tabela;
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
