package br.ufrn.telefoneme.dto;

/**
 * 
 * @author Joel Felipe
 *
 */

public class MatrizCurricularDTO{
	
	private Long idCurriculo;
	
	private String codigo;
	
	private String nome;
	
	private Integer ano;
	
	private Integer periodo;
	
	private String municipio;
	
	private String grauAcademico;
	
	private String modalidade;
	
	private String turno;
	
	private String enfase;
	
	private Integer chTotalMin;
	
	private Integer chOptativasMin;
	
	private Integer chComplementarMin;
	
	private Integer semestreConclusaoMin;
	
	private Integer semestreConclusaoIdeal;
	
	private Integer semestreConclusaoMax;
	
	private Integer creditosMinSemestre;
	
	private Integer creditosMaxSemestre;
	
	private Integer creditosIdealSemestre;
	
	private Boolean ativo;
	
	public MatrizCurricularDTO(Long idCurriculo, String codigo, String nome, Integer ano, Integer periodo, String municipio, String grauAcademico, String modalidade, String turno, String enfase, Integer chTotalMin, Integer chOptativasMin, Integer chComplementarMin, Integer semestreConclusaoMin, Integer semestreConclusaoIdeal, Integer semestreConclusaoMax, Integer creditosMinSemestre, Integer creditosMaxSemestre, Integer creditosIdealSemestre, Boolean ativo){
		this.idCurriculo = idCurriculo;
		this.codigo = codigo;
		this.nome = nome;
		this.ano = ano;
		this.periodo = periodo;
		this.municipio = municipio;
		this.grauAcademico = grauAcademico;
		this.modalidade = modalidade;
		this.turno = turno;
		this.enfase = enfase;
		this.chTotalMin = chTotalMin;
		this.chOptativasMin = chOptativasMin;
		this.chComplementarMin = chComplementarMin;
		this.semestreConclusaoMin = semestreConclusaoMin;
		this.semestreConclusaoIdeal = semestreConclusaoIdeal;
		this.semestreConclusaoMax = semestreConclusaoMax;
		this.creditosMinSemestre = creditosMinSemestre;
		this.creditosMaxSemestre = creditosMaxSemestre;
		this.creditosIdealSemestre = creditosIdealSemestre;
		this.ativo = ativo;
    }

	public Long getIdCurriculo() {
		return idCurriculo;
	}
	
	public void setIdCurriculo(Long idCurriculo) {
		this.idCurriculo = idCurriculo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Integer getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	
	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getGrauAcademico() {
		return grauAcademico;
	}

	public void setGrauAcademico(String grauAcademico) {
		this.grauAcademico = grauAcademico;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEnfase() {
		return enfase;
	}

	public void setEnfase(String enfase) {
		this.enfase = enfase;
	}

	public Integer getChTotalMin() {
		return chTotalMin;
	}

	public void setChTotalMin(Integer chTotalMin) {
		this.chTotalMin = chTotalMin;
	}

	public Integer getChOptativasMin() {
		return chOptativasMin;
	}

	public void setChOptativasMin(Integer chOptativasMin) {
		this.chOptativasMin = chOptativasMin;
	}

	public Integer getChComplementarMin() {
		return chComplementarMin;
	}

	public void setChComplementarMin(Integer chComplementarMin) {
		this.chComplementarMin = chComplementarMin;
	}

	public Integer getSemestreConclusaoMin() {
		return semestreConclusaoMin;
	}

	public void setSemestreConclusaoMin(Integer semestreConclusaoMin) {
		this.semestreConclusaoMin = semestreConclusaoMin;
	}

	public Integer getSemestreConclusaoIdeal() {
		return semestreConclusaoIdeal;
	}

	public void setSemestreConclusaoIdeal(Integer semestreConclusaoIdeal) {
		this.semestreConclusaoIdeal = semestreConclusaoIdeal;
	}

	public Integer getSemestreConclusaoMax() {
		return semestreConclusaoMax;
	}

	public void setSemestreConclusaoMax(Integer semestreConclusaoMax) {
		this.semestreConclusaoMax = semestreConclusaoMax;
	}

	public Integer getCreditosMinSemestre() {
		return creditosMinSemestre;
	}

	public void setCreditosMinSemestre(Integer creditosMinSemestre) {
		this.creditosMinSemestre = creditosMinSemestre;
	}

	public Integer getCreditosMaxSemestre() {
		return creditosMaxSemestre;
	}

	public void setCreditosMaxSemestre(Integer creditosMaxSemestre) {
		this.creditosMaxSemestre = creditosMaxSemestre;
	}

	public Integer getCreditosIdealSemestre() {
		return creditosIdealSemestre;
	}

	public void setCreditosIdealSemestre(Integer creditosIdealSemestre) {
		this.creditosIdealSemestre = creditosIdealSemestre;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}	
}