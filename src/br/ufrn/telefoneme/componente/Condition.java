package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

public abstract class Condition {
	protected final List<ComponenteCurricularDTO> componentes;
	public Condition(){
		this.componentes=new ArrayList<>();
	}
	public Condition(List<ComponenteCurricularDTO> componentes){
		this.componentes=componentes;
	}
	public abstract boolean compare(ComponenteCurricularDTO componente);
}
