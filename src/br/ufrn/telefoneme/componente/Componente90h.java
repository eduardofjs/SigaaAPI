package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.SugestaoDeHorario;

/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente90h extends Componente {

	public Componente90h(Integer nivel, String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(nivel,codigo, nome, prerequisitos, corequisitos);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(SugestaoDeHorario sugestao) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
