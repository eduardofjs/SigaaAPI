package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.Semestre;

/**
 * Sempre procura pares de horarios do tipo <impar, par>, nunca o contrario
 * @author Marciel Leal
 *
 */
public class Componente30h extends Componente {


	public Componente30h(Integer nivel, String codigo, String nome) {
		super(nivel,codigo, nome);
	}
/*
	@Override
	public boolean insereNaTabelaDeHorarios(TabelaDeHorarios tabela) {
		//TODO Testes com prerequisitos 
		for(int index=0;index<tabela.getHorarios().size()-1;index+=2){
			if(tabela.getHorarios().get(index).isLivre()&&tabela.getHorarios().get(index).isLivre()){
				if(this.getPrerequisitos().isEmpty()&&this.getCorequisitos().isEmpty()){
					tabela.getHorarios().get(index).ocupaHorario(this);
					return true;
				}else if(this.getPrerequisitos().isEmpty()){
					for(Componente correq:this.getCorequisitos()){
						if(!this.getNivel().equals(correq.getNivel())){
							
						}
					}
				}else if(this.getPrerequisitos().isEmpty()){
					
				}
			}
		}return false;
	}*/

	@Override
	public boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos) {
		
		return false;
	}

}
