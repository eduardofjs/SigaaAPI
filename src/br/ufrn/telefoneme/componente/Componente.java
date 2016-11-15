package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.Semestre;

/**
 * 
 * @author Marciel Leal
 * @category Template
 */
public abstract class Componente {
	private final boolean obrigatoria;
	private final Integer nivel;
	private final String codigo;
	private final String nome;
	private final List<Componente> subComponente;
	private final List<Horario> horarios;//TODO repensar: tentar criar uma classe Turma que tenha um componente e uma lista de hoarios
	
	private final List<EstatisticasTurmasDTO> estatisticas;
	
	public Componente(boolean obrigatoria, Integer nivel,String codigo,String nome){
		this.obrigatoria=obrigatoria;
		this.nivel=nivel;
		this.codigo = codigo;
		this.nome = nome;
		this.subComponente=new ArrayList<>();
		this.estatisticas=new ArrayList<>();
		this.horarios=new ArrayList<>();
	}
	//TODO Adicionar horarios em todos os componentes nos metodos filhos
	public abstract boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos);
	
	public List<EstatisticasTurmasDTO> getestatisticas() {
		return estatisticas;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNivel() {
		return nivel;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Componente){
			Componente comp=(Componente) o;
			if(this.codigo.equals(comp.getCodigo())){
				return true;
				//TODO Realmente so por codigo da certo?
			}
		}return false;
	}
	public List<Componente> getSubComponente() {
		return subComponente;
	}
	public boolean isObrigatoria() {
		return obrigatoria;
	}
	
}
