package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 * @category Decorator and Template
 */
public abstract class Turno {
	
	private final Turno outroturno;
	
	public Turno(Turno turno){
		this.outroturno=turno;
		
	}
	public Turno(){
		this.outroturno=null;
	}
	
	protected List<Horario> builtHorarios(Semana semana, Integer numHorariosNoTurno) {
		List<Horario> horarios = new ArrayList<>();
		
		for(Dia dia:semana.getDias()){
			for (int i = 1; i <= numHorariosNoTurno; i++) {
				horarios.add(new Horario(dia,this,i));
			}
		}
		if (this.outroturno != null) {
			horarios.addAll(this.outroturno.getHorarios(semana));
		}
		return horarios;
	}
	
	public abstract List<Horario> getHorarios(Semana semana);
	
}
