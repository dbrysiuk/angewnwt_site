import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TextIO implements LesenSchreiben {

	String dateiName;
	
	TextIO(String dateiName)
	{
		this.dateiName = dateiName;
	}
	
	@Override
	public void schreibeDatei(Student[] studenten) throws IOException {
		FileOutputStream fos = new FileOutputStream(dateiName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");	
		
		// string.format()
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
					// Text ergänzen
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

	@Override
	public Student[] leseDatei() throws IOException {
		Student[] geleseneStudenten;

		FileInputStream fis = new FileInputStream(dateiName);
		
		// Einen Scanner erzeugen, der den Stream von Trennzeichen zu Trennzeichen liest
			Scanner scan = new Scanner(fis,"UTF8");
			// ; mit oder ohne folgenden Whitespace (Leerzeichen, Tabulator, Zeilenvorschub)
			// als Trennzeichen festlegen
			scan.useDelimiter(";\\s*");
		
		int studCnt = scan.nextInt();
		if(studCnt != 0)
		{
			geleseneStudenten = new Student[studCnt];
			for(int i=0; i < studCnt; i++) {
				geleseneStudenten[i] = new Student();
				geleseneStudenten[i].matrikelNummer = scan.nextInt();
				geleseneStudenten[i].name = scan.next();
				int leistCnt = scan.nextInt();
				if(leistCnt != 0) {
					geleseneStudenten[i].leistungen = new Leistung[leistCnt];
					for(int j=0; j < leistCnt; j++) {
						geleseneStudenten[i].leistungen[j] = new Leistung();
						geleseneStudenten[i].leistungen[j].modul = scan.next(); 
						geleseneStudenten[i].leistungen[j].note = scan.nextDouble();
					}
				}
				else
					geleseneStudenten[i].leistungen = null;	
			}

		}
		else
			geleseneStudenten = null;

		scan.close();
		fis.close();
		return geleseneStudenten;
	}
	

}
