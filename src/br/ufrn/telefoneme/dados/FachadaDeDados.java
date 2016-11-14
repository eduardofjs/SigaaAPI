package br.ufrn.telefoneme.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.connection.APIConnection;
import br.ufrn.telefoneme.connection.AbstractConnection;
import br.ufrn.telefoneme.connection.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ConnectionException;
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
	
	public List<CursoDTO> getCursos(AbstractConnection connection) throws JsonStringInvalidaException, ConnectionException{
		String text = connection.getCursos("GRADUACAO");
        ArrayList<CursoDTO> cursos=new ArrayList<>();		
		cursos = JsonToObject.toCursoDTO(text);
        
        return cursos;
	}
	
	public List<MatrizCurricularDTO> getMatrizes(AbstractConnection connection,Integer idCurso) throws IdException, ConnectionException, JsonStringInvalidaException{
		String text = connection.getMatrizCurricular(idCurso);

		ArrayList<MatrizCurricularDTO> cursos=new ArrayList<>();
		cursos = JsonToObject.toMatrizCurricularDTO(text);
        
        return cursos;
	}
	
	public List<ComponenteCurricularDTO> getComponentes(AbstractConnection connection,Long idCurriculo) throws ConnectionException, IdException, JsonStringInvalidaException{
		String text = connection.getComponentes(idCurriculo);

        ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();
        componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
        
		return componentesCurriculares;
	}
	public List<EstatisticasTurmasDTO> getEstatisticas(AbstractConnection connection,String nivel,String codigoComponente) throws ConnectionException, JsonStringInvalidaException{
		String text=connection.getEstatisticas(nivel, codigoComponente);
		
		ArrayList<EstatisticasTurmasDTO> estatisticas=new ArrayList<>();
		estatisticas=JsonToObject.toEstatisticasTurmasDTO(text);
		
		return estatisticas;
	}
}
