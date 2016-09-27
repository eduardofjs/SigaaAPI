package br.ufrn.telefoneme.auxiliarhorario;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.organize.Horario;

/**
 * 
 * @author Marciel Leal
 *
 */
public class GeraTabelaDeTurno {

	public GeraTabelaDeTurno() {
		// TODO Auto-generated constructor stub
	}
	public List<Horario> getHorariosDoTurno(Semana semana,Turno turno){
		List<Horario> horarios=new ArrayList<>();
		
		while(turno!=null){
			for(Dia dia:semana.getDias()){
				for(int horarioDoDia=1;horarioDoDia<turno.getNumHorariosNoDia();horarioDoDia++){
					horarios.add(new Horario(dia, turno, horarioDoDia));
				}
			}turno=turno.getOutroturno();
		}
		return horarios; 
	}

}
