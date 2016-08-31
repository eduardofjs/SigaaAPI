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

    /**
     * Request a fresh access token using the given client ID, client secret, and token request URL,
     * then request the resource at the given resource URL using that access token, and get the resource
     * content.  If an exception is thrown, print the stack trace instead.
     *
     * @param unidade Unidade que se quer saber os telefones
     */

    public static String getTelefones(String unidade){
        String resultJson = "";
        String urlIntermediaria = "/telefone-services/services/consulta/telefone/";
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
                    (HttpURLConnection)(new URL(RESOURCE_URL_TPL + urlIntermediaria + unidade).openConnection());
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
    
    /**
     * Request a fresh access token using the given client ID, client secret, and token request URL,
     * then request the resource at the given resource URL using that access token, and get the resource
     * content.  If an exception is thrown, print the stack trace instead.
     *
     * @param unidade Unidade que se quer saber os telefones
     */

    public static String getEstruturaCurricular(){
        String resultJson = "";
        String urlIntermediaria = "/curso-services/services/consulta/curso/GRADUACAO";
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
                    (HttpURLConnection)(new URL(RESOURCE_URL_TPL + urlIntermediaria).openConnection());
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
}