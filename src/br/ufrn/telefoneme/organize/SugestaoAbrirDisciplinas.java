package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.GraphComponenteFactory;
import br.ufrn.telefoneme.componente.Turma;
import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class SugestaoAbrirDisciplinas {
	/**
	 * 
	 * @param connection
	 * @param idCurriculo
	 * @param componentes
	 * @param periodoRecomendado 0 para os dois, 1 para periodos .1 e 2 para periodos .2
	 * @return
	 */
	public List<Turma> gerarSugestao(List<Componente> componentes,Integer periodoRecomendado) throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException{
		List<Turma> resultado=new ArrayList<>();
		List<EstatisticasTurmasDTO> estatisticasPreRequisito = new ArrayList<EstatisticasTurmasDTO>();
		double provaveisReprovados=0;
		double provaveisAprovadosPreRequisito=0;
		

		int periodo = periodoRecomendado % 2;
		double totalPorcentagem;
		int totalTurmas;
		int totalAlunos;
		int resultadoDeTurmas;
		
		for(Componente componente : componentes){
			totalPorcentagem = 0.0;
			totalTurmas = 0;
			totalAlunos = 0;
			
			if(componente.getNivel() % 2 == periodo||periodoRecomendado==0){
				for(EstatisticasTurmasDTO estatistica : componente.getEstatisticas()){
					if(estatistica.getMatriculados() > 0){
						totalAlunos += estatistica.getMatriculados();
					}
					else{
						totalPorcentagem += estatistica.getPercentualReprov();
						totalTurmas++;
					}
				}
				
				totalPorcentagem = totalPorcentagem/totalTurmas;
				provaveisReprovados = totalPorcentagem * totalAlunos;
				
				if(!componente.getPrerequisitos().isEmpty()){
					for(Componente componentePreRequisito : componente.getPrerequisitos()){						
						//TODO Não acho possivel, mas pode gerar exceção de ponteiro nulo, vide o metodo abaixo
						estatisticasPreRequisito=getPrerequisito(componentes,componentePreRequisito).getEstatisticas();
						Double totalPorcentagemPreRequisito = 0.0;
						Integer totalTurmasPreRequisito = 0;
						Integer totalAlunosPreRequisito = 0;
						for(EstatisticasTurmasDTO estatistica : estatisticasPreRequisito){
							if(estatistica.getMatriculados() > 0){
								totalAlunosPreRequisito += estatistica.getMatriculados();
							}
							else{
								totalPorcentagemPreRequisito += 1 - estatistica.getPercentualReprov();
								totalTurmasPreRequisito++;
							}
						}
						totalPorcentagemPreRequisito = totalPorcentagemPreRequisito/totalTurmasPreRequisito;
						provaveisAprovadosPreRequisito = totalPorcentagemPreRequisito * totalAlunosPreRequisito;
						
					}
				}
				
				resultadoDeTurmas=(int)provaveisAprovadosPreRequisito+(int)provaveisReprovados+2;
				for(int i=0;i<resultadoDeTurmas;i++)
					resultado.add(new Turma(componente));
			}
		}
		return resultado;
	}
	/**
	 * 
	 * @param componentes Lista de componentes da grade
	 * @param prerequisito Procurar esse prerequisito na grade
	 * @return O prerequisito
	 */
	private Componente getPrerequisito(List<Componente> componentes, Componente prerequisito){
		for(Componente componente:componentes){
			if(componente.equals(prerequisito)){
				return componente;
			}
		}
		return null; 
	}
}