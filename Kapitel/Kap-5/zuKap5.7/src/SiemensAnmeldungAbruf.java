import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
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


// Demoprogramm für Anmeldung  am Siemens Webserver und Abruf des Zählerstandes
public class SiemensAnmeldungAbruf
{
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

		// HTTP-Client für die Abfragen erzeugen
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    
		
        //==========================
		// Anmelden durch POST des Passworts
		System.out.println("=====================\nPOST Login");
        HttpPost httpPost = new HttpPost("http://10.50.80.18/FormLogin.php");
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("Login", "student"));
        nvps.add(new BasicNameValuePair("Password", "geheim"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response1 = httpclient.execute(httpPost);

        System.out.println(response1.getStatusLine());
        HttpEntity entity1 = response1.getEntity();
    	// Antwort ist irrelevant und wird deswegen nicht gelesen
		EntityUtils.consume(entity1);
		response1.close();

		//===================
		// GET der benutzerdefinierten Webseite (nach Anmeldung)
		System.out.println("=====================\nGET nach Anmeldung");
		HttpGet httpGet = new HttpGet("http://10.50.80.18/awp/Zaehler/Zaehlerzusatz.html");
		
		response1 = httpclient.execute(httpGet);
		System.out.println(response1.getStatusLine());
		
		entity1 = response1.getEntity();
		InputStream httpStream  = entity1.getContent();
		InputStreamReader httpStreamReader = new InputStreamReader(httpStream);
		BufferedReader httpBufferedReader = new BufferedReader(httpStreamReader);

		// Zeile mit dem Zählerstand suchen
		String httpLine;
		while((httpLine = httpBufferedReader.readLine()) != null) {
			if(httpLine.contains("Zählerstand:"))
			{
				// die eigentlichen Ziffern aus der Zeile ausschneiden
				int startZaehler = httpLine.indexOf("Zählerstand:") + "Zählerstand:".length();
				int endeZaehler = httpLine.indexOf("</strong>") - 1;
				String standAlsString = httpLine.substring(startZaehler, endeZaehler);
				standAlsString = standAlsString.trim();
				// und in int umwandeln
				int zaehlerstand = Integer.parseInt(standAlsString);
				System.out.println("Zaehlerstand: " + zaehlerstand);
			}
		}
		httpBufferedReader.close();
		EntityUtils.consume(entity1);
		response1.close();
	}

}
