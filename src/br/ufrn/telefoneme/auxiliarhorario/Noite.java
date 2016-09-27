package br.ufrn.telefoneme.auxiliarhorario;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Noite extends Turno {

	private final Integer numHorariosNoDia=6;
	
	public Noite(Turno turno) {
		super(turno);
	}
	public Noite(){
		super();
	}
	
	@Override
	public String toString(){
		if(getOutroturno()!=null)
			return "N"+getOutroturno().toString();
		return "N";
	}
	public Integer getNumHorariosNoDia() {
		return numHorariosNoDia;
	}


}
