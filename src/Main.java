import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.dto.CursoDTO;
import br.ufrn.telefoneme.dto.MatrizCurricularDTO;
import br.ufrn.telefoneme.dto.TelefoneDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = OltuJavaClient.getTelefones("imd");
        ArrayList<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        if(!text.equalsIgnoreCase("")){
            try {
                JSONArray array = new JSONArray(text);
                for(int i = 0; i < array.length(); ++i){
                    JSONObject jsonList = array.getJSONObject(i);

                    telefones.add(new TelefoneDTO(jsonList.getString("numero"),
                            jsonList.getString("descricao"),
                            jsonList.getString("localizacao"),
                            jsonList.getString("setor")));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        
        for(TelefoneDTO telefone : telefones){
        	System.out.println(telefone.getNumero());
        }
        
        text = OltuJavaClient.getEstruturaCurricular();
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
	}
}
