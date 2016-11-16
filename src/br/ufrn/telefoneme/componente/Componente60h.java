package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.TabelaDeNivel;

/**
 * 
 * @author Marciel Leal
 *
 */
public class Componente60h extends Componente {

	public Componente60h(Integer nivel, String codigo, String nome,boolean obrigatoria) {
		super(nivel,codigo, nome,obrigatoria);
	}

	@Override
	public boolean insereNaTabelaDeHorarios(TabelaDeNivel semestre, List<Horario> horariosPrerequisitos) {
		// TODO Auto-generated method stub
		Dia segunda = new Dia(2);
		Dia terca = new Dia(3);
		Dia quarta = new Dia(4);
		for(Horario horario : semestre.getHorarios()){
			if(horario.getDia().equals(segunda)){
				for(int horarioDoDia = 1; horarioDoDia < horario.getTurno().getNumHorariosNoDia(); horarioDoDia++){
					if(horario.getHorarioDoDia().equals(horarioDoDia) && horario.isLivre()){
						if(horariosPrerequisitos==null){
							for(int i = 2; i < 5; i+=2){
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
									for(int i = 2; i < 5; i+=2){
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
			if(horario.getDia().equals(terca)){
				for(int horarioDoDia = 1; horarioDoDia <= horario.getTurno().getNumHorariosNoDia(); horarioDoDia++){
					if(horario.getHorarioDoDia().equals(horarioDoDia) && horario.isLivre()){
						if(horariosPrerequisitos.equals(null)){
							for(int i = 3; i < 6; i+=2){
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
									for(int i = 3; i < 6; i+=2){
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
			if(horario.getDia().equals(quarta)){
				for(int horarioDoDia = 1; horarioDoDia <= horario.getTurno().getNumHorariosNoDia(); horarioDoDia++){
					if(horario.getHorarioDoDia().equals(horarioDoDia) && horario.isLivre()){
						if(horariosPrerequisitos.equals(null)){
							for(int i = 4; i < 7; i+=2){
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
									for(int i = 4; i < 7; i+=2){
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
