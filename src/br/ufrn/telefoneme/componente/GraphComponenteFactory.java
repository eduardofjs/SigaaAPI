package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.util.Graph;

/**
 * 
 * @author Marciel Leal
 *
 */
public class GraphComponenteFactory {

	public GraphComponenteFactory() {
		//Emmpty
	}
	
	public Graph<Componente> componenteBuilder(AbstractConnection connection, Long idCurriculo) 
			throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException{
		
		Graph<Componente> graph=new Graph<>();
		for(ComponenteCurricularDTO componente: FachadaDeDados.getInstance().getComponentes(connection, idCurriculo)){
			
			graph.addVertex(this.getComponente(componente),);
		}
	}
	
	public Componente geraNovoComponente(AbstractConnection connection, ComponenteCurricularDTO componente, Long idCurriculo) throws CargaHorariaDesconhecidaException, IdException, JsonStringInvalidaException, ConnectionException {
		List<ComponenteCurricularDTO> prerequisitos = new StringToComponente().getComponentes(connection, componente.getPreRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> corequisitos = new StringToComponente().getComponentes(connection, componente.getCoRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> subComponentes=componente.getComponentesBloco();
		
		List<Componente> prerequisitosConvertidos=new ArrayList<>();
		List<Componente> corequisitosConvertidos=new ArrayList<>();
		
		//Subturmas
		if(subComponentes!=null){
			if(!subComponentes.isEmpty()){
				List<Componente> subComponentesConvertidos=new ArrayList<>();
				for(ComponenteCurricularDTO sub:subComponentes){
					subComponentesConvertidos.add(getComponente(sub));
				}			
				Componente novo= this.getComponente(componente);
				novo.getSubComponente().addAll(subComponentesConvertidos);
				return novo;
			}
		}
		
		return getComponente(componente);
	}
	
	private Componente getComponente(ComponenteCurricularDTO componente) throws CargaHorariaDesconhecidaException{
		if (componente != null) {
			switch (componente.getCargaHorariaTotal()) {
			case 30:
				return new Componente30h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			case 60:
				return new Componente60h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			case 75:
				return new Componente75h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			case 90:
				return new Componente90h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			case 120:
				return new Componente120h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			case 180:
				return new Componente180h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome());
			default:
				throw new CargaHorariaDesconhecidaException("Carga Horária de: " + componente.getCargaHorariaTotal());
			}
		}return null;
	}

}
