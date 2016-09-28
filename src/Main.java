import java.util.ArrayList;
import java.util.List;

import br.ufrn.telefoneme.auxiliarhorario.Dia;
import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.conversion.JsonToObject;
import br.ufrn.telefoneme.dados.FachadaDeDados;
import br.ufrn.telefoneme.dto.AvaliacaoInstitucionalDocenteDTO;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.dto.UnidadeAcademicaDTO;
import br.ufrn.telefoneme.exception.CargaHorariaDesconhecidaException;
import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;
import br.ufrn.telefoneme.organize.Horario;
import br.ufrn.telefoneme.organize.Semestre;
import br.ufrn.telefoneme.organize.SugestaoDeHorario;

public class Main {

	public static void main(String[] args) throws IdException, JsonStringInvalidaException, ConexaoException, CargaHorariaDesconhecidaException {
		String text="";
		/*
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
		System.out.println("CURSOS DE GRADUAï¿½ï¿½O DA UFRN\n");
        for(CursoDTO curso : cursos){
        	System.out.println(curso.getCurso());
        }
		System.out.println("--------------------------------------------");
*/
        try {
			text = OltuJavaClient.getMatrizCurricular(92127264);
		} catch (IdException | ConexaoException e) {
			e.printStackTrace();
		}
        ArrayList<MatrizCurricularDTO> matrizesCurriculares=new ArrayList<>();
		try {
			matrizesCurriculares = JsonToObject.toMatrizCurricularDTO(text);
		} catch (JsonStringInvalidaException e1) {
			e1.printStackTrace();
		}
		System.out.println("MATRIZES CURRICULARES DO CURSO DE TECNOLOGIA DA INFORMAï¿½ï¿½O\n");
        Dia segunda = new Dia(2);
		for(MatrizCurricularDTO matrizCurricular : matrizesCurriculares){
        	if(matrizCurricular.getAtivo()){
        		List<ComponenteCurricularDTO> componentes = new ArrayList<ComponenteCurricularDTO>();
        		ComponenteCurricularDTO componente = new ComponenteCurricularDTO();
        		componente.setCodigo("IMD0019");
        		componente.setCargaHorariaTotal(180);
        		componente.setNome("RESOLUÇÃO DE PROBLEMAS MATEMÁTICOS PARA TI");
        		componente.setSemetreOferta(1);
        		componente.setObrigatoria(true);
        		componentes.add(componente);
//        		SugestaoDeHorario sugestao = new SugestaoDeHorario(matrizCurricular, FachadaDeDados.getInstance().getComponentes(matrizCurricular.getIdCurriculo()));
        		SugestaoDeHorario sugestao = new SugestaoDeHorario(matrizCurricular, componentes);
        		for(Semestre semestre : sugestao.getSugestao()){
        			for(Horario horario : semestre.getHorariosPeloDia(segunda)){
        				System.out.println("Segunda" + horario.getHorarioDoDia() + ": " + semestre.getComponente(horario).getNome());
        			}
        		}
        	}
        }
		System.out.println("--------------------------------------------");
        
/*
        try {
			text = OltuJavaClient.getComponentes(102200805);
		} catch (ConexaoException | IdException e) {
			e.printStackTrace();
		}
        ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();
		try {
			componentesCurriculares = JsonToObject.toComponenteCurricularDTO(text);
		} catch (JsonStringInvalidaException e) {
			e.printStackTrace();
		}
		
		System.out.println("ESTRUTURA CURRICULAR DA MATRIZ CURRICULAR DO CURSO DE TECNOLOGIA DA INFORMAï¿½ï¿½O - COMPUTAï¿½ï¿½O\n");
		for(ComponenteCurricularDTO componenteCurricular : componentesCurriculares){
        	if(componenteCurricular.isObrigatoria()==true&&componenteCurricular.getCargaHorariaTotal()==90&&componenteCurricular.getSemetreOferta()%2==0) 
        		System.out.println(componenteCurricular.getNome() + " - " + componenteCurricular.getCodigo() + " - " + componenteCurricular.getDepartamento());
		}

		System.out.println("--------------------------------------------");
        

        try {
			text = OltuJavaClient.getEstatisticas("GRADUACAO", "DIM0549");
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
		
		System.out.println("UNIDADES ACADï¿½MICAS COM O NOME PARECIDO COM INSTITUTO METRï¿½POLE DIGITAL\n");
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
		
		System.out.println("AVALIAï¿½ï¿½O INSTITUCIONAL DOS DOCENTES DO IMD EM 2015.2\n");
		for(AvaliacaoInstitucionalDocenteDTO avaliacaoInstitucionalDocente : avaliacaoInstitucionalDocentes){
        	System.out.println(avaliacaoInstitucionalDocente.getDocente() + " - " + avaliacaoInstitucionalDocente.getMediaGeral());
		}*/
	}
}
