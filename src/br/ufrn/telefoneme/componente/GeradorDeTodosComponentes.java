package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class GeradorDeTodosComponentes extends GeradorDeComponentes {

	public GeradorDeTodosComponentes() {
		// TODO Auto-generated constructor stub
	}
	public List<Componente> listComponenteBuilder(AbstractConnection connection, Long idCurriculo,Integer semestre) 
			throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException{
		
		List<Componente> lista=new ArrayList<>();
		for(ComponenteCurricularDTO componente:FachadaDeDados.getInstance().getComponentes(connection, idCurriculo)){
			if(componente.isObrigatoria()&&componente.getSemetreOferta()==semestre){
				//If para problema dos subcomponentes
				if(componente.getComponentesBloco().isEmpty())
					lista.add(componenteBuilder(connection, idCurriculo,componente));
				else {
					for(ComponenteCurricularDTO subComponente: componente.getComponentesBloco()){
						lista.add(componenteBuilder(connection, idCurriculo,subComponente));
					}
				}
			}
		}
		return lista;
	}
}
