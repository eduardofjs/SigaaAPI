import java.util.ArrayList;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dto.AvaliacaoInstitucionalDocenteDTO;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.dto.UnidadeAcademicaDTO;
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
		System.out.println("CURSOS DE GRADUAÇÃO DA UFRN\n");
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
		System.out.println("MATRIZES CURRICULARES DO CURSO DE TECNOLOGIA DA INFORMAÇÃO\n");
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
		
		System.out.println("ESTRUTURA CURRICULAR DA MATRIZ CURRICULAR DO CURSO DE TECNOLOGIA DA INFORMAÇÃO - COMPUTAÇÃO\n");
		for(ComponenteCurricularDTO componenteCurricular : componentesCurriculares){
        	System.out.println(componenteCurricular.getNome() + " - " + componenteCurricular.getCodigo() + " - " + componenteCurricular.getDepartamento());
		}

		System.out.println("--------------------------------------------");
        

        try {
			text = OltuJavaClient.getEstatísticas("GRADUACAO", "DIM0549");
		} catch (ExtracaoServidorException e) {
			e.printStackTrace();
		}
        ArrayList<EstatisticasTurmasDTO> estatisticasTurmas = new ArrayList<>();
		try {
			estatisticasTurmas = JsonToObject.toEstatisticasTurmasDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}
		
		System.out.println("ESTATISTICAS DAS TURMAS DE GRAFOS\n");
		for(EstatisticasTurmasDTO estatisticaTurma : estatisticasTurmas){
        	System.out.println(estatisticaTurma.getAno() + "." + estatisticaTurma.getPeriodo() + " - " + (estatisticaTurma.getAprovados()+estatisticaTurma.getReprovados()) + " - " + estatisticaTurma.getAprovados());
		}
		
		System.out.println("--------------------------------------------");
        

        try {
			text = OltuJavaClient.getUnidadesAcademicas("INSTITUTO METROPOLE DIGITAL");
		} catch (ExtracaoServidorException e) {
			e.printStackTrace();
		}
        ArrayList<UnidadeAcademicaDTO> unidadesAcademica = new ArrayList<>();
		try {
			unidadesAcademica = JsonToObject.toUnidadeAcademicaDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}
		
		System.out.println("UNIDADES ACADÊMICAS COM O NOME PARECIDO COM INSTITUTO METRÓPOLE DIGITAL\n");
		for(UnidadeAcademicaDTO unidadeAcademica : unidadesAcademica){
        	System.out.println(unidadeAcademica.getNomeUnidade() + " - " + unidadeAcademica.getCodigoUnidade());
		}
		
		System.out.println("--------------------------------------------");
        

        try {
			text = OltuJavaClient.getAvaliacoesInstitucionaisDocentes(110005,2015,2);
		} catch (ExtracaoServidorException e) {
			e.printStackTrace();
		}
        ArrayList<AvaliacaoInstitucionalDocenteDTO> avaliacaoInstitucionalDocentes = new ArrayList<>();
		try {
			avaliacaoInstitucionalDocentes = JsonToObject.toAvaliacaoInstitucionalDocenteDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}
		
		System.out.println("AVALIAÇÃO INSTITUCIONAL DOS DOCENTES DO IMD EM 2015.2\n");
		for(AvaliacaoInstitucionalDocenteDTO avaliacaoInstitucionalDocente : avaliacaoInstitucionalDocentes){
        	System.out.println(avaliacaoInstitucionalDocente.getDocente() + " - " + avaliacaoInstitucionalDocente.getMediaGeral());
		}
	}
}
