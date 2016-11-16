package br.ufrn.telefoneme.componente;

public class Turma {
	//private Horario horario;
	private final Componente componente;
	private int numTurma;
	private int numeroDeTurmas;
	
	public Turma(Componente componente, int numeroDeTurmas) {
		this.componente=componente;
		this.numeroDeTurmas = numeroDeTurmas;
			 
	}

	public Componente getComponente() {
		return componente;
	}
	public int getNumeroDeTurmas() {
		return numeroDeTurmas;
	}
	public int getNumTurma() {
		return numTurma;
	}
	public String toString(){
		return componente.getNome()+"-"+this.numeroDeTurmas+"\n";
	}

}
