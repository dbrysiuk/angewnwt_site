import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetzwerkIO implements LesenSchreiben {
	String server;
	int port;
	Socket linkZumServer;
	DataInputStream datenEmpfang;
	DataOutputStream datenVersand;
	boolean verbindungSteht;
	
	NetzwerkIO(String serverURL, int serverPort) {
		server = serverURL;
		port = serverPort;
		verbindungSteht = false;
	}
		
	void VerbindungAufbauen() throws UnknownHostException, InterruptedException {
		while(!verbindungSteht) {
			try {

				linkZumServer = new Socket(server,port);
				System.out.println("Verbunden mit " + linkZumServer.getInetAddress() + ":" + linkZumServer.getPort());
				datenEmpfang = new DataInputStream(new BufferedInputStream(linkZumServer.getInputStream()));
				datenVersand = new DataOutputStream(new BufferedOutputStream(linkZumServer.getOutputStream()));
				verbindungSteht = true;
			}
			catch (IOException e) {
				System.out.println("Verbindungsaufbau gescheitert" + e);
				verbindungSteht = false;
				VerbindungAbbauen();
				Thread.sleep(10000);
			}
		}
	}


	void VerbindungAbbauen()  {
		try {
			verbindungSteht = false;
			datenVersand.close();
			datenEmpfang.close();
			linkZumServer.close();
		}
		catch (IOException e) {
			System.out.println("Abbau mit Exception "+e);
		}
	}

	@Override
	public void schreibeDatei(Student[] studenten) throws IOException {
		if(!verbindungSteht)
		{
			try {
				VerbindungAufbauen();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		DataOutputStream dos = new DataOutputStream(datenVersand);
		
		if(studenten != null) {
			dos.writeInt(studenten.length);
			for(int i=0; i < studenten.length; i++) {
				dos.writeInt(studenten[i].matrikelNummer);
				dos.writeUTF(studenten[i].name);
				if(studenten[i].leistungen != null) {
					dos.writeInt(studenten[i].leistungen.length);

					for(int j=0; j < studenten[i].leistungen.length; j++) {
						dos.writeUTF(studenten[i].leistungen[j].modul);
						dos.writeDouble(studenten[i].leistungen[j].note);
					}
				}
				else
					dos.writeInt(0);	
			}
		}
		else
			dos.writeInt(0);
		dos.flush();
		dos.close();
		VerbindungAbbauen();
	}

	@Override
	public Student[] leseDatei() throws IOException {
		Student[] geleseneStudenten;
		
		if(!verbindungSteht)
		{
			try {
				VerbindungAufbauen();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		DataInputStream dis = new DataInputStream(datenEmpfang);

		int studCnt = dis.readInt();
		if(studCnt != 0)
		{
			geleseneStudenten = new Student[studCnt];
			for(int i=0; i < studCnt; i++) {
				geleseneStudenten[i] = new Student();
				geleseneStudenten[i].matrikelNummer = dis.readInt();
				geleseneStudenten[i].name = dis.readUTF();
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
			}

		}
		else
			geleseneStudenten = null;

		dis.close();
		VerbindungAbbauen();
		return geleseneStudenten;
	}
	

}
