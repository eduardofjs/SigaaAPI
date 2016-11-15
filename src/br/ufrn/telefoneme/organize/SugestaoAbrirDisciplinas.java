package br.ufrn.telefoneme.organize;

import java.util.List;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.GraphComponenteFactory;
import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class SugestaoAbrirDisciplinas {
	private AbstractConnection connection = new APIConnection();
	
	public void gerarSugestao(Integer periodoRecomendado) throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException{
		List<Componente> componentes = new GraphComponenteFactory().listBuilder(connection, (long) 102200805);
		Integer periodo = periodoRecomendado % 2;
		for(Componente componente : componentes){
			if(componente.getNivel() % 2 == periodo){
				System.out.print(componente.getNome() + " - ");
				Double totalPorcentagem = 0.0;
				Integer totalTurmas = 0;
				Integer totalAlunos = 0;
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
				Double provaveisReprovados = totalPorcentagem * totalAlunos;
				System.out.println("QTD prevista de reprovados: " + provaveisReprovados);
			}
		}
		
	}
}
