package br.ufrn.telefoneme.connection;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

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

    private static String getDados(String urlIntermediaria, int complemento){
    	return getDadosAux(urlIntermediaria,Integer.toString(complemento));
    }
    
    private static String getDados(String urlIntermediaria, String complemento){
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
     */
    private static String getDadosAux(String urlIntermediaria, String complemento){
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
            HttpURLConnection resource_cxn;
            if(complemento.isEmpty())
            	resource_cxn = (HttpURLConnection)(new URL(RESOURCE_URL_TPL + urlIntermediaria).openConnection());
            else
            	resource_cxn = (HttpURLConnection)(new URL(RESOURCE_URL_TPL + urlIntermediaria + "/" + complemento).openConnection());
            resource_cxn.addRequestProperty("Authorization", "Bearer " + token);

            InputStream resource = resource_cxn.getInputStream();
            
            BufferedReader r = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
            String line = null;

            while ((line = r.readLine()) != null) {
                resultJson += line;
            }

        } catch (Exception exn) {
            exn.printStackTrace();
        }

        return resultJson;
    }
    

    public static String getEstruturaCurricular(){
    	return getDados("/curso-services/services/consulta/curso/GRADUACAO","");
    }
    
    public static String getMatrizCurricular(Integer idCurso){
        return getDados("/curso-services/services/consulta/curso/matriz/graduacao",idCurso);	
    }
    
    public static String getComponentes(Integer idCurriculo){
        return getDados("/curso-services/services/consulta/curso/componentes",idCurriculo);
    }
}