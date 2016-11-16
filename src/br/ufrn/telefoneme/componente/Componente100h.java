package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.TabelaDeNivel;

public class Componente100h extends Componente {

	public Componente100h(Integer nivel, String codigo, String nome, boolean obrigatoria) {
		super(nivel,codigo, nome,obrigatoria);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(TabelaDeNivel semestre, List<Horario> horariosPrerequisitos) {
		// TODO Auto-generated method stub
		return false;
	}

}
