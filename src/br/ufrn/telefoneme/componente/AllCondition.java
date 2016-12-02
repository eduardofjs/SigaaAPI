package br.ufrn.telefoneme.componente;

import java.util.List;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

public class AllCondition implements Condition {

	@Override
	public boolean compare(ComponenteCurricularDTO componente) {
		if(componente.isObrigatoria())
			return true;
		return false;
	}

}
