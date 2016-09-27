package br.ufrn.telefoneme.organize;

import java.util.List;
/**
 * 
 * @author Marciel Leal
 * @category Decorator
 */
public abstract class Turno {
	
	private final Turno outroturno; 

	public Turno(Turno turno){
		this.outroturno=turno;
		
	}
	public Turno(){
		this.outroturno=null;
	}
	
	public Turno getOutroturno() {
		return outroturno;
	}
	
	
	public abstract List<HorarioDoDia> getHorariosDoDia();
	
	
}
