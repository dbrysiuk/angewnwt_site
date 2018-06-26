import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Loes_Aufg_2_4 {

	String dateiName;
	
	Loes_Aufg_2_4(String dateiName)
	{
		this.dateiName = dateiName;
	}
	
	public Student[] leseDatei() throws IOException {
		Student[] geleseneStudenten;

		FileInputStream fis = new FileInputStream(dateiName);
		DataInputStream dis = new DataInputStream(fis);

		int studCnt = dis.readInt();	// Lesen der Zahl der Datensaetze (1. Zeile in der Datei)
		// Falls Datensaetze in Datei vorhanden, diese auslesen und in Feld ablegen
		if(studCnt != 0)			
		{
			geleseneStudenten = new Student[studCnt];
			for(int i=0; i < studCnt; i++) {
				geleseneStudenten[i] = new Student();
				geleseneStudenten[i].matrikelNummer = dis.readInt();
				geleseneStudenten[i].name = dis.readUTF();
				int leistCnt = dis.readInt();
				// Falls auch Pruefungsleistungen hinterlegt sind, diese ebenso auslesen und ablegen
				if(leistCnt != 0) {
					geleseneStudenten[i].leistungen = new Leistung[leistCnt];
					for(int j=0; j < leistCnt; j++) {
						geleseneStudenten[i].leistungen[j] = new Leistung();
						geleseneStudenten[i].leistungen[j].modul = dis.readUTF();
						geleseneStudenten[i].leistungen[j].note = dis.readDouble();
					}
				}
				else
					geleseneStudenten[i].leistungen = null;	
			}
		}
		else
			geleseneStudenten = null;

		dis.close();	// Schliessen der Streams
		fis.close();
		return geleseneStudenten;	// Rueckgabe des Feldes mit den Studentendaten
	}
}