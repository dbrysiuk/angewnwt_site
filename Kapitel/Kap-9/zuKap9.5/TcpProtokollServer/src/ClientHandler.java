package tcpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class ClientHandler extends Thread
{
	Socket clientSocket;
	InputStream inFromClient;
	OutputStream outToClient;

	public ClientHandler(Socket clientSocket) throws IOException
	{
		this.clientSocket = clientSocket;
		this.inFromClient = clientSocket.getInputStream();
		this.outToClient = clientSocket.getOutputStream();
	}

	@Override
	public void run()
	{
		while(true)
		{
			try 
			{
				byte[] bytes = new byte[6];

				int read = inFromClient.read(bytes, 0, 6);
				if(read == -1)
				{
					schliesseVerbindung();
					return;
				}

				Befehl befehl = new Befehl();

				befehl.anfrage = new String(bytes, 0, 3, Charset.forName("ASCII"));
				String anhangLaenge = new String(bytes, 3, 3, Charset.forName("ASCII"));

				int laenge = Integer.parseInt(anhangLaenge);
				if(laenge > 0)
				{
					bytes = new byte[laenge];
					inFromClient.read(bytes, 0, laenge);
					befehl.anhang = new String(bytes, 0, laenge, Charset.forName("UTF-8"));
				}
				System.out.println("Kommando: " + befehl.anfrage + " " + befehl.anhang + 
						" von " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
			
				if(befehl.anfrage.contains("MAT"))
				{
					Befehl antwort = new Befehl();
					antwort.anfrage = "ANT";
					
					Student myStudent= Speicher.getSucheMatrikelNummerZuName(befehl.anhang);
					if(myStudent != null)
					{
						antwort.anhang = String.valueOf(myStudent.matrikelNummer); 
					}
					outToClient.write(antwort.baueBefehlString());
				}
				else if(befehl.anfrage.contains("STU"))
				{
					Befehl antwort = new Befehl();
					antwort.anfrage = "ANT";
					int matrikelNummer = Integer.parseInt(befehl.anhang);
					
					Student myStudent = Speicher.getStudentenInfoZuMatrikelNummer(matrikelNummer);
					if(myStudent != null)
					{
						antwort.anhang = myStudent.matrikelNummer + ";" + myStudent.name; 
					}
					outToClient.write(antwort.baueBefehlString());
				}
				else if(befehl.anfrage.contains("LEI"))
				{
					Befehl antwort = new Befehl();
					antwort.anfrage = "ANT";
					int matrikelNummer = Integer.parseInt(befehl.anhang);

					Student myStudent = Speicher.getStudentenInfoZuMatrikelNummer(matrikelNummer);
					if(myStudent != null)
					{
						if(myStudent.leistungen != null)
						{
							for(Leistung l: myStudent.leistungen)
							{
								antwort.anhang += l.modul + ";" + l.note + "|";
							}
						}
					}
					outToClient.write(antwort.baueBefehlString());
				}
			}
			catch (Exception e) 
			{
				if(!clientSocket.isConnected())
				{
					try 
					{
						schliesseVerbindung();
					} 
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
				return;
			}
		}
	}

	public void schliesseVerbindung() throws IOException
	{
		System.out.println("Verbindung beendet " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
		outToClient.close();
		inFromClient.close();
		clientSocket.close();
	}
}
