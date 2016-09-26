package br.ufrn.telefoneme.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ExtracaoServidorException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * 
 * PS: Facade and Singleton
 * @author Marciel Leal
 *
 */
public class FachadaDeDados {
	private static FachadaDeDados instance=new FachadaDeDados();
	String text = "";
	
	private FachadaDeDados(){
		//Empty
	}
	
	public static FachadaDeDados getInstance(){
		return instance;
	}
	
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
	
	public List<ComponenteCurricularDTO> getComponentes(Integer idCurriculo){
		
		try {
			text = OltuJavaClient.getComponentes(102200805);
		} catch (ExtracaoServidorException | IdException e) {
			e.printStackTrace();
		}
        ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();
		try {
			componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}

		return componentesCurriculares;
	}
	
}
