package tcpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer 
{
	public static void main(String[] args) throws IOException
	{
		int port = 47331;

		// ServerSocket erzeugen
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Warte auf Verbindung auf "+InetAddress.getLocalHost() +":" + port);

		while(true)
		{
			// Auf Verbindung warten
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client verbunden: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

			// Thread zur Berabeitung der Anfragen ueber diese Verbindung starten
			ClientHandler clientHandler = new ClientHandler(clientSocket);
			clientHandler.start();
		}
	}
}

