package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConnectionException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * 
 * @author Marciel Leal
 *
 */
public class ComponenteFactory {

	public ComponenteFactory() {
		//Emmpty
	}

	public Componente geraNovoComponente(ComponenteCurricularDTO componente, Long idCurriculo) throws CargaHorariaDesconhecidaException, IdException, JsonStringInvalidaException, ConnectionException {
		List<ComponenteCurricularDTO> prerequisitos = new StringToComponente().getComponentes(componente.getPreRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> corequisitos = new StringToComponente().getComponentes(componente.getCoRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> subComponentes=componente.getComponentesBloco();
		
		List<Componente> prerequisitosConvertidos=new ArrayList<>();
		List<Componente> corequisitosConvertidos=new ArrayList<>();
		
		//TODO Muita memooria, criando basicamente um grafo
		if(!prerequisitos.isEmpty()){
			for(ComponenteCurricularDTO prereq:prerequisitos){
				prerequisitosConvertidos.add(geraNovoComponente(prereq,idCurriculo));
			}
		}if(!corequisitos.isEmpty()){
			for(ComponenteCurricularDTO coreq:corequisitos){
				corequisitosConvertidos.add(geraNovoComponente(coreq,idCurriculo));
			}
		}
		
		if(subComponentes!=null){
			if(!subComponentes.isEmpty()){
				List<Componente> subComponentesConvertidos=new ArrayList<>();
				for(ComponenteCurricularDTO sub:subComponentes){
					subComponentesConvertidos.add(geraNovoComponente(sub, idCurriculo));
				}			
				Componente novo= this.getComponente(componente,prerequisitosConvertidos,corequisitosConvertidos);
				novo.getSubComponente().addAll(subComponentesConvertidos);
				return novo;
			}
		}
		
		return getComponente(componente,prerequisitosConvertidos,corequisitosConvertidos);
	}
	
	private Componente getComponente(ComponenteCurricularDTO componente,List<Componente> prerequisitosConvertidos,List<Componente> corequisitosConvertidos) throws CargaHorariaDesconhecidaException{
		if (componente != null) {
			switch (componente.getCargaHorariaTotal()) {
			case 30:
				return new Componente30h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 60:
				return new Componente60h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 75:
				return new Componente75h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 90:
				return new Componente90h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 120:
				return new Componente120h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 180:
				return new Componente180h(componente.getSemetreOferta(),componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			default:
				throw new CargaHorariaDesconhecidaException("Carga Horária de: " + componente.getCargaHorariaTotal());
			}
		}return null;
	}

}
