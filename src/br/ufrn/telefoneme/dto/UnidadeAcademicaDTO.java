package br.ufrn.telefoneme.dto;
/**
 * 
 * @author Joel Felipe
 *
 */
public class UnidadeAcademicaDTO {
	private Long codigoUnidade;
	private String nomeUnidade;
	private String nivelOrganizacional;	
	private String classificacaoUnidade;
	private String email;
	private String telefones;
	
	public Long getCodigoUnidade() {
		return codigoUnidade;
	}
	public void setCodigoUnidade(Long codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	public String getNivelOrganizacional() {
		return nivelOrganizacional;
	}
	public void setNivelOrganizacional(String nivelOrganizacional) {
		this.nivelOrganizacional = nivelOrganizacional;
	}
	public String getClassificacaoUnidade() {
		return classificacaoUnidade;
	}
	public void setClassificacaoUnidade(String classificacaoUnidade) {
		this.classificacaoUnidade = classificacaoUnidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefones() {
		return telefones;
	}
	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}
	
}
