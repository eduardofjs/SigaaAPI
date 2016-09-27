package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class TabelaDeHorarios {
	private final int nivel;
	private final List<Horario> horarios;
	private final Semana semana;
	
	public TabelaDeHorarios(int nivel, Turno turno,Semana semana) {
		this.nivel=nivel;
		this.horarios=new ArrayList<>();
		this.semana=semana;
		//TODO A generator for TabelaDeHorarios
		//TODO May be, is not necessary fields in this class
		
	}
	public int getNivel() {
		return nivel;
	}
	public List<Horario> getHorarios(){
		return horarios;
	}

}
