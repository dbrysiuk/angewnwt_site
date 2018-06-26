import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BeispielServer {
	
	ServerSocket serverSocket;
	Socket linkZumClient;
	DataInputStream inFromClient;
	DataOutputStream outToClient; 
	
	public BeispielServer( int port) throws IOException {
		serverSocket = new ServerSocket(port); // Socket erzeugen
		System.out.println("Server gestartet.");
	
		linkZumClient = serverSocket.accept(); // warten bis sich Client verbindet 
		System.out.println("Verbindung hergestellt mit "+ serverSocket.getInetAddress());
		
		inFromClient = new DataInputStream(linkZumClient.getInputStream());
		outToClient = new DataOutputStream(linkZumClient.getOutputStream());
	}
	
	public void tuWas(int startwert) throws IOException {
		int zahl;
		
		outToClient.writeInt(startwert); // erste Zahl an Client
		System.out.println("Server gesendet: "+startwert);

		do {
			zahl = inFromClient.readInt(); //Zahl vom Client empfangen
			System.out.print("Server Empfangen: "+zahl);
			zahl--; // Zahl um eins reduzieren
			outToClient.writeInt(zahl); // neue Zahl an Client
			System.out.println(" gesendet: "+zahl);
		}
		while(zahl > 0);
	}
	
	public void disconnect() throws IOException {
		inFromClient.close();
		outToClient.close();
		linkZumClient.close();
		serverSocket.close();
	}
	
	public static void main(String[] args) throws IOException {
		BeispielServer meinServer = new BeispielServer(4711);
	
		meinServer.tuWas(100);
		
		meinServer.disconnect();
	}
}