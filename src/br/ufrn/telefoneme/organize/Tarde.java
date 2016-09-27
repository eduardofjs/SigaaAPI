package br.ufrn.telefoneme.organize;

import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Tarde extends TurnoTemplate {

	private Integer numHorariosPorDiaNoTurno=6;
	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana,numHorariosPorDiaNoTurno);
	}

}
