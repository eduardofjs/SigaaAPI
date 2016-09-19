package br.ufrn.telefoneme.connection;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import br.ufrn.telefoneme.exception.ExtracaoServidorException;
import br.ufrn.telefoneme.exception.IdException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Example of the OAuth client credentials flow using the Apache Oltu OAuth2 client.
 */
public class OltuJavaClient {
    /**
     * URL for requesting OAuth access tokens.
     */
    public static final String TOKEN_REQUEST_URL = "http://apitestes.info.ufrn.br/authz-server/oauth/token";

    /**
     * Client ID of your client credential.  Change this to match whatever credential you have created.
     */
    public static final String CLIENT_ID = "mobile-services-id";

    /**
     * Client secret of your client credential.  Change this to match whatever credential you have created.
     */
    public static final String CLIENT_SECRET = "segredo";

    public static final String RESOURCE_URL_TPL = "http://apitestes.info.ufrn.br";

    
    
    public static String getCursos() throws ExtracaoServidorException{
    	return getDados("/curso-services/services/consulta/curso/GRADUACAO","");
    }
    
    public static String getMatrizCurricular(Integer idCurso) throws ExtracaoServidorException,IdException{
    	if(idCurso < 0){
    		throw new IdException("ID menor que zero!");  
    	}
        return getDados("/curso-services/services/consulta/curso/matriz/graduacao",idCurso);	
    }
    
    public static String getComponentes(Integer idCurriculo) throws ExtracaoServidorException,IdException{
    	if(idCurriculo<0){
    		throw new IdException("ID menor que zero!"); 
    	}
    	return getDados("/curso-services/services/consulta/curso/componentes/detalhes",idCurriculo);
    }
    
    public static String getEstatísticas(String nivel, String codigo) throws ExtracaoServidorException{
    	return getDados("/ensino-services/services/consulta/turmas/estatisticas",nivel + "/" + codigo);
    }
    
    public static String getAvaliacaoInstitucionalDocente(Integer idUnidade, Integer ano, Integer periodo) throws ExtracaoServidorException,IdException{
    	if(idUnidade<0){
    		throw new IdException("ID menor que zero!"); 
    	}
    	return getDados("/ensino-services/services/consulta/avaliacaoInstitucional/docente",idUnidade + "/" + ano + "/" + periodo);
    }
    
    private static String getDados(String urlIntermediaria, int complemento) throws ExtracaoServidorException{
    	return getDadosAux(urlIntermediaria,Integer.toString(complemento));
    }
    
    private static String getDados(String urlIntermediaria, String complemento) throws ExtracaoServidorException{
    	return getDadosAux(urlIntermediaria,complemento);
    }
    /**
     * Request a fresh access token using the given client ID, client secret, and token request URL,
     * then request the resource at the given resource URL using that access token, and get the resource
     * content.  If an exception is thrown, print the stack trace instead.
     * 
     * @param urlIntermediaria
     * @param complemento
     * @return
     * @throws Exception 
     */
    private static String getDadosAux(String urlIntermediaria, String complemento) throws ExtracaoServidorException{
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
            }

        } catch (Exception exn) {
        	exn.printStackTrace();
            throw new ExtracaoServidorException("Problemas na obtenção de dados!",exn.getCause());
        }

        return resultJson;
    }
}