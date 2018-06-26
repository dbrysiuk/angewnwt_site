package tcpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class TCPClient 
{
	String ip;
	int port;
	Socket server;
	OutputStream outToServer;
	InputStream inFromServer;

	public TCPClient(String ip, int port)
	{
		this.ip = ip;
		this.port = port;
	}

	public void baueVerbindungAuf() throws UnknownHostException, IOException
	{
		this.server = new Socket(ip, port);

		System.out.println("Client verbunden mit: " + this.server.getInetAddress() + ":" + this.server.getPort());

		this.outToServer = this.server.getOutputStream();
		this.inFromServer = this.server.getInputStream();
	}

	public Befehl sendeBefehl(Befehl befehl) throws IOException
	{
		byte[] bytes = new byte[6];
		Befehl antwort = new Befehl();

		outToServer.write(befehl.baueBefehlString());

		int read = inFromServer.read(bytes, 0, 6);
		if(read == -1)
		{
			schliesseVerbindung();
			return antwort;
		}
		antwort.anfrage = new String(bytes, 0, 3, Charset.forName("ASCII"));
		String antwortAnhangLaenge = new String(bytes, 3, 3, Charset.forName("ASCII"));

		int anhangLaenge = Integer.parseInt(antwortAnhangLaenge);
		if(anhangLaenge > 0)
		{
			bytes = new byte[anhangLaenge];
			inFromServer.read(bytes, 0, anhangLaenge);
			antwort.anhang = new String(bytes, 0, anhangLaenge, Charset.forName("UTF-8"));
		}
		return antwort;
	}

	public void schliesseVerbindung() throws IOException
	{
		outToServer.close();
		inFromServer.close();
		server.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{
		String ip =  "localhost";
		int port  =  47331;
		String name = "Mia Fischer";

		TCPClient client = new TCPClient(ip, port);

		client.baueVerbindungAuf();

		// Finde Matrikelnummer zu Name 
		Befehl befehl = new Befehl(); 
		befehl.anfrage = "MAT";
		befehl.anhang = name;
		Befehl antwort = client.sendeBefehl(befehl);
		if(antwort.anhang.length() > 0)
		{
			// Martikelnummer zu Name gefunden (Student vorhanden)
			int matrikelNummer = Integer.parseInt(antwort.anhang);
			System.out.println("Matrikelnummer zu " + name + " ist: "+ matrikelNummer);

			// Leistungen des Studenten landen
			befehl.anfrage = "LEI";
			befehl.anhang = String.format("%03d", matrikelNummer);
			antwort = client.sendeBefehl(befehl); 

			String elemente[] = antwort.anhang.split("\\|");
			Leistung leistungen[] = new Leistung[elemente.length];
			for(int i = 0; i < leistungen.length; i++)
			{
				String teile[] = elemente[i].split(";");
				leistungen[i] = new Leistung();
				leistungen[i].modul = teile[0];
				leistungen[i].note = Double.parseDouble(teile[1]);
				System.out.println(leistungen[i].modul + " " + leistungen[i].note);
			}
		}
		else 
			System.out.println("Matrikelnummer zu " + name + " nicht gefunden");

		client.schliesseVerbindung();
	}
}
