package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
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
	private final List<Componente> prerequisitos;
	private final List<Componente> correquisitos;
	private final List<Componente> subComponente;
	private final List<Horario> horarios;//TODO repensar: tentar criar uma classe Turma que tenha um componente e uma lista de hoarios
	
	private final List<EstatisticasTurmasDTO> estatisticas;
	
	
	public Componente(Integer nivel,String codigo,String nome,boolean obrigatoria){
		this.nivel=nivel;
		this.codigo = codigo;
		this.nome = nome;
		this.obrigatoria=obrigatoria;
		this.subComponente=new ArrayList<>();
		this.correquisitos=new ArrayList<>();
		this.prerequisitos=new ArrayList<>();
		this.estatisticas=new ArrayList<>();
		this.horarios=new ArrayList<>();
	}
	//TODO Adicionar horarios em todos os componentes nos metodos filhos
	public abstract boolean insereNaTabelaDeHorarios(Semestre semestre, List<Horario> horariosPrerequisitos);
	
	public List<EstatisticasTurmasDTO> getEstatisticas() {
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
	public List<Componente> getSubComponente() {
		return subComponente;
	}
	public List<Componente> getCorrequisitos() {
		return correquisitos;
	}
	public boolean isObrigatoria() {
		return obrigatoria;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public List<Componente> getPrerequisitos() {
		return prerequisitos;
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
	public String toString(){
		return this.codigo+" "+this.nome+"\n";
	}
}
