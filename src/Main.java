import java.util.ArrayList;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.exception.ExtracaoServidorException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

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
		System.out.println("CURSOS DE GRADUA플O DA UFRN\n");
        for(CursoDTO curso : cursos){
        	System.out.println(curso.getCurso());
        }
		System.out.println("--------------------------------------------");

        try {
			text = OltuJavaClient.getMatrizCurricular(92127264);
		} catch (ExtracaoServidorException | IdException e) {
			e.printStackTrace();
		}
        ArrayList<MatrizCurricularDTO> matrizesCurriculares=new ArrayList<>();
		try {
			matrizesCurriculares = JsonToObject.toMatrizCurricularDTO(text);
		} catch (JsonStringInvalidaException e1) {
			e1.printStackTrace();
		}
		System.out.println("MATRIZES CURRICULARES DO CURSO DE TECNOLOGIA DA INFORMA플O\n");
        for(MatrizCurricularDTO matrizCurricular : matrizesCurriculares){
        	if(matrizCurricular.getAtivo())
        		System.out.println(matrizCurricular.getNome() + " - " + matrizCurricular.getEnfase() + " - " + matrizCurricular.getTurno() + " - " + matrizCurricular.getIdCurriculo());
        }
		System.out.println("--------------------------------------------");
        

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
		
		System.out.println("ESTRUTURA CURRICULAR DA MATRIZ CURRICULAR DO CURSO DE TECNOLOGIA DA INFORMA플O - COMPUTA플O\n");
		for(ComponenteCurricularDTO componenteCurricular : componentesCurriculares){
        	System.out.println(componenteCurricular.getNome());
		}
        
	}
}
