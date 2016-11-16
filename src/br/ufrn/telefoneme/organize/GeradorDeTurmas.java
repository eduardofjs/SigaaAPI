package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.GeradorDeComponentes;
import br.ufrn.telefoneme.componente.Turma;
import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public abstract class GeradorDeTurmas {
	protected final int tamanhoDeSala=40;
	protected final int minTurma=5;
	/**
	 * 
	 * @param connection
	 * @param idCurriculo
	 * @param componentes
	 * @param periodoRecomendado 0 para os dois, 1 para periodos .1 e 2 para periodos .2
	 * @return
	 */
	public abstract List<Turma> gerar(List<Componente> componentes,Integer periodoRecomendado);
	
}