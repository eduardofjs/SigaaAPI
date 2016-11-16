package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;

public class Turma {
	//private Horario horario;
	private final Componente componente;
	private final int numTurma;
	private static Componente anterior;
	private static int numeroDeTurmas;
	
	public Turma(Componente componente) {
		this.componente=componente;
		if(anterior!=null){
			if(!anterior.equals(componente))
				numeroDeTurmas=0;
			numeroDeTurmas++;
			numTurma=numeroDeTurmas;
		}else {
			anterior=componente;
			numTurma=1;
		}
			 
	}

	public Componente getComponente() {
		return componente;
	}
	public static int getNumeroDeTurmas() {
		return numeroDeTurmas;
	}
	public int getNumTurma() {
		return numTurma;
	}
	public String toString(){
		return componente.getNome()+"-"+this.numTurma+"\n";
	}

}
