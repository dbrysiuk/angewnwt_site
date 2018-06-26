import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Loes_Aufg_5_2a {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

				String URLstr = "http://angewnwt.hof-university.de/example-4.php";
		
				CloseableHttpClient httpclient = HttpClients.createDefault();
				
				HttpGet httpGet = new HttpGet(URLstr);
				CloseableHttpResponse response = httpclient.execute(httpGet);
				System.out.println(response.getStatusLine()); // --> HTTP/1.1 200 OK
				
				response = httpclient.execute(httpGet);
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