import java.io.IOException;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;

import java.net.Socket;
import java.net.UnknownHostException;

public class BeispielClientGepuffertZweiSchleifen {
	Socket linkZumServer;
	DataInputStream inFromServer;
	DataOutputStream outToServer; 

	public BeispielClientGepuffertZweiSchleifen(InetAddress address, int port) throws IOException {
		linkZumServer = new Socket(address,port); // mit Server verbinden 
		System.out.println("Verbindung hergestellt");

		inFromServer = new DataInputStream(linkZumServer.getInputStream());
		outToServer = new DataOutputStream(new BufferedOutputStream(linkZumServer.getOutputStream()));
	}

	public void tuWas(int repeat) throws IOException {
		int summe;

		for(int i=0; i < repeat; i++) {
			outToServer.writeInt(i); 
			outToServer.writeInt(i+1); 
			System.out.println("Client gesendet: "+ i + ",  "+ (i+1));
		}
		outToServer.flush();
		
		for(int i=0; i < repeat; i++) {
			summe = inFromServer.readInt(); 
			System.out.println(" empfangen: "+summe);
		}
	}

	public void disconnect() throws IOException {
		inFromServer.close();
		outToServer.close();
		linkZumServer.close();
		System.out.println("Verbindung getrennt");
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		BeispielClientGepuffertZweiSchleifen meinClient = new BeispielClientGepuffertZweiSchleifen(InetAddress.getByName("127.0.0.1"),4711);

		meinClient.tuWas(100);

		meinClient.disconnect();
	}
}