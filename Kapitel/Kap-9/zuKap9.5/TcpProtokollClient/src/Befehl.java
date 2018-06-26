package tcpClient;

import java.io.UnsupportedEncodingException;

public class Befehl 
{
	String anfrage = "";
	String anhang  = "";
	
	public byte[] baueBefehlString() throws UnsupportedEncodingException
	{
		// Speicher fuer die Teile des Befehls
		// 3 Bytes fuer die Anfrage im 7Bit Ascii-Code
		byte[] anfrageBytes = anfrage.getBytes("ASCII");
		// Bytes fuer den Parameter im 8/16/32Bit UTF-8 Code
		byte[] anhangBytes = anhang.getBytes("UTF-8");
		// 3 Bytes fuer die Zeichenkette der Laenge im 7Bit Ascii-Code
		byte[] lengthBytes =  String.format("%03d", anhangBytes.length).getBytes("ASCII");
		
		// Zielarray in entsprechender Groesse anlegen
		byte[] befehlBytes = new byte[3 + 3 + anhangBytes.length];
		
		// umkopieren in Zielarray
		int index = 0;
		for(int i=0;i<anfrageBytes.length;i++)
			befehlBytes[index++] = anfrageBytes[i];
		for(int i=0;i<lengthBytes.length;i++)
			befehlBytes[index++] = lengthBytes[i];
		for(int i=0;i<anhangBytes.length;i++)
			befehlBytes[index++] = anhangBytes[i];
		
		return befehlBytes;
	}
}
