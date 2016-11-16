package br.ufrn.telefoneme.componente;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;

public class GeradorDeTodosComponentes extends GeradorDeComponentes {

	public GeradorDeTodosComponentes() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition(ComponenteCurricularDTO componente) {
		return true;
	}

}
