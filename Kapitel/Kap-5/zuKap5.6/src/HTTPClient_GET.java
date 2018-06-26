import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPClient_GET {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://angewnwt.hof-university.de/example-1.php");
		
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		System.out.println(response.getStatusLine());
		
		HttpEntity entity = response.getEntity();
		InputStream netzwerkStream = entity.getContent();
		InputStreamReader netzwerkStreamReader = new InputStreamReader(netzwerkStream);
		BufferedReader bufNeRd = new BufferedReader(netzwerkStreamReader);
		
		String geleseneZeile;
		while((geleseneZeile = bufNeRd.readLine()) != null) {
			System.out.println(geleseneZeile);
		}
		
		EntityUtils.consume(entity);
		response.close();
	}
}