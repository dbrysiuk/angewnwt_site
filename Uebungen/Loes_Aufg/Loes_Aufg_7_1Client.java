import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Loes_Aufg_7_1Client {

	Socket linkZumServer;
	DataInputStream inFromServer;
	DataOutputStream outToServer;

	public Loes_Aufg_7_1Client(InetAddress address, int port) throws IOException {

		linkZumServer = new Socket(address,port); // mit Server verbinden
		System.out.println("Verbindung hergestellt");

		inFromServer = new DataInputStream(linkZumServer.getInputStream());

		outToServer = new DataOutputStream(linkZumServer.getOutputStream());
	}

	public void tuWas() throws IOException {

		InputStreamReader tastatur = new InputStreamReader(System.in);
		BufferedReader bufferedtastatur = new BufferedReader(tastatur);
		System.out.print("Zeichenkette eingeben: ");

		String eingabe = bufferedtastatur.readLine();

		outToServer.writeUTF(eingabe); // neuer String an Server

		String ausgabe = inFromServer.readUTF(); //String vom Server empfangen

		System.out.println("Zeichenkette empfangen: " + ausgabe);
	}

	public void disconnect() throws IOException {

		inFromServer.close();
		outToServer.close();
		linkZumServer.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {

		Loes_Aufg_7_1Client meinClient = new Loes_Aufg_7_1Client(InetAddress.getByName("127.0.0.1"),4711);

		meinClient.tuWas();
		meinClient.disconnect();
	}
}