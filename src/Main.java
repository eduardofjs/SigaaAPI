import java.util.ArrayList;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToClass;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text;
		
		text = OltuJavaClient.getEstruturaCurricular();
        ArrayList<CursoDTO> cursos = JsonToClass.toCursoDTO(text);
        for(CursoDTO curso : cursos){
        	if(curso.getCurso().equals("TECNOLOGIA DA INFORMAÇÃO"))
        		System.out.println(curso.getIdCurso());
        	System.out.println(curso.getCurso());
        }
        
        text = OltuJavaClient.getMatrizCurricular(2131244);
        ArrayList<MatrizCurricularDTO> matrizesCurriculares = JsonToClass.toMatrizCurricularDTO(text); 
        for(MatrizCurricularDTO matrizCurricular : matrizesCurriculares){
        	System.out.println(matrizCurricular.getNome());
        }
        
        text = OltuJavaClient.getComponentes(12);
        ArrayList<ComponenteCurricularDTO> componentesCurriculares = JsonToClass.toComponenteCurricularDTO(text);
        if(!componentesCurriculares.isEmpty())
        	System.out.println(componentesCurriculares.get(0).getNome());
        
	}
}
