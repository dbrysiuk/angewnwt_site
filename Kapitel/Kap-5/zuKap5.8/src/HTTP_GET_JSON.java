
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HTTP_GET_JSON {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// HTTP Client erzeugen
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// GET Request auf Server mit JSON-Datei
		HttpGet httpGet = new HttpGet("http://angewnwt.hof-university.de/Kap-3/JSON-Datei");

		CloseableHttpResponse response = httpClient.execute(httpGet);

		// Server-Meldung ausgeben
		System.out.println(response.getStatusLine());

		// Stream auf JSON-Datei erstellen
		HttpEntity entity = response.getEntity();
		InputStream httpStream = entity.getContent();
		
		InputStreamReader isr = new InputStreamReader(httpStream,"UTF-8");
		
		// HTTP-Stream durch GSON parsen lassen
		Student[] geleseneStudenten;
		Gson gson = new GsonBuilder().create();
		geleseneStudenten = gson.fromJson(isr,Student[].class);
		
		isr.close();
		httpStream.close();

		// gelesene Daten auf Konsole ausgeben
		String toWrite;
		if(geleseneStudenten != null) {
			toWrite = String.format("%d",geleseneStudenten.length );
			// Elemente mit ; und Leerzeichen trennen
			toWrite += "; ";
			// Text als Zeile schreiben
			toWrite += "\n";
			System.out.print(toWrite);
	
			for(int i=0; i < geleseneStudenten.length; i++) {
				// neuen Text beginnen
				toWrite = String.format("%d; %s; ",
						geleseneStudenten[i].matrikelNummer,
						geleseneStudenten[i].name);
				if(geleseneStudenten[i].leistungen != null) {
					// Text ergaenzen
					toWrite += String.format("%d; ",geleseneStudenten[i].leistungen.length);

					for(int j=0; j < geleseneStudenten[i].leistungen.length; j++) {
						toWrite += String.format("%s; %3.1f; ",
								geleseneStudenten[i].leistungen[j].modul,
								geleseneStudenten[i].leistungen[j].note);
					}
				}
				else
					toWrite += "0; ";
				// Text / Datensatz eines Studenten als Zeile ausgeben
				toWrite += "\n";
				System.out.print(toWrite);
			}
		}
		else
		{
			toWrite = "0; \n";
			System.out.print(toWrite);
		}
		
		// Aufraeumen
		EntityUtils.consume(entity);
		response.close();
	}

}
