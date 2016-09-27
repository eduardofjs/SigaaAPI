package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.TabelaDeHorarios;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente75h extends Componente {

	public Componente75h(Integer nivel, String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(nivel,codigo, nome, prerequisitos, corequisitos);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(TabelaDeHorarios tabela) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
