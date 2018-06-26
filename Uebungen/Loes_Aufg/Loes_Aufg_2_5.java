import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Loes_Aufg_2_5 {
    
	public void schreibeDemodaten(String dateiName, Student[] studenten) throws IOException {
		FileOutputStream fos = new FileOutputStream(dateiName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");	
		
		String toWrite;
		
		if(studenten != null) {
			// zu schreibenden Text aus einzelnen Elementen zusammensetzen
			toWrite = String.format("%d",studenten.length );
			// Elemente mit ; und Leerzeichen trennen
			toWrite += "; ";
			// Text als Zeile schreiben
			toWrite += "\n";
			osw.write(toWrite);
	
			for(int i=0; i < studenten.length; i++) {
				// neuen Text beginnen
				toWrite = String.format("%d; %s; ",
						studenten[i].matrikelNummer,
						studenten[i].name);
				if(studenten[i].leistungen != null) {
					// Text ergaenzen
					toWrite += String.format("%d; ",studenten[i].leistungen.length);

					for(int j=0; j < studenten[i].leistungen.length; j++) {
						toWrite += String.format("%s; %3.1f; ",
								studenten[i].leistungen[j].modul,
								studenten[i].leistungen[j].note);
					}
				}
				else
					toWrite += "0; ";
				// Text / Datensatz eines Studenten als Zeile ausgeben
				toWrite += "\n";
				osw.write(toWrite);
			}
		}
		else
		{
			toWrite = "0; \n";
			osw.write(toWrite);
		}
		osw.close();
		fos.close();
	}
}