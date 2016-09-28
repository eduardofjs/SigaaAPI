package br.ufrn.telefoneme.dto;
/**
 * 
 * @author Joel Felipe
 *
 */
public class AvaliacaoInstitucionalDocenteDTO {
	
	private String docente;
	private String nomeComponente;
	private String codigoComponente;
	private String codigoTurma;
	private String horario;
	private Integer discente;
	private Double mediaGeral;
	private Double desvioPadraoGeral;
	
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
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
	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Integer getDiscente() {
		return discente;
	}
	public void setDiscente(Integer discente) {
		this.discente = discente;
	}
	public Double getMediaGeral() {
		return mediaGeral;
	}
	public void setMediaGeral(Double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}
	public Double getDesvioPadraoGeral() {
		return desvioPadraoGeral;
	}
	public void setDesvioPadraoGeral(Double desvioPadraoGeral) {
		this.desvioPadraoGeral = desvioPadraoGeral;
	}

}
