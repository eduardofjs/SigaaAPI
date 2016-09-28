package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.SugestaoDeHorario;
import br.ufrn.telefoneme.organize.Semestre;

/**
 * 
 * @author Marciel Leal
 * @category Template
 */
public abstract class Componente {
	private final Integer nivel;
	private final String codigo;
	private final String nome;
	//TODO ComponentesBloco
	private final List<Componente> prerequisitos;
	private final List<Componente> corequisitos;
	private final List<Horario> horarios;//TODO repensar: tentar criar uma classe Turma que tenha um componente e uma lista de hoarios
	
	public Componente(Integer nivel,String codigo,String nome,List<Componente> prerequisitos,List<Componente> corequisitos){
		this.nivel=nivel;
		this.codigo = codigo;
		this.nome = nome;
		this.prerequisitos=(prerequisitos==null)? new ArrayList<Componente>():prerequisitos;
		this.corequisitos=(prerequisitos==null)? new ArrayList<Componente>():corequisitos;
		this.horarios=new ArrayList<>();
	}
	//TODO Adicionar horarios em todos os componentes nos metodos filhos
	public abstract boolean insereNaTabelaDeHorarios(Semestre sugestao, List<Horario> horariosPrerequisitos);
	
	public List<Componente> getPrerequisitos() {
		return prerequisitos;
	}

	public List<Componente> getCorequisitos() {
		return corequisitos;
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
	
}
