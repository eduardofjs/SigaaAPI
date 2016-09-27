package br.ufrn.telefoneme.auxiliarhorario;

/**
 * 
 * @author Marciel Leal
 * @category Decorator and Template
 */
public abstract class Turno {
	
	private final Turno outroturno;
	
	public Turno(Turno turno){
		this.outroturno=turno;
		
	}
	public Turno(){
		this.outroturno=null;
	}
	
	public Turno getOutroturno() {
		return outroturno;
	}
	
}
