package br.ufrn.telefoneme.organize;

import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Manha extends Turno {
	private Integer numHorariosPorDiaNoTurno=6;

	public Manha(Turno turno) {
		super(turno);
	}
	public Manha(){
		//Empty
	}

	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana, numHorariosPorDiaNoTurno);
	}

}
