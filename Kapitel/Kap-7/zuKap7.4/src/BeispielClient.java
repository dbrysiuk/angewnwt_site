import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;

import java.net.Socket;
import java.net.UnknownHostException;

public class BeispielClient {
	Socket linkZumServer;
	DataInputStream inFromServer;
	DataOutputStream outToServer; 

	public BeispielClient(InetAddress address, int port) throws IOException {
		linkZumServer = new Socket(address,port); // mit Server verbinden 
		System.out.println("Verbindung hergestellt");

		inFromServer = new DataInputStream(linkZumServer.getInputStream());
		outToServer = new DataOutputStream(linkZumServer.getOutputStream());
	}

	public void tuWas(int repeat) throws IOException {
		int summe;
		
		for(int i=0; i < repeat; i++) {
			outToServer.writeInt(i); 
			outToServer.writeInt(i+1); 
			System.out.print("Client gesendet: "+ i + ",  "+ (i+1));
			
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
		BeispielClient meinClient = new BeispielClient(InetAddress.getByName("127.0.0.1"),4711);

		meinClient.tuWas(100);

		meinClient.disconnect();
	}
}