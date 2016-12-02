package br.ufrn.telefoneme.componente;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
//TODO Interface?
public interface Condition {

	public boolean compare(ComponenteCurricularDTO componente);
}
