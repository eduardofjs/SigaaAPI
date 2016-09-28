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
public class Componente45h extends Componente {

	public Componente45h(Integer nivel, String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(nivel,codigo, nome, prerequisitos, corequisitos);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(Semestre sugestao, List<Horario> horariosPrerequisitos) {
		// TODO Auto-generated method stub
		return false;
	}


}
