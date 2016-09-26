package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufrn.telefoneme.organize.Horario.Turno;

/**
 * @author Marciel Leal
 * 
 */
public class TabelaHorario {
	private final Map<Horario,ComponenteCurricular> horarios;
	
	public TabelaHorario(int inicio,int fim){
		horarios=new TreeMap<>();
		
		int qHorariosNoTurno;
		for(int dia=inicio;dia<=fim;dia++){
			for(Turno t: Turno.values()){
				if(t==Turno.N)
					qHorariosNoTurno=4;
				else
					qHorariosNoTurno=6;
				for(int horario=1;horario<=qHorariosNoTurno;horario++){
					horarios.put(new Horario(dia,t,horario),null);
				}
			}
		}
	}
	@Override	
	public String toString(){
		String str="";
		
		int ultimoHor=1;
		for(Horario horario:horarios.keySet()){
			if(ultimoHor!=horario.getHorarioDoDia())
				str+="\n";
			str+=horarios.get(horario);
			ultimoHor=horario.getHorarioDoDia();
		}
		
		return str;
	}
	
}
