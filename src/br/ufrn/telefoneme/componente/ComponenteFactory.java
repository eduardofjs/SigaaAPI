package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.conversion.StringToComponente;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
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

	public Componente geraNovoComponente(ComponenteCurricularDTO componente, int idCurriculo) throws CargaHorariaDesconhecidaException, IdException, JsonStringInvalidaException, ConexaoException {
		List<ComponenteCurricularDTO> prerequisitos = new StringToComponente().getComponentes(componente.getPreRequisitos(), idCurriculo);
		List<ComponenteCurricularDTO> corequisitos = new StringToComponente().getComponentes(componente.getCoRequisitos(), idCurriculo);
		
		List<Componente> prerequisitosConvertidos=new ArrayList<>();
		for(ComponenteCurricularDTO prereq:prerequisitos){
			prerequisitosConvertidos.add(geraNovoComponente(prereq,idCurriculo));
		}
		
		List<Componente> corequisitosConvertidos=new ArrayList<>();
		for(ComponenteCurricularDTO coreq:corequisitos){
			corequisitosConvertidos.add(geraNovoComponente(coreq,idCurriculo));
		}
		
		if (componente != null) {
			switch (componente.getCargaHorariaTotal()) {
			case 30:
				return new Componente30h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 45:
				return new Componente45h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 60:
				return new Componente60h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 75:
				return new Componente75h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 90:
				return new Componente90h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 120:
				return new Componente120h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			case 180:
				return new Componente180h(componente.getCodigo(), componente.getNome(),prerequisitosConvertidos,corequisitosConvertidos);
			default:
				throw new CargaHorariaDesconhecidaException("Carga Horária de: " + componente.getCargaHorariaTotal());
			}
		}
		return null;
		// TODO Lancar ou nao excecao?
	}
	

}
