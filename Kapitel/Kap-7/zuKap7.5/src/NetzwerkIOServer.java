import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetzwerkIOServer extends NetzwerkIO {
	ServerSocket serverSocket;
	Socket linkZumClient;

	NetzwerkIOServer(int serverPort) {
		super("egal",serverPort);
	}
	
	@Override
	void VerbindungAufbauen() throws UnknownHostException, InterruptedException {
		while(!verbindungSteht) {
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("Warte auf Verbindung");
				linkZumClient = serverSocket.accept();
				System.out.println("Verbunden mit " + linkZumClient.getInetAddress() + ":" + linkZumClient.getPort());
				datenEmpfang = new DataInputStream(new BufferedInputStream(linkZumClient.getInputStream()));
				datenVersand = new DataOutputStream(new BufferedOutputStream(linkZumClient.getOutputStream()));
				verbindungSteht = true;
			}
			catch (IOException e) {
				System.out.println("Verbindungsaufbau gescheitert" + e);
				verbindungSteht = false;
				VerbindungAbbauen();
			}
		}
	}

	@Override
	void VerbindungAbbauen()  {
		try {
			verbindungSteht = false;
			datenVersand.close();
			datenEmpfang.close();
			linkZumClient.close();
			serverSocket.close();
		}
		catch (IOException e) {
			System.out.println("Abbau mit Exception "+e);
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		NetzwerkIOServer server = new NetzwerkIOServer(4711);
		
		server.VerbindungAufbauen();
		
		// Datei vom Client lesen
		System.out.println("Lese Datei");
		Student[] gelesen = server.leseDatei();
		
		server.VerbindungAufbauen();
		
		// Datei an Client zuruecksenden
		System.out.println("Schreibe Datei");
		server.schreibeDatei(gelesen);
	
		server.VerbindungAbbauen();	}
}
