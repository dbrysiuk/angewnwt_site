import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Loes_Aufg_7_2Server {

	ServerSocket serverSocket;
	Socket linkZumClient;
	DataInputStream inFromClient;
	DataOutputStream outToClient;

	public Loes_Aufg_7_2Server( int port) throws IOException {

		serverSocket = new ServerSocket(port); // Socket erzeugen
		System.out.println("Server gestartet.");

		linkZumClient = serverSocket.accept(); // warten bis sich Client verbindet
		System.out.println("Verbindung hergestellt mit "+ linkZumClient.getInetAddress());

		inFromClient = new DataInputStream(new BufferedInputStream(linkZumClient.getInputStream()));
		outToClient = new DataOutputStream(new BufferedOutputStream(linkZumClient.getOutputStream()));
	}

	public void empfangeDatei() throws IOException {
		
        int readByte;
		String dateiName;
		int bytesToRead;

		// Dateinamen empfangen
		dateiName= inFromClient.readUTF();

		// Datei zum Schreiben oeffnen
		FileOutputStream outToFile = new FileOutputStream("Neu_" + dateiName);
		System.out.println("Empfange Datei "+ "Neu_" + dateiName);

		// Zahl der zu empfangenden Bytes empfangen
		bytesToRead = inFromClient.readInt();
		System.out.println("Lese "+bytesToRead+" Bytes.");

		int anzempfbytes = 0;

		// Byteweise empfangen und in Datei schreiben
		while(bytesToRead-- > 0) {
			readByte = inFromClient.readByte();
			outToFile.write(readByte);
			System.out.print("\rnoch "+bytesToRead);
			anzempfbytes ++;
		}
		outToFile.close();

		// Zahl der empfangenen Bytes an Client schicken
		outToClient.writeInt(anzempfbytes);
	}
    
	public void disconnect() throws IOException {
		outToClient.close();
		inFromClient.close();
		linkZumClient.close();
		serverSocket.close();
	}
    
	public static void main(String[] args) throws IOException {

		Loes_Aufg_7_2Server meinServer = new Loes_Aufg_7_2Server(4711);
		meinServer.empfangeDatei();
		meinServer.disconnect();
	}
}