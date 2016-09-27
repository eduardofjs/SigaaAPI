package br.ufrn.telefoneme.organize;

public class HorarioDoDia {
	
	private final Turno turno;
	private final int numDoHorario;
	
	public HorarioDoDia(Turno turno,int numDoHorario){
		this.turno = turno;
		this.numDoHorario = numDoHorario;
	}
	
	public Turno getTurno() {
		return turno;
	}

	public int getNumDoHorario() {
		return numDoHorario;
	}

}
