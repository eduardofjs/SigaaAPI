package br.ufrn.telefoneme.dto;
/**
 * 
 * @author Joel Felipe
 *
 */
public class EstatisticasTurmasDTO {
	
	private Integer ano;
	private Integer periodo;
	private String codigo;
	private String nomeComponente;
	private String codigoComponente;
	private Integer aprovados;
	private Integer reprovados;
	private Integer trancados;
	private Integer matriculados;
	
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
	public void setMatriculados(Integer matriculados) {
		this.matriculados=matriculados;
	}
	public Integer getMatriculados() {
		return matriculados;
	}
	
	/*--------------------------------------------*/
	public Integer getTotalAlunos(){
		if(matriculados==0)
			return this.aprovados+this.reprovados+this.trancados;
		else
			return this.matriculados;
	}
	public Integer getTotalRetidos(){
		if(matriculados==0)
			return this.reprovados+this.trancados;
		else return 0;
	}
	public Double getPercentualRetencao(){
		if(this.matriculados==0)
			return (((double)this.getTotalRetidos())/(double)this.getTotalAlunos());
		else
			return 0.0;
	}
	public Double getPercentualReprov(){
		if(this.matriculados==0)
			return ((double)this.reprovados/(double)this.getTotalAlunos());
		else
			return 0.0;
	}
	public Double getPercentualTrancados(){
		if(this.matriculados==0)
			return ((double)this.trancados/(double)this.getTotalAlunos());
		else
			return 0.0;
	}
	
	@Override
	public String toString(){
		return this.getCodigoComponente()+"->"+this.getAno()+"."+this.getPeriodo()
				+"\n"+
				"A: "+this.getAprovados()+"\n"+
				"R: "+this.getReprovados()+"\n"+
				"T: "+this.getTrancados()+"\n"+
				"M: "+this.getMatriculados()+"\n"+
				"TT: "+this.getTotalAlunos()+"\n"+
				"PR: "+this.getPercentualRetencao()+"%\n";
	}
}
