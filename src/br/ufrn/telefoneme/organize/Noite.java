package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Noite extends TurnoTemplate {
	private final Integer numHorariosPorDiaNoTurno=4;

	@Override
	public List<Horario> getHorarios(Semana semana) {
		return builtHorarios(semana, numHorariosPorDiaNoTurno);
	}
	


}
