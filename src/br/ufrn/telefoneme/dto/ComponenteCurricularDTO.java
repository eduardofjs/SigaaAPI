package br.ufrn.telefoneme.dto;

/**
 * 
 * @author Marciel Leal
 *
 */

public class ComponenteCurricularDTO {
	
	private String codigo;
	private String nome;
	private boolean isObrigatoria;
	private int semetreOferta;
	
	/**
	 * @param codigo
	 * @param nome
	 * @param isObrigatoria
	 * @param semetreOferta
	 */
	public ComponenteCurricularDTO(String codigo, String nome, boolean isObrigatoria, int semetreOferta) {
		this.codigo = codigo;
		this.nome = nome;
		this.isObrigatoria = isObrigatoria;
		this.semetreOferta = semetreOferta;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the isObrigatoria
	 */
	public boolean isObrigatoria() {
		return isObrigatoria;
	}
	/**
	 * @param isObrigatoria the isObrigatoria to set
	 */
	public void setObrigatoria(boolean isObrigatoria) {
		this.isObrigatoria = isObrigatoria;
	}
	/**
	 * @return the semetreOferta
	 */
	public int getSemetreOferta() {
		return semetreOferta;
	}
	/**
	 * @param semetreOferta the semetreOferta to set
	 */
	public void setSemetreOferta(int semetreOferta) {
		this.semetreOferta = semetreOferta;
	}
}