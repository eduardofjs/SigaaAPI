package br.ufrn.telefoneme.connection;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.telefoneme.dto.AvaliacaoInstitucionalDocenteDTO;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.EstatisticasTurmasDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.dto.UnidadeAcademicaDTO;
import br.ufrn.telefoneme.exception.JsonStringInvalidaException;

public class JsonToObject {
	private static final Integer limEst=2010;
	
	public static ArrayList<CursoDTO> toCursoDTO(String text) throws JsonStringInvalidaException{
		ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);
                    CursoDTO curso = new CursoDTO();
                    curso.setIdCurso(jsonList.getInt("idCurso"));
                    curso.setCurso(jsonList.getString("curso"));
                    if(!jsonList.get("coordenador").equals(null))
                    	curso.setCoordenador(jsonList.getString("coordenador"));
                    curso.setNivel(jsonList.getString("nivel"));
                    curso.setUnidade(jsonList.getString("unidade"));
                    curso.setMunicipio(jsonList.getString("municipio"));
                    
                    cursos.add(curso);
                }


            } catch (JSONException e) {
            	System.out.println(e.getMessage());
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return cursos;
    }
	
	public static ArrayList<ComponenteCurricularDTO> toComponenteCurricularDTO(String text) throws JsonStringInvalidaException{
		ArrayList<ComponenteCurricularDTO> componentesCurriculares = new ArrayList<>();        
        
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);
                    List<ComponenteCurricularDTO> componentesBloco = new ArrayList<ComponenteCurricularDTO>();
                    if(!jsonList.isNull("componentesBloco")){
                    	componentesBloco = toComponenteCurricularDTO(jsonList.getJSONArray("componentesBloco").toString());
                    }
                    
                    ComponenteCurricularDTO componenteCurricular = new ComponenteCurricularDTO();
                    componenteCurricular.setCodigo(jsonList.getString("codigo"));
                    componenteCurricular.setNome(jsonList.getString("nome"));
                    componenteCurricular.setObrigatoria(jsonList.getBoolean("disciplinaObrigatoria"));
                    componenteCurricular.setSemetreOferta(jsonList.getInt("semestreOferta"));
                    componenteCurricular.setDepartamento(jsonList.getString("departamento"));
                    componenteCurricular.setCargaHorariaTotal(jsonList.getInt("cargaHorariaTotal"));
                    
                    if(!jsonList.get("preRequisitos").equals(null))
                    	componenteCurricular.setPreRequisitos(jsonList.getString("preRequisitos"));
                    if(!jsonList.get("coRequisitos").equals(null))
                        componenteCurricular.setCoRequisitos(jsonList.getString("coRequisitos"));
                    if(!jsonList.get("equivalentes").equals(null))
                        componenteCurricular.setEquivalentes(jsonList.getString("equivalentes"));
                    componenteCurricular.setComponentesBloco(componentesBloco);
                    
                    componentesCurriculares.add(componenteCurricular);
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return componentesCurriculares;
    }
	
	public static ArrayList<MatrizCurricularDTO> toMatrizCurricularDTO(String text) throws JsonStringInvalidaException{
		ArrayList<MatrizCurricularDTO> matrizesCurriculares = new ArrayList<MatrizCurricularDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    MatrizCurricularDTO matrizCurricular = new MatrizCurricularDTO();
                    matrizCurricular.setIdCurriculo(jsonList.getLong("idCurriculo"));
                    matrizCurricular.setCodigo(jsonList.getString("codigo"));
                    matrizCurricular.setNome(jsonList.getString("nome"));
                    matrizCurricular.setAno(jsonList.getInt("ano"));
                    matrizCurricular.setPeriodo(jsonList.getInt("periodo"));
                    matrizCurricular.setMunicipio(jsonList.getString("municipio"));
                    matrizCurricular.setGrauAcademico(jsonList.getString("grauAcademico"));
                    matrizCurricular.setModalidade(jsonList.getString("modalidade"));
                    matrizCurricular.setTurno(jsonList.getString("turno"));
                    if(!jsonList.get("enfase").equals(null))
                    	matrizCurricular.setEnfase(jsonList.getString("enfase"));
                    matrizCurricular.setChTotalMin(jsonList.getInt("chTotalMin"));
                    matrizCurricular.setChOptativasMin(jsonList.getInt("chOptativasMin"));
                    matrizCurricular.setChComplementarMin(jsonList.getInt("chComplementarMin"));
                    matrizCurricular.setSemestreConclusaoMin(jsonList.getInt("semestreConclusaoMin"));
                    matrizCurricular.setSemestreConclusaoIdeal(jsonList.getInt("semestreConclusaoIdeal"));
                    matrizCurricular.setSemestreConclusaoMax(jsonList.getInt("semestreConclusaoMax"));
                    matrizCurricular.setCreditosMinSemestre(jsonList.getInt("creditosMinSemestre"));
                    matrizCurricular.setCreditosMaxSemestre(jsonList.getInt("creditosMaxSemestre"));
                    matrizCurricular.setCreditosIdealSemestre(jsonList.getInt("creditosIdealSemestre"));
                    matrizCurricular.setAtivo(jsonList.getBoolean("ativo"));
                    
                    matrizesCurriculares.add(matrizCurricular);
                }

            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return matrizesCurriculares;
    }
	
	public static ArrayList<AvaliacaoInstitucionalDocenteDTO> toAvaliacaoInstitucionalDocenteDTO(String text) throws JsonStringInvalidaException{
		ArrayList<AvaliacaoInstitucionalDocenteDTO> avaliacaoInstitucionalDocentes = new ArrayList<AvaliacaoInstitucionalDocenteDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    AvaliacaoInstitucionalDocenteDTO avaliacaoInstitucionalDocente = new AvaliacaoInstitucionalDocenteDTO();
                    avaliacaoInstitucionalDocente.setDocente(jsonList.getString("docente"));
                    avaliacaoInstitucionalDocente.setNomeComponente(jsonList.getString("nomeComponente"));
                    avaliacaoInstitucionalDocente.setCodigoComponente(jsonList.getString("codigoComponente"));
                    avaliacaoInstitucionalDocente.setCodigoTurma(jsonList.getString("codigoTurma"));
                    avaliacaoInstitucionalDocente.setHorario(jsonList.getString("horario"));
                    avaliacaoInstitucionalDocente.setDiscente(jsonList.getInt("discentes"));
                    avaliacaoInstitucionalDocente.setMediaGeral(jsonList.getDouble("mediaGeral"));
                    avaliacaoInstitucionalDocente.setDesvioPadraoGeral(jsonList.getDouble("desvioPadraoGeral"));
                            
                    avaliacaoInstitucionalDocentes.add(avaliacaoInstitucionalDocente);
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return avaliacaoInstitucionalDocentes;
    }
	
	public static ArrayList<EstatisticasTurmasDTO> toEstatisticasTurmasDTO(String text) throws JsonStringInvalidaException{
		ArrayList<EstatisticasTurmasDTO> estatisticasTurmas = new ArrayList<EstatisticasTurmasDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                EstatisticasTurmasDTO estatisticasTurma=null;
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    estatisticasTurma = new EstatisticasTurmasDTO();
                    estatisticasTurma.setAno(jsonList.getInt("ano"));
                    if(estatisticasTurma.getAno().equals(limEst)) 
                    	break;
                    estatisticasTurma.setPeriodo(jsonList.getInt("periodo"));
                    estatisticasTurma.setCodigo(jsonList.getString("codigo"));
                    estatisticasTurma.setNomeComponente(jsonList.getString("nomeComponente"));
                    estatisticasTurma.setCodigoComponente(jsonList.getString("codigoComponente"));
                    estatisticasTurma.setAprovados(jsonList.getInt("aprovados"));
                    estatisticasTurma.setReprovados(jsonList.getInt("reprovados"));
                    estatisticasTurma.setTrancados(jsonList.getInt("trancados"));
                    estatisticasTurma.setMatriculados(jsonList.getInt("matriculados"));
                    
                    estatisticasTurmas.add(estatisticasTurma);
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return estatisticasTurmas;
    }
	
	public static ArrayList<UnidadeAcademicaDTO> toUnidadeAcademicaDTO(String text) throws JsonStringInvalidaException{
		ArrayList<UnidadeAcademicaDTO> unidadesAcademica = new ArrayList<UnidadeAcademicaDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    UnidadeAcademicaDTO unidadeAcademica = new UnidadeAcademicaDTO();
                    unidadeAcademica.setCodigoUnidade(jsonList.getLong("codigoUnidade"));
                    unidadeAcademica.setNomeUnidade(jsonList.getString("nomeUnidade"));
                    unidadeAcademica.setNivelOrganizacional(jsonList.getString("nivelOrganizacional"));
                    unidadeAcademica.setClassificacaoUnidade(jsonList.getString("classificacaoUnidade"));
                    unidadeAcademica.setEmail(jsonList.getString("email"));
                    unidadeAcademica.setTelefones(jsonList.getString("telefones"));
                    
                    unidadesAcademica.add(unidadeAcademica);
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return unidadesAcademica;
    }
	
}
