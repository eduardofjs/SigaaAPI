package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Noite extends Turno {
	private final Integer numHorariosPorDiaNoTurno=4;

	public Noite(Turno turno) {
		super(turno);
	}
	public Noite(){
		//Empty
	}
	
	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana, numHorariosPorDiaNoTurno);
	}
	


}
