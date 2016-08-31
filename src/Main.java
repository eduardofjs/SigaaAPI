import java.util.ArrayList;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import exception.ExtracaoServidorException;
import exception.IdException;
import exception.JsonStringInvalidaException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="";
		
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
        for(CursoDTO curso : cursos){
        	if(curso.getCurso().equals("TECNOLOGIA DA INFORMA��O"))
        		System.out.println(curso.getIdCurso());
        	System.out.println(curso.getCurso());
        }
        

        try {
			text = OltuJavaClient.getMatrizCurricular(2131244);
		} catch (ExtracaoServidorException | IdException e) {
			e.printStackTrace();
		}
        ArrayList<MatrizCurricularDTO> matrizesCurriculares=new ArrayList<>();
		try {
			matrizesCurriculares = JsonToObject.toMatrizCurricularDTO(text);
		} catch (JsonStringInvalidaException e1) {
			e1.printStackTrace();
		} 
        for(MatrizCurricularDTO matrizCurricular : matrizesCurriculares){
        	System.out.println(matrizCurricular.getNome());
        }
        

        try {
			text = OltuJavaClient.getComponentes(12);
		} catch (ExtracaoServidorException | IdException e) {
			e.printStackTrace();
		}
        ArrayList<ComponenteCurricularDTO> componentesCurriculares=new ArrayList<>();
		try {
			componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}
        
        if(!componentesCurriculares.isEmpty())
        	System.out.println(componentesCurriculares.get(0).getNome());
        
	}
}
