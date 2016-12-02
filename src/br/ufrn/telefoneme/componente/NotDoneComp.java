package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

public class NotDoneComp implements Condition {
	private final List<ComponenteCurricularDTO> componentes;
	
	public NotDoneComp(List<ComponenteCurricularDTO> componentes) {
		this.componentes=componentes;
	}
	
	@Override
	public boolean compare(ComponenteCurricularDTO componente) {
		if(componente.isObrigatoria() && !componentes.contains(componente))
			return true;
		return false;
	}

}
