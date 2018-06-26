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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HTTPClient_POST {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();		
		HttpPost httpPost = new HttpPost("http://angewnwt.hof-university.de/login.php");
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("username","Hans"));
		nvps.add(new BasicNameValuePair("password", "Wurscht"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		
		CloseableHttpResponse response = httpClient.execute(httpPost);
		
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