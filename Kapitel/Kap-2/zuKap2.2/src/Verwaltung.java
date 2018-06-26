
import java.io.IOException;

public class Verwaltung {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Studenten aus dem Speicher abfragen
		Student[] studenten = Speicher.getStudenten();
					
		// Dateihandlerinstanz erzeugen
		LesenSchreiben leseSchreibe = new  
		//		BinaerIO("BinaerDatei");
				TextIO("Textdatei");
		
		// Datei schreiben
		leseSchreibe.schreibeDatei(studenten);
		System.out.println("Array geschrieben");
		
		// Kurze Wartezeit, simuliert Verarbeitung
		Thread.sleep(1000);
		
		// Datei lesen
		Student[] zurueckGelesen = leseSchreibe.leseDatei();
		System.out.println("Array gelesen");
		
		// Vergleichen
		if(Speicher.sindArraysGleich(studenten, zurueckGelesen))
			System.out.println("Arrays sind gleich");
		else
			System.out.println("Arrays sind ungleich");
	}
}
