package br.ufrn.telefoneme.conversion;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import exception.JsonStringInvalidaException;

public class JsonToObject {
	
	public static ArrayList<CursoDTO> toCursoDTO(String text) throws JsonStringInvalidaException{
		ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    cursos.add(new CursoDTO(jsonList.getInt("idCurso"),
                            jsonList.getString("curso"),
                            jsonList.getString("coordenador"),
                            jsonList.getString("nivel"),
                            jsonList.getString("unidade"),
                            jsonList.getString("municipio")
                            ));
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage(),e.getCause());
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

                    componentesCurriculares.add(new ComponenteCurricularDTO(jsonList.getString("codigo"),
                    		jsonList.getString("nome"),
                    		jsonList.getBoolean("disciplinaObrigatoria"),
                    		jsonList.getInt("semestreOferta")));
                }


            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage(),e.getCause());
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

                    matrizesCurriculares.add(new MatrizCurricularDTO(jsonList.getLong("idCurriculo"),
                    		jsonList.getString("codigo"),
                    		jsonList.getString("nome"),
                    		jsonList.getInt("ano"),
                    		jsonList.getInt("periodo"),
                    		jsonList.getString("municipio"),
                    		jsonList.getString("grauAcademico"),
                    		jsonList.getString("modalidade"),
                    		jsonList.getString("turno"),
                    		jsonList.getString("enfase"),
                    		jsonList.getInt("chTotalMin"),
                    		jsonList.getInt("chOptativasMin"),
                    		jsonList.getInt("chComplementarMin"),
                    		jsonList.getInt("semestreConclusaoMin"),
                    		jsonList.getInt("semestreConclusaoIdeal"),
                    		jsonList.getInt("semestreConclusaoMax"),
                    		jsonList.getInt("creditosMinSemestre"),
                    		jsonList.getInt("creditosMaxSemestre"),
                    		jsonList.getInt("creditosIdealSemestre"),
                    		jsonList.getBoolean("ativo")));
                }

            } catch (JSONException e) {
            	throw new JsonStringInvalidaException(e.getMessage(),e.getCause());
            }
        }else{
        	throw new JsonStringInvalidaException("String vazia!");
        }
        return matrizesCurriculares;
    }
	
}
