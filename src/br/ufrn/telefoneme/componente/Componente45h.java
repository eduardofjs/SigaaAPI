package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.TabelaDeHorarios;

/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente45h extends Componente {

	public Componente45h(String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(codigo, nome, prerequisitos, corequisitos);
	}

	@Override
	public void insereNaTabelaDeHorarios(TabelaDeHorarios tabela) {
		// TODO Auto-generated method stub
		
	}

}