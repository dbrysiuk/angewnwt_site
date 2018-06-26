import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Loes_Aufg_7_1Server {

	ServerSocket serverSocket;
	Socket linkZumClient;
	DataInputStream inFromClient;
	DataOutputStream outToClient;

	public Loes_Aufg_7_1Server( int port) throws IOException
	{
		serverSocket = new ServerSocket(port); // Socket erzeugen

		System.out.println("Server gestartet.");
		linkZumClient = serverSocket.accept(); // warten bis sich Client verbindet

		System.out.println("Verbindung hergestellt mit "+ serverSocket.getInetAddress());

		inFromClient = new DataInputStream(linkZumClient.getInputStream());

		outToClient = new DataOutputStream(linkZumClient.getOutputStream());
	}

	public void tuWas() throws IOException {

		String zeichenketteklein = null;
		String zeichenkettegross = null;

		zeichenketteklein = inFromClient.readUTF() ; //String vom Client empfangen

		System.out.print("Server Empfangen: "+ zeichenketteklein);

		zeichenkettegross = zeichenketteklein.toUpperCase();

		outToClient.writeUTF(zeichenkettegross);
		System.out.println(" gesendet: "+ zeichenkettegross);
	}

	public void disconnect() throws IOException {
		inFromClient.close();
		outToClient.close();
		linkZumClient.close();
		serverSocket.close();
	}

	public static void main(String[] args) throws IOException {

		Loes_Aufg_7_1Server meinServer = new Loes_Aufg_7_1Server(4711);
		meinServer.tuWas();
		meinServer.disconnect();

	}
}