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
		System.out.println("Verbindung hergestellt.");
		
		inFromClient = new DataInputStream(linkZumClient.getInputStream());
		outToClient = new DataOutputStream(linkZumClient.getOutputStream());
	}
	
	public void tuWas(int repeat) throws IOException {
		int zahl1;
		int zahl2;
		int summe;

		for(int i = 0;  i < repeat; i++) {
			zahl1 = inFromClient.readInt();
			zahl2 = inFromClient.readInt(); 
			System.out.print("Server Empfangen: "+ zahl1 + ", "+ zahl2);
			summe = zahl1 + zahl2; 
			outToClient.writeInt(summe); 
			System.out.println(" gesendet: "+summe);
		}
	}
	
	public void disconnect() throws IOException {
		inFromClient.close();
		outToClient.close();
		linkZumClient.close();
		serverSocket.close();
		System.out.println("Server beendet.");
	}
	
	public static void main(String[] args) throws IOException {
		BeispielServer meinServer = new BeispielServer(4711);
	
		meinServer.tuWas(100);
		
		meinServer.disconnect();
	}
}