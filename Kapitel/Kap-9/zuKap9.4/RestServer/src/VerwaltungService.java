package restServer;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Path(VerwaltungService.webContextPath)
public class VerwaltungService 
{
	static final String webContextPath = "/student";
		
	// Funktion fuer Pfad 1 der Server-Sitemap: Namen und Matrikelnummern aller Studenten
	public String getListeVonStudenten() 
	{
		String ergebnisAlsJSON;
		
		System.out.println("getListeVonStudenten");

		// GSON fuer Umwandlung in JSON
		Gson gson = new GsonBuilder().create();
		
		// Wir wollen nur einen Teil transportieren, deswegen muss Liste ueberarbeitet werden
		JsonArray nurMatrikelnummerUndName = new JsonArray();
	
		for(Student s : Speicher.getStudenten())
		{
			JsonObject dataset = new JsonObject();
			dataset.addProperty("matrikelNummer", s.matrikelNummer);
			dataset.addProperty("name", s.name);
	 		nurMatrikelnummerUndName.add(dataset);
		}
		ergebnisAlsJSON = gson.toJson(nurMatrikelnummerUndName);
		return ergebnisAlsJSON;
	}
	
	// Funktion fuer Pfad 2 der Server-Sitemap: Matrikelnummer zum Namen
	public String getSucheMatrikelNummerZuName(String name) 
	{
		Student myStudent = null;
		JsonObject matrikelnummer = null;
		String ergebnisAlsJSON;

		Gson gson = new GsonBuilder().create();
				
		System.out.print("getSucheMatrikelNummerZuName: "+ name);
	
		myStudent = Speicher.getSucheMatrikelNummerZuName(name);
		if(myStudent != null)
		{
			 matrikelnummer = new JsonObject();
			 matrikelnummer.addProperty("matrikelNummer", myStudent.matrikelNummer);
		}
		System.out.println(" "+ matrikelnummer);
		ergebnisAlsJSON = gson.toJson(matrikelnummer);
		return ergebnisAlsJSON;
	}
	
	// Pfad 1 und Pfad 2 der Server-Sitemap fuehren auf diese Methode
	// diese verzweigt je nach Aufruf mit oder ohne Query-Parameter 
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON) 
	public String getListeOderSuche(@QueryParam("name") String name) {
		System.out.print("getListeOderSuche: "+ name + " ");
		
		if(name == null)
			// Pfad 1: kein Parameter: gesamte Liste
			return getListeVonStudenten();
		else
			// Pfad 2: mit Parameter: nur ein Eintrag
			return getSucheMatrikelNummerZuName(name);
	}

	// Funktion fuer Pfad 3 der Server-Sitemap: Name zu einer Matrikelnummer
	@GET
	@Path("/{matrikelNummer}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStudentenInfoZuMatrikelNummer(@PathParam("matrikelNummer") int matrikelNummer) 
	{
		Student myStudent = null;
		String ergebnisAlsJSON = "null";

		Gson gson = new GsonBuilder().create();
	
		System.out.print("getStudentenInfoZuMatrikelNummer: "+ matrikelNummer);

		myStudent = Speicher.getStudentenInfoZuMatrikelNummer(matrikelNummer);
		if(myStudent != null)
		{
			System.out.println(" "+ myStudent.name + " mit " + myStudent.leistungen.length + " Leistungen");
			
			// Wir wollen nur einen Teil transportieren, deswegen muss Liste ueberarbeitet werden
			JsonObject nurMatrikelnummerUndName = new JsonObject();
			nurMatrikelnummerUndName.addProperty("matrikelNummer", myStudent.matrikelNummer);
			nurMatrikelnummerUndName.addProperty("name", myStudent.name);
			ergebnisAlsJSON = gson.toJson(nurMatrikelnummerUndName);
		}
		else
			System.out.println(" nicht gefunden.");

		return ergebnisAlsJSON;
	}
		
	// Funktion fuer Pfad 4 der Server-Sitemap: Leistungen zu einer Matrikelnummer
	@GET
	@Path("/{matrikelNummer}/leistung")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLeistungVonStudenten(@PathParam("matrikelNummer") int matrikelNummer) 
	{
		Student myStudent = null;
		String ergebnisAlsJSON = "null";

		Gson gson = new GsonBuilder().create();

		System.out.print("getLeistungVonStudenten: "+ matrikelNummer);

		myStudent = Speicher.getStudentenInfoZuMatrikelNummer(matrikelNummer);
		if(myStudent != null)
		{
			System.out.println(" "+ myStudent.name + " mit " + myStudent.leistungen.length + " Leistungen");
			ergebnisAlsJSON = gson.toJson(myStudent.leistungen);
		}
		else
			System.out.println(" nicht gefunden.");
	
		return ergebnisAlsJSON;
	}
}
