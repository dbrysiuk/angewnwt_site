package restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import restClient.Leistung;

public class RestClient {

	public static void main(String[] args) 
	{
		// URL des Servers
		String baseUrl   = "http://localhost:4434";
		// Name des Studenten, fuer den wir anfragen
		String name 		 = "Hannah Jung"; 

		// Relative Pfade auf dem Server
		String webContextPath = "/student";  
		String webContextUnderPath = "/leistung";
		
		Student student = new Student();
		student.matrikelNummer = -1;

		System.out.println( "\nAngefragte URL: " + baseUrl + webContextPath );

		// GSON Instanz fuer das Interpretieren der Antwort vom Server
		Gson gson = new GsonBuilder().create();
		
		// Jersey Client fuer das Abfragen des Servers erzeugen
		Client client = ClientBuilder.newClient();
		
		// Server abfragen: 1) Matrikelnummer zu Name
		// WebTarget erzeugen und richtigen Pfad angeben
		WebTarget target = client.target( baseUrl + webContextPath );
		// Parameter name anhaengen
		target = target.queryParam("name",name);
		// GET-Anfrage erzeugen
		Invocation invocation = target.request( MediaType.APPLICATION_JSON ).buildGet();
		// Anfrage an Server senden und JSON-String empfangen
		String jsonString = invocation.invoke(String.class );
		// JSON-String decodieren
		if(jsonString != null)
			student = gson.fromJson(jsonString, Student.class);
		
		if(student.matrikelNummer != -1)
		{
			System.out.println("\nStudent gefunden: " + student.matrikelNummer );
			
			// Server abfragen: 2) leistungen zur Matrikelnummer
			// WebTarget erzeugen und richtigen Pfad angeben
			target = client.target( baseUrl + webContextPath);
			// gefundene Matrikelnummer an Pfad anhaengen
			target = target.path( String.valueOf(student.matrikelNummer) );
			// Unterpfad /leistung an Pfad anhaengen
			target = target.path( webContextUnderPath );
			// GET-Anfrage erzeugen
			invocation = target.request( MediaType.APPLICATION_JSON ).buildGet();
			// Anfrag an Server senden und JSON-String empfangen
			jsonString = invocation.invoke(String.class );
			// JSON-String decodieren
			Leistung[] leistungen = gson.fromJson(jsonString, Leistung[].class);
			
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
