import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class my1stJSON { 

	public class Student {

		public int matrikelNummer;
		public String name; 
		public Leistung[] leistungen;
		
		@Override
		public String toString() {
			String result = 
					matrikelNummer+"\t"+name;
			return result;
		}
	}

	public class Leistung {

		public String modul;
		public double note;	
		@Override
		public String toString() {
			String result = 
					modul+" - "+note;
			return result;
		}
	}

	public static void main(String[] args) throws IOException {

		try (
			FileInputStream FIS = new FileInputStream("JSON-Datei.json");
			Reader reader = new InputStreamReader(FIS, "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			Student studenten[] = gson.fromJson(reader, Student[].class);

			for (int studentNr = 0; studentNr < studenten.length; studentNr++)
			{
				System.out.print(studenten[studentNr]+"\t");

				if (studenten[studentNr].leistungen != null)
				{
					for (int leistungNr = 0; leistungNr < studenten[studentNr].leistungen.length; leistungNr++)
						System.out.print(studenten[studentNr].leistungen[leistungNr]+" | ");
					System.out.println();
				}
				else System.out.println();
			}
		} 
	}
}