package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Marciel Leal
 *
 */
public class Manha extends Turno {
	private Integer numHorariosNoTurno=6;
	
	@Override
	public List<HorarioDoDia> getHorariosDoDia() {
		List<HorarioDoDia> horarios=new ArrayList<>();
		
		for(int i=1;i<=numHorariosNoTurno;i++){
			horarios.add(new HorarioDoDia(this, i));
		}
		if(this.getOutroturno()!=null){
			horarios.addAll(this.getOutroturno().getHorariosDoDia());
		}
		return horarios;
	}

}
