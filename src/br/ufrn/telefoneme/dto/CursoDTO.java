package br.ufrn.telefoneme.dto;

/**
 * @author Joel Felipe
 *
 */

public class CursoDTO {
	
	private Integer idCurso;
	private String curso;	
	private String coordenador;
	private String nivel;
	private String unidade;
	private String municipio;

	public Integer getIdCurso() {
		return idCurso;
	}
		
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}	
}
