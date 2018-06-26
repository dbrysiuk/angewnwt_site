import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Loes_Aufg_2_2 {

	public static void main(String[] args) throws IOException {

		String dateiname = "UTF-8-demo.txt";
		File f = new File( dateiname );
		InputStream in;
		in = new FileInputStream( f );
		int by;

		while( (by=in.read()) != -1 )   // naechstes einzelne Byte lesen
		{
			System.out.println(by + " = " + (char)by);  // als Code und ASCII-Zeichen (der Wert von by ist hier ein 8-Bit-Wert)
		}

		in.close();
	}
}