package br.ufrn.telefoneme.turno;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Manha extends Turno {

	private final Integer numHorariosNoDia=6;
	
	public Manha(Turno turno) {
		super(turno);
	}
	public Manha(){
		super();
	}
	
	@Override
	public String toString(){
		if(getOutroturno()!=null)
			return "M"+getOutroturno().toString();
		return "M";
	}
	public Integer getNumHorariosNoDia() {
		return numHorariosNoDia;
	}

}
