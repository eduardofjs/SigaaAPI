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
	//TODO May be add/remove this fields after
	//private final Semana semana;
	//private final Turno
	
	public TabelaDeHorarios(int nivel, TurnoTemplate turno,Semana semana) {
		this.nivel=nivel;
		this.horarios=turno.getHorarios(semana);
	}
	public int getNivel() {
		return nivel;
	}
	public List<Horario> getHorarios(){
		return horarios;
	}

}
