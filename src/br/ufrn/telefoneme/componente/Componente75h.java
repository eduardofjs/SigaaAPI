package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.Semestre;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente75h extends Componente {

	public Componente75h(Integer nivel, String codigo, String nome) {
		super(nivel,codigo, nome);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos) {
		// TODO Auto-generated method stub
		return false;
	}


}
