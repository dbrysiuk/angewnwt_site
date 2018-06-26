import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;

import java.net.Socket;
import java.net.UnknownHostException;

public class BeispielClientGepuffert {
	Socket linkZumServer;
	DataInputStream inFromServer;
	DataOutputStream outToServer; 

	public BeispielClientGepuffert(InetAddress address, int port) throws IOException {
		linkZumServer = new Socket(address,port); // mit Server verbinden 
		System.out.println("Verbindung hergestellt");

		inFromServer = new DataInputStream(linkZumServer.getInputStream());
		outToServer = new DataOutputStream(new BufferedOutputStream(linkZumServer.getOutputStream()));
	}

	public void tuWas() throws IOException {
		int zahl;

		do {
			zahl = inFromServer.readInt(); //Zahl vom Server empfangen
			System.out.print("Client Empfangen: "+zahl);
			if(zahl <= 0 )
				break;
			else
			{
				zahl--; // Zahl um eins reduzieren
				outToServer.writeInt(zahl); // neue Zahl an Client
				outToServer.flush();
				System.out.println(" gesendet: "+zahl);
			}
		}
		while(true);
	}

	public void disconnect() throws IOException {
		inFromServer.close();
		outToServer.close();
		linkZumServer.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		BeispielClientGepuffert meinClient = new BeispielClientGepuffert(InetAddress.getByName("127.0.0.1"),4711);

		meinClient.tuWas();

		meinClient.disconnect();
	}
}