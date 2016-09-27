package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Manha extends TurnoTemplate {
	private Integer numHorariosPorDiaNoTurno=6;

	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana, numHorariosPorDiaNoTurno);
	}

}
