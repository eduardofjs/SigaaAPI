package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;

public class Turma {
	private Horario horario;
	private final Componente componente;
	
	public Turma(Componente componente) {
		this.componente=componente;
	}

	public Componente getComponente() {
		return componente;
	}

}
