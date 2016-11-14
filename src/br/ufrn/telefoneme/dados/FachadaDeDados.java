package br.ufrn.telefoneme.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
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
	
	private FachadaDeDados(){
		//Empty
	}
	
	public static FachadaDeDados getInstance(){
		return instance;
	}
	
	public List<CursoDTO> getCursos() throws JsonStringInvalidaException, ConexaoException{
		String text = new APIConnection().getCursos();
        ArrayList<CursoDTO> cursos=new ArrayList<>();		
		cursos = JsonToObject.toCursoDTO(text);
        
        return cursos;
	}
	
	public List<MatrizCurricularDTO> getMatrizes(Integer idCurso) throws IdException, ConexaoException, JsonStringInvalidaException{
		String text = new APIConnection().getMatrizCurricular(idCurso);

		ArrayList<MatrizCurricularDTO> cursos=new ArrayList<>();
		cursos = JsonToObject.toMatrizCurricularDTO(text);
        
        return cursos;
	}
	
	public List<ComponenteCurricularDTO> getComponentes(Long idCurriculo) throws ConexaoException, IdException, JsonStringInvalidaException{
		String text = new APIConnection().getComponentes(idCurriculo);

        ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();
        componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
        
		return componentesCurriculares;
	}
	public List<EstatisticasTurmasDTO> getEstatisticas(String nivel,String codigoComponente) throws ConexaoException, JsonStringInvalidaException{
		String text=new APIConnection().getEstatisticas(nivel, codigoComponente);
		
		ArrayList<EstatisticasTurmasDTO> estatisticas=new ArrayList<>();
		estatisticas=JsonToObject.toEstatisticasTurmasDTO(text);
		
		return estatisticas;
	}
}
