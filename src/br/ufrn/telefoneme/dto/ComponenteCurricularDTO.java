package br.ufrn.telefoneme.dto;

import java.util.List;

/**
 * 
 * @author Joel Felipe
 *
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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof ComponenteCurricularDTO){
			ComponenteCurricularDTO comp= (ComponenteCurricularDTO)o;
			if(this.codigo.equals(comp.getCodigo())){
				return true;
			}
		}return false;
	}
}