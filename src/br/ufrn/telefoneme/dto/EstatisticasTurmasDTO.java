package br.ufrn.telefoneme.dto;

public class EstatisticasTurmasDTO {
	
	private Integer ano;
	private Integer periodo;
	private String codigo;
	private String nomeComponente;
	private String codigoComponente;
	private Integer aprovados;
	private Integer reprovados;
	private Integer trancados;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNomeComponente() {
		return nomeComponente;
	}
	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
	public String getCodigoComponente() {
		return codigoComponente;
	}
	public void setCodigoComponente(String codigoComponente) {
		this.codigoComponente = codigoComponente;
	}
	public Integer getAprovados() {
		return aprovados;
	}
	public void setAprovados(Integer aprovados) {
		this.aprovados = aprovados;
	}
	public Integer getReprovados() {
		return reprovados;
	}
	public void setReprovados(Integer reprovados) {
		this.reprovados = reprovados;
	}
	public Integer getTrancados() {
		return trancados;
	}
	public void setTrancados(Integer trancados) {
		this.trancados = trancados;
	}
	
}
