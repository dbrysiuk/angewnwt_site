import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loes_Aufg_2_3a {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream("UTF8-demo.txt");
			isr = new InputStreamReader(fis, "UTF8");
			int ch;
            while ((ch = isr.read()) != -1) {   // einzelnes Zeichen lesen
				System.out.print((char)ch);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (isr != null) {
				isr.close();
			}
		}
	}
}