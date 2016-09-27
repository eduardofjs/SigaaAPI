package br.ufrn.telefoneme.auxiliarhorario;

/**
 * 
 * @author Marciel Leal
 * @category Decorator
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
	public abstract Integer getNumHorariosNoDia();
}
