package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

public class TabelaDeHorarios {
	private final int nivel;
	private final List<Horario> horarios;
	
	public TabelaDeHorarios(int nivel) {
		this.nivel=nivel;
		this.horarios=new ArrayList<>();
	}
	public int getNivel() {
		return nivel;
	}
	public List<Horario> getHorarios(){
		return horarios;
	}
	
	@Override	
	public String toString(){
		String str="";
		//TODO After horario
		/*
		int ultimoHor=1;
		for(Horario horario:horarios.keySet()){
			if(ultimoHor!=horario.getHorarioDoDia())
				str+="\n";
			str+=horarios.get(horario);
			ultimoHor=horario.getHorarioDoDia();
		}
		*/
		return str;
	}

}
