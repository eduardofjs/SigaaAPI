import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.dto.ComponenteCurricularDTO;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = OltuJavaClient.getEstruturaCurricular();
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
                e.printStackTrace();
            }
        }
        
        for(CursoDTO curso : cursos){
        	if(curso.getCurso().equals("TECNOLOGIA DA INFORMAÇÃO"))
        		System.out.println(curso.getIdCurso());
        	System.out.println(curso.getCurso());
        }
        
        text = OltuJavaClient.getMatrizCurricular(2131244);
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
                e.printStackTrace();
            }
        }
        
        for(MatrizCurricularDTO matrizCurricular : matrizesCurriculares){
        	System.out.println(matrizCurricular.getNome());
        }
        
        text = OltuJavaClient.getComponentes(12);
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
                e.printStackTrace();
            }
        }else
        	System.out.println("ERRO");
        if(!componentesCurriculares.isEmpty())
        	System.out.println(componentesCurriculares.get(0).getNome());
        
	}
}
