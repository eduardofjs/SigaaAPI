package br.ufrn.telefoneme.organize;

import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Tarde extends Turno {
	private Integer numHorariosPorDiaNoTurno=6;
	
	public Tarde(Turno turno) {
		super(turno);
	}
	public Tarde(){
		//Empty
	}
	
	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana,numHorariosPorDiaNoTurno);
	}

}
