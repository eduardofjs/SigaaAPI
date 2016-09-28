package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.SugestaoDeHorario;
import br.ufrn.telefoneme.organize.Semestre;

/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente180h extends Componente {
	private final Integer numHorarios=12;
	
	public Componente180h(Integer nivel, String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(nivel,codigo, nome, prerequisitos, corequisitos);
	}


	@Override
	public boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos) {
		if(horariosDePre)
		return false;
	}

}
