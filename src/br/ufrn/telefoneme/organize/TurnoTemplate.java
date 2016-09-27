package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 * @category Decorator
 */
public abstract class TurnoTemplate implements Turno{
	
	private final TurnoTemplate outroturno;
	
	public TurnoTemplate(TurnoTemplate turno){
		this.outroturno=turno;
		
	}
	public TurnoTemplate(){
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
