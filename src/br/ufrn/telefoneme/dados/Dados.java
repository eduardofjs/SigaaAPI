package br.ufrn.telefoneme.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ExtracaoServidorException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class Dados {
	
	String text = "";
	
	public List<CursoDTO> getCursos(){
		try {
			text = OltuJavaClient.getCursos();
		} catch (ExtracaoServidorException e) {
			e.printStackTrace();
		}
        ArrayList<CursoDTO> cursos=new ArrayList<>();
		try {
			cursos = JsonToObject.toCursoDTO(text);
		} catch (JsonStringInvalidaException e1) {
			e1.printStackTrace();
		}
        
        return cursos;
	}
	
	public List<MatrizCurricularDTO> getMatrizes(Integer idCurso) throws IdException{
		try {
			text = OltuJavaClient.getMatrizCurricular(idCurso);
		} catch (ExtracaoServidorException e) {
			e.printStackTrace();
		}
        ArrayList<MatrizCurricularDTO> cursos=new ArrayList<>();
		try {
			cursos = JsonToObject.toMatrizCurricularDTO(text);
		} catch (JsonStringInvalidaException e1) {
			e1.printStackTrace();
		}
        
        return cursos;
	}
	
}
