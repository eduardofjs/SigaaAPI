package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.Semestre;

/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente180h extends Componente {
	
	public Componente180h(Integer nivel, String codigo, String nome, List<Componente> prerequisitos, List<Componente> corequisitos) {
		super(nivel,codigo, nome, prerequisitos, corequisitos);
	}


	@Override
	public boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos) {
		Dia segunda = new Dia(2);
		for(Horario horario : semestre.getHorarios()){
			if(horario.getDia().equals(segunda)){
				for(int horarioDoDia = 1; horarioDoDia <= horario.getTurno().getNumHorariosNoDia(); horarioDoDia++){
					if(horario.getHorarioDoDia().equals(horarioDoDia) && horario.isLivre()){
						if(horariosPrerequisitos.equals(null)){
							for(int i = 2; i < 7; i+=2){
								horario.setDia(new Dia(i));
								horario.setHorarioDoDia(horarioDoDia);
								semestre.getTabela().replace(horario, this);
								horario.setHorarioDoDia(horarioDoDia+1);
								semestre.getTabela().replace(horario, this);
								horario.setHorarioDoDia(horarioDoDia+1);
								semestre.getTabela().replace(horario, this);
								horario.setHorarioDoDia(horarioDoDia+1);
								semestre.getTabela().replace(horario, this);
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
