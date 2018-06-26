import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Loes_Aufg_5_3 {

	public static void main(String[] args) throws ClientProtocolException, IOException {

				// URL, der die Authentifizierungsdaten uebergeben werden muessen
				String URLstr = "http://angewnwt.hof-university.de/login.php";
				
				// Mit POST nur Authentifizieren OHNE Abrufen der Webseite
		
				CloseableHttpClient httpclient = HttpClients.createDefault();
				CloseableHttpResponse response;
				 
				HttpPost httpPost = new HttpPost(URLstr);
				List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			    nvps.add(new BasicNameValuePair("username", "Hans"));
			    nvps.add(new BasicNameValuePair("password", "Wurscht"));
			    nvps.add(new BasicNameValuePair("submit", "anmelden"));
			    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			    response = httpclient.execute(httpPost);
			    System.out.println(response.getStatusLine()); // --> HTTP/1.1 200 OK
			    
			    // Mit GET jetzt Webseite abrufen (nun keine Authentifizierung mehr noetig, da vorher schon geschehen)
						
				HttpGet httpGet = new HttpGet(URLstr);
				response = httpclient.execute(httpGet);
				System.out.println(response.getStatusLine()); // --> HTTP/1.1 200 OK
				HttpEntity entity = response.getEntity();
				InputStream httpStream  = entity.getContent();
				InputStreamReader httpStreamReader = new InputStreamReader(httpStream);
			    BufferedReader httpBufferedReader = new BufferedReader(httpStreamReader);
						
				// empfangenen Text zeilenweise ausgeben
			    String httpLine;
				while((httpLine = httpBufferedReader.readLine()) != null) {
					System.out.println(httpLine);
				}
			    
				// Schliessen der Verbindung
				EntityUtils.consume(entity);
				response.close();
				httpBufferedReader.close();    
	}
}     
