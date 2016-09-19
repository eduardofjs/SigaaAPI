package br.ufrn.telefoneme.dto;

import java.util.List;

/**
 * 
 * @author Marciel Leal
 * @author Joel Felipe
 */

public class ComponenteCurricularDTO {
	
	private String codigo;
	private String nome;
	private boolean isObrigatoria;
	private int semetreOferta;
	private String departamento;
	private int cargaHorariaTotal;
	private String preRequisitos;
	private String coRequisitos;
	private String equivalentes;
	private List<ComponenteCurricularDTO> componentesBloco;
	
	/**
	 * @param codigo
	 * @param nome
	 * @param isObrigatoria
	 * @param semetreOferta
	 */
	public ComponenteCurricularDTO(String codigo, String nome, boolean isObrigatoria, int semetreOferta, String departamento, int cargaHorariaTotal, String preRequisitos, String coRequisitos, String equivalentes, List<ComponenteCurricularDTO> componentesBloco) {
		this.codigo = codigo;
		this.nome = nome;
		this.isObrigatoria = isObrigatoria;
		this.semetreOferta = semetreOferta;
		this.departamento = departamento;
		this.cargaHorariaTotal = cargaHorariaTotal;
		this.preRequisitos = preRequisitos;
		this.coRequisitos = coRequisitos;
		this.equivalentes = equivalentes;
		this.componentesBloco = componentesBloco;
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
	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	public void setCargaHorariaTotal(int cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	public String getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(String preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public String getCoRequisitos() {
		return coRequisitos;
	}
	public void setCoRequisitos(String coRequisitos) {
		this.coRequisitos = coRequisitos;
	}
	public String getEquivalentes() {
		return equivalentes;
	}
	public void setEquivalentes(String equivalentes) {
		this.equivalentes = equivalentes;
	}
	public List<ComponenteCurricularDTO> getComponentesBloco() {
		return componentesBloco;
	}
	public void setComponentesBloco(List<ComponenteCurricularDTO> componentesBloco) {
		this.componentesBloco = componentesBloco;
	}
}