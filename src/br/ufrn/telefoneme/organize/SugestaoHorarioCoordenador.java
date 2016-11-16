package br.ufrn.telefoneme.organize;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.componente.Componente;
import br.ufrn.telefoneme.componente.Componente30h;
import br.ufrn.telefoneme.componente.Turma;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class SugestaoHorarioCoordenador extends SugestaoDeHorario {

	public SugestaoHorarioCoordenador(List<Turma> turmas,AbstractConnection connection,MatrizCurricularDTO matriz, String turno,
			List<ComponenteCurricularDTO> componentesDaGrade)
			throws IdException, JsonStringInvalidaException, CargaHorariaDesconhecidaException, ConnectionException {
		super(turmas, connection, matriz, turno, componentesDaGrade);
		// TODO Auto-generated constructor stub
	}
	public List<TabelaDeNivel> getSugestao() {
		Componente c= new Componente30h(null, null, null, false);
		return new ArrayList<TabelaDeNivel>();
	}

}
