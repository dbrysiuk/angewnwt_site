
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RestClientHTTP {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {

		// GSON Instanz fuer das Interpretieren der Antwort vom Server
		Gson gson = new GsonBuilder().create();

		// HTTP Client fuer das Senden von HTTP Requests
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// URI aufbauen
		URIBuilder uriBuilder = new URIBuilder("http://localhost:4434/student/");
		uriBuilder.addParameter("name", "Mia Fischer");
		// GET Request auf Server
		HttpGet httpGet = new HttpGet(uriBuilder.build());
		CloseableHttpResponse response = httpClient.execute(httpGet);

		// Abholen der Antwort ueber einen StreamReader
		HttpEntity entity = response.getEntity();
		InputStreamReader httpStreamReader = new InputStreamReader(entity.getContent());

		// Parsen der Antwort mit GSON, Umwandeln in den von uns gewuenschten Typ
		Student student = new Student();
		student.matrikelNummer = -1;
		
		student = gson.fromJson(httpStreamReader, Student.class);

		// Aufraeumen 
		EntityUtils.consume(entity);
		response.close();

		if(student.matrikelNummer != -1)
		{
			// Student gefunden
			System.out.println("\nStudent gefunden: " + student.matrikelNummer);

			// URI aufbauen
			uriBuilder = new URIBuilder("http://localhost:4434/student/");
			uriBuilder = uriBuilder.setPath(uriBuilder.getPath() + Integer.toString(student.matrikelNummer));
			uriBuilder = uriBuilder.setPath(uriBuilder.getPath() + "/leistung");
			
			// GET Request auf unseren Server
			httpGet = new HttpGet(uriBuilder.build());
			response = httpClient.execute(httpGet);

			// Abholen der Antwort ueber einen StreamReader
			entity = response.getEntity();
			httpStreamReader = new InputStreamReader(entity.getContent());

			// Parsen der Antwort mit GSON, Umwandeln in den von uns gewuenschten Typ
			// JSON-String decodieren
			Leistung[] leistungen = gson.fromJson(httpStreamReader, Leistung[].class);

			// Aufraeumen 
			EntityUtils.consume(entity);
			response.close();

			System.out.println("\nLeistungen:" );
			for(Leistung l : leistungen)
			{
				System.out.println(l.modul + ": " + l.note);	
			}
		}
		else
		{
			System.out.println("\nKeinen Studenten gefunden!" );
		}
	}
}



