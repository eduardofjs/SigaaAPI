package br.ufrn.telefoneme.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.Connection;
import br.ufrn.telefoneme.connection.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

/**
 * 
 * @author Marciel Leal
 * @category Facade and Singleton
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
	
	public List<CursoDTO> getCursos() throws JsonStringInvalidaException, ConexaoException{

		text = Connection.getCursos();
        ArrayList<CursoDTO> cursos=new ArrayList<>();		
		cursos = JsonToObject.toCursoDTO(text);
        
        return cursos;
	}
	
	public List<MatrizCurricularDTO> getMatrizes(Integer idCurso) throws IdException, ConexaoException, JsonStringInvalidaException{
		text = Connection.getMatrizCurricular(idCurso);

		ArrayList<MatrizCurricularDTO> cursos=new ArrayList<>();
		cursos = JsonToObject.toMatrizCurricularDTO(text);
        
        return cursos;
	}
	
	public List<ComponenteCurricularDTO> getComponentes(Long idCurriculo) throws ConexaoException, IdException, JsonStringInvalidaException{
		text = Connection.getComponentes(idCurriculo.intValue());

        ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();
        componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
        
		return componentesCurriculares;
	}
	
}
