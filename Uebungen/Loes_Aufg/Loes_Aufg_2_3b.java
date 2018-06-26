import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loes_Aufg_2_3b {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bufRed = null;
		try {
			fis = new FileInputStream("UTF8-demo.txt");
			isr = new InputStreamReader(fis, "UTF8");
			bufRed = new BufferedReader(isr);
			String line;
			while ((line = bufRed.readLine()) != null) {   //naechste Zeile lesen
				System.out.println(line);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (bufRed != null) {
				bufRed.close();
			}
		}	
	}
}