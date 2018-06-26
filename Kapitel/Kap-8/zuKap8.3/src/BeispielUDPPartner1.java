import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BeispielUDPPartner1 {
	InetAddress seineAdresse;
	int seinPort;
	DatagramSocket udpSocket;
	byte[] bytePuffer;
	DatagramPacket udpPaket;

	public BeispielUDPPartner1(int meinPort, InetAddress seineAdresse, int seinPort) throws IOException {
		udpSocket = new DatagramSocket(meinPort); 
		System.out.println("Partner 1 Socket erzeugt");
		bytePuffer = new byte[10];
		udpPaket = new DatagramPacket(bytePuffer,bytePuffer.length);
		System.out.println("Partner 1 Datenpaket erzeugt");
		this.seineAdresse = seineAdresse;
		this.seinPort = seinPort;
	}

	public void tuWas() throws IOException {
		int zahl;

		do {
			udpSocket.receive(udpPaket);
			zahl = udpPaket.getData()[0];
			System.out.println("Partner 1 Empfangen: "+zahl + " insgesamt " + udpPaket.getLength() + " Bytes.");
		}
		while(true);
	}

	public void disconnect() throws IOException {
		udpSocket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		BeispielUDPPartner1 meinPartner1 = new BeispielUDPPartner1(4711,InetAddress.getByName("127.0.0.1"),4712);

		meinPartner1.tuWas();

		meinPartner1.disconnect();
	}
}