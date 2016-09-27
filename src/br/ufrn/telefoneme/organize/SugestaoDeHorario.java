package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Marciel Leal
 *
 */
public class SugestaoDeHorario {
	private final List<TabelaDeHorarios> tabelas;
	
	public SugestaoDeHorario(){
		this.tabelas=new ArrayList<>();
	}

	public List<TabelaDeHorarios> getTabelas() {
		return tabelas;
	}
	
}
