import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufrn.telefoneme.connection.OltuJavaClient;
import br.ufrn.telefoneme.dto.TelefoneDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = OltuJavaClient.getResource("imd");
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
        
	}

}
