package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * 
 * @author Marciel Leal
 * @category Template
 */
public abstract class GeradorDeComponentes {
	
	public GeradorDeComponentes() {
		//Empty
	}
	//protected abstract boolean condition(ComponenteCurricularDTO componente);
	/**
	 * Gera a lista de componentes considerando subcomponentes como componentes
	 * @param connection
	 * @param idCurriculo
	 * @param semestre
	 * @return
	 * @throws JsonStringInvalidaException
	 * @throws ConnectionException
	 * @throws IdException
	 * @throws CargaHorariaDesconhecidaException
	 */
	public List<Componente> listComponenteBuilder(AbstractConnection connection, Long idCurriculo,Condition condicao) 
			throws JsonStringInvalidaException, ConnectionException, IdException, CargaHorariaDesconhecidaException{
		
		List<Componente> lista=new ArrayList<>();
		for(ComponenteCurricularDTO componente:FachadaDeDados.getInstance().getComponentes(connection, idCurriculo)){
			if(condicao.compare(componente)){
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
	protected Componente componenteBuilder(AbstractConnection connection, Long idCurriculo,
			ComponenteCurricularDTO componente)
			throws CargaHorariaDesconhecidaException, IdException, JsonStringInvalidaException, ConnectionException {
		
		List<ComponenteCurricularDTO> prerequisitos = new StringToComponente().getComponentes(connection, componente.getPreRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> correquisitos = new StringToComponente().getComponentes(connection, componente.getCoRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> subComponentes=componente.getComponentesBloco();
		List<EstatisticasTurmasDTO> estatisticas=FachadaDeDados.getInstance().getEstatisticas(connection,"GRADUACAO", componente.getCodigo());
		
		Componente convComp=curricToComponente(componente);
		
		addPrerequisitos(convComp, prerequisitos);
		addCorrequisitos(convComp, correquisitos);
		addSubComponentes(convComp, subComponentes);
		
		if(estatisticas!=null)
			if(!estatisticas.isEmpty())
				convComp.getEstatisticas().addAll(estatisticas);
		
		return convComp;
	}
	
	protected void addPrerequisitos(Componente componente, List<ComponenteCurricularDTO> prerequisitos) throws CargaHorariaDesconhecidaException{
		if(prerequisitos!=null){
			if(!prerequisitos.isEmpty()){
				List<Componente> prerequisitosConvertidos=new ArrayList<>();
				for(ComponenteCurricularDTO preOrig:prerequisitos){
					prerequisitosConvertidos.add(curricToComponente(preOrig));
				}
				componente.getPrerequisitos().addAll(prerequisitosConvertidos);
			}
		}
	}
	
	protected void addCorrequisitos(Componente componente, List<ComponenteCurricularDTO> correquisitos) throws CargaHorariaDesconhecidaException{
		if(correquisitos!=null){
			if(!correquisitos.isEmpty()){
				List<Componente> correquisitosConvertidos=new ArrayList<>();
				for(ComponenteCurricularDTO corOrig:correquisitos){
					correquisitosConvertidos.add(curricToComponente(corOrig));
				}
				componente.getCorrequisitos().addAll(correquisitosConvertidos);
			}
		}
	}
	
	protected void addSubComponentes(Componente componente, List<ComponenteCurricularDTO> subComponentes) throws CargaHorariaDesconhecidaException{
		if(subComponentes!=null){
			if(!subComponentes.isEmpty()){
				List<Componente> subComponentesConvertidos=new ArrayList<>();
				for(ComponenteCurricularDTO subOrig:subComponentes){
					subComponentesConvertidos.add(curricToComponente(subOrig));
				}
				componente.getSubComponente().addAll(subComponentesConvertidos);
			}
		}
	}
	
	
	protected Componente curricToComponente(ComponenteCurricularDTO componente) throws CargaHorariaDesconhecidaException{
		if (componente != null) {
			switch (componente.getCargaHorariaTotal()) {
			case 30:
				return new Componente30h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 60:
				return new Componente60h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 75:
				return new Componente75h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 90:
				return new Componente90h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 100:
				return new Componente100h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 120:
				return new Componente120h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			case 180:
				return new Componente180h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(), componente.isObrigatoria());
			default:
				throw new CargaHorariaDesconhecidaException("Carga Horária de: " + componente.getCargaHorariaTotal());
			}
		}return null;
	}

}
