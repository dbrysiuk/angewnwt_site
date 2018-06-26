import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetzwerkIODemoServer {
	
	ServerSocket serverSocket;
	int port;
	Socket linkZumClient;
	DataInputStream vomClient;
	DataOutputStream zumClient;
	boolean verbindungSteht;

	NetzwerkIODemoServer(int portNr) {
		port = portNr;
		verbindungSteht = false;
	}
	
	void VerbindungAufbauen() throws UnknownHostException, InterruptedException {
		while(!verbindungSteht) {
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("Warte auf Verbindung");
				linkZumClient = serverSocket.accept();
				System.out.println("Verbunden mit " + linkZumClient.getInetAddress() + ":" + linkZumClient.getPort());
				vomClient = new DataInputStream(linkZumClient.getInputStream());
				zumClient = new DataOutputStream(linkZumClient.getOutputStream());
				verbindungSteht = true;
			}
			catch (IOException e) {
				System.out.println("Verbindungsaufbau gescheitert" + e);
				verbindungSteht = false;
				VerbindungAbbauen();
			}
		}
	}

	void VerbindungAbbauen()  {
		try {
			verbindungSteht = false;
			zumClient.close();
			vomClient.close();
			linkZumClient.close();
			serverSocket.close();
		}
		catch (IOException e) {
			System.out.println("Abbau mit Exception "+e);
		}
	}
	
	public void schreibeDatei(String dateiName, Student[] studenten) throws IOException, InterruptedException {
		DataOutputStream dos = new DataOutputStream(zumClient);
		
		if(studenten != null) {
			dos.writeInt(studenten.length);
			for(int i=0; i < studenten.length; i++) {
				dos.writeInt(studenten[i].matrikelNummer);
				dos.writeUTF(studenten[i].name);
				System.out.print("geschrieben: "+studenten[i].name);
				if(studenten[i].leistungen != null) {
					dos.writeInt(studenten[i].leistungen.length);

					for(int j=0; j < studenten[i].leistungen.length; j++) {
						dos.writeUTF(studenten[i].leistungen[j].modul);
						dos.writeDouble(studenten[i].leistungen[j].note);
					}
				}
				else
					dos.writeInt(0);	
				System.out.println(" mit Noten.");
			}
		}
		else
			dos.writeInt(0);
		dos.flush();
		//Thread.sleep(10000);
		dos.close();
		VerbindungAbbauen();
	}

	public Student[] leseDatei(String dateiName) throws IOException, InterruptedException {
		Student[] geleseneStudenten;
		
		DataInputStream dis = new DataInputStream(vomClient);

		int studCnt = dis.readInt();
		if(studCnt != 0)
		{
			geleseneStudenten = new Student[studCnt];
			for(int i=0; i < studCnt; i++) {
				geleseneStudenten[i] = new Student();
				geleseneStudenten[i].matrikelNummer = dis.readInt();
				geleseneStudenten[i].name = dis.readUTF();
				System.out.print("gelesen: "+geleseneStudenten[i].name);
				int leistCnt = dis.readInt();
				if(leistCnt != 0) {
					geleseneStudenten[i].leistungen = new Leistung[leistCnt];
					for(int j=0; j < leistCnt; j++) {
						geleseneStudenten[i].leistungen[j] = new Leistung();
						geleseneStudenten[i].leistungen[j].modul = dis.readUTF();
						geleseneStudenten[i].leistungen[j].note = dis.readDouble();
					}
				}
				else
					geleseneStudenten[i].leistungen = null;	
				System.out.println(" mit  Noten.");
			}
		}
		else
			geleseneStudenten = null;

		dis.close();
		//Thread.sleep(10000);
		VerbindungAbbauen();
		return geleseneStudenten;
	}
	


	public static void main(String[] args) throws InterruptedException, IOException {
		NetzwerkIODemoServer server = new NetzwerkIODemoServer(4711);
		
		server.VerbindungAufbauen();
		
		// Datei lesen
		System.out.println("Lese Datei");
		Student[] gelesen = server.leseDatei("Datei");
		
		server.VerbindungAufbauen();
		
		// Datei zurücksenden
		System.out.println("Schreibe Datei");
		server.schreibeDatei("Datei", gelesen);
	
		server.VerbindungAbbauen();
	}

}
