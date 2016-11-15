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
public class Componente90h extends Componente {

	public Componente90h(Integer nivel, String codigo, String nome,boolean obrigatoria) {
		super(nivel,codigo, nome,obrigatoria);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos) {
		// TODO Auto-generated method stub
		Dia segunda = new Dia(2);
		for(Horario horario : semestre.getHorarios()){
			if(horario.getDia().equals(segunda)){
				for(int horarioDoDia = 1; horarioDoDia <= horario.getTurno().getNumHorariosNoDia(); horarioDoDia++){
					if(horario.getHorarioDoDia().equals(horarioDoDia) && horario.isLivre()){
						if(horariosPrerequisitos==null){
							for(int i = 2; i < 7; i+=2){
								horario.setDia(new Dia(i));
								horario.setHorarioDoDia(horarioDoDia);
								semestre.getTabela().replace(horario, this);
								horario.setHorarioDoDia(horarioDoDia+1);
								semestre.getTabela().replace(horario, this);
							}
							return true;
						}
						else{
							for(Horario horarioPrerquisito : horariosPrerequisitos){
								if(semestre.getComponente(horarioPrerquisito).equals(null)){
									for(int i = 2; i < 7; i+=2){
										horario.setDia(new Dia(i));
										horario.setHorarioDoDia(horarioDoDia);
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
			}
		}
		return false;
	}


}
