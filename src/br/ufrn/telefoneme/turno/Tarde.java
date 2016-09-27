package br.ufrn.telefoneme.turno;

import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Tarde extends Turno {
	private final Integer numHorariosNoDia=6;
	
	public Tarde(Turno turno) {
		super(turno);
	}
	public Tarde(){
		super();
	}
	
	@Override
	public String toString(){
		if(getOutroturno()!=null)
			return "T"+getOutroturno().toString();
		return "T";
	}
	public Integer getNumHorariosNoDia() {
		return numHorariosNoDia;
	}

}
