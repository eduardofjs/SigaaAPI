package br.ufrn.telefoneme.connection;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import br.ufrn.telefoneme.exception.ConexaoException;
import br.ufrn.telefoneme.exception.IdException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Example of the OAuth client credentials flow using the Apache Oltu OAuth2 client.
 */
public class Connection {
    /**
     * URL for requesting OAuth access tokens.
     */
    public static final String TOKEN_REQUEST_URL = "https://apitestes.info.ufrn.br/authz-server/oauth/token";

    /**
     * Client ID of your client credential.  Change this to match whatever credential you have created.
     */
    public static final String CLIENT_ID = "mobile-services-id";

    /**
     * Client secret of your client credential.  Change this to match whatever credential you have created.
     */
    public static final String CLIENT_SECRET = "segredo";

    public static final String RESOURCE_URL_TPL = "https://apitestes.info.ufrn.br";

    
    public static String getTurmas(String string,String ano, String periodo) throws ConexaoException{
    	return getDados("/ensino-services/services/consulta/turmas/centro",string+"/"+ano+"/"+periodo);
    }
    
    public static String getCursos() throws ConexaoException{
    	return getDados("/curso-services/services/consulta/curso/GRADUACAO","");
    }
    
    public static String getMatrizCurricular(Integer idCurso) throws ConexaoException,IdException{
    	if(idCurso < 0){
    		throw new IdException("ID menor que zero!");  
    	}
        return getDados("/curso-services/services/consulta/curso/matriz/graduacao",idCurso);	
    }
    
    public static String getComponentes(Integer idCurriculo) throws ConexaoException,IdException{
    	if(idCurriculo<0){
    		throw new IdException("ID menor que zero!"); 
    	}
    	return getDados("/curso-services/services/consulta/curso/componentes/detalhes",idCurriculo);
    }
    
    public static String getEstatisticas(String nivel, String codigo) throws ConexaoException{
    	return getDados("/ensino-services/services/consulta/turmas/estatisticas",nivel + "/" + codigo);
    }
    
    public static String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo) throws ConexaoException,IdException{
    	if(idUnidade<0){
    		throw new IdException("ID menor que zero!"); 
    	}
    	return getDados("/ensino-services/services/consulta/avaliacaoInstitucional/docente",idUnidade + "/" + ano + "/" + periodo);
    }
    
    public static String getUnidadesAcademicas(String nome) throws ConexaoException{
    	return getDados("/unidades-services/services/consulta/unidade",nome);
    }
    
    public static String getAvaliacoesInstitucionaisDocentes(Integer codigoUnidade, Integer ano, Integer periodo) throws ConexaoException{
    	return getDados("/ensino-services/services/consulta/avaliacaoInstitucional/docente",codigoUnidade + "/" + ano + "/" + periodo);
    }
    
    private static String getDados(String urlIntermediaria, int complemento) throws ConexaoException{
    	return getDadosAux(urlIntermediaria,Integer.toString(complemento));
    }
    
    private static String getDados(String urlIntermediaria, String complemento) throws ConexaoException{
    	return getDadosAux(urlIntermediaria,complemento);
    }

    private static String getDadosAux(String urlIntermediaria, String complemento) throws ConexaoException{
        String resultJson = "";
        try {
            OAuthClient client = new OAuthClient(new URLConnectionClient());

            OAuthClientRequest request =
                    OAuthClientRequest.tokenLocation(TOKEN_REQUEST_URL)
                            .setGrantType(GrantType.CLIENT_CREDENTIALS)
                            .setClientId(CLIENT_ID)
                            .setClientSecret(CLIENT_SECRET)
                            .buildQueryMessage();

            String token =
                    client.accessToken(request, OAuthJSONAccessTokenResponse.class)
                            .getAccessToken();

            HttpURLConnection resource_cxn =
                    (HttpURLConnection)(new URL(RESOURCE_URL_TPL + urlIntermediaria + "/" + complemento).openConnection());
            resource_cxn.addRequestProperty("Authorization", "Bearer " + token);

            InputStream resource = resource_cxn.getInputStream();
            
            BufferedReader r = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
            String line = null;
            
            while ((line = r.readLine()) != null) {
            	resultJson += line;
            }System.out.println(RESOURCE_URL_TPL + urlIntermediaria + "/" + complemento);

        } catch (Exception exn) {
            System.out.println(exn.getMessage());
        	throw new ConexaoException();
        }

        return resultJson;
    }
}
