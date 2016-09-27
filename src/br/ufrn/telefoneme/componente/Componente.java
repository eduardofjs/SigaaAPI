package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.organize.TabelaDeHorarios;

/**
 * 
 * @author Marciel Leal
 * Strategy
 */
public abstract class Componente {
	private final String codigo;
	private final String nome;
	//TODO ComponentesBloco
	private final List<Componente> prerequisitos;
	private final List<Componente> corequisitos;
	
	public Componente(String codigo,String nome,List<Componente> prerequisitos,List<Componente> corequisitos){
		this.codigo = codigo;
		this.nome = nome;
		this.prerequisitos=(prerequisitos==null)?new ArrayList<Componente>():prerequisitos;
		this.corequisitos=(prerequisitos==null)?new ArrayList<Componente>():corequisitos;
	}
	
	public abstract void insereNaTabelaDeHorarios(TabelaDeHorarios tabela);
	
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
	
	
}
