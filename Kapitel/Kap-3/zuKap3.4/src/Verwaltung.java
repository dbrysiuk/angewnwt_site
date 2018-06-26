
import java.io.IOException;

public class Verwaltung {
	public static void main(String[] args) throws IOException, InterruptedException {
		Student[] studenten;
		
		// Datensaetze erzeugen
		studenten = Util.fuelleMitUnsinn(100);
		System.out.println("Array erzeugt");
			
		// Dateihandlerinstanz erzeugen
		LesenSchreiben leseSchreibe = new  
		//		BinaerIO("BinaerDatei");
		//		TextIO("Textdatei");
				JSON_IO("JSON-Datei");
		
		// Datei schreiben
		leseSchreibe.schreibeDatei(studenten);
		System.out.println("Array geschrieben");
		
		// Kurze Wartezeit, simuliert Verarbeitung
		Thread.sleep(1000);
		
		// Datei lesen
		Student[] zurueckGelesen = leseSchreibe.leseDatei();
		System.out.println("Array gelesen");
		
		// Vergleichen
		if(Util.sindArraysGleich(studenten, zurueckGelesen))
			System.out.println("Arrays sind gleich");
		else
			System.out.println("Arrays sind ungleich");
	}
}
