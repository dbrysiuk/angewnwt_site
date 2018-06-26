import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BeispielUDPPartner2 {
	InetAddress seineAdresse;
	int seinPort;
	DatagramSocket udpSocket;
	byte[] bytePuffer;
	DatagramPacket udpPaket;

	public BeispielUDPPartner2(int meinPort, InetAddress seineAdresse, int seinPort) throws IOException {
		udpSocket = new DatagramSocket(); //meinPort
		System.out.println("Partner 2 Socket erzeugt");
		bytePuffer = new byte[10]; // udpSocket.getReceiveBufferSize()
		udpPaket = new DatagramPacket(bytePuffer,bytePuffer.length);
		System.out.println("Partner 2 Datenpaket erzeugt");
		this.seineAdresse = seineAdresse;
		this.seinPort = seinPort;
	}

	public void tuWas(int startWert) throws IOException, InterruptedException {
		int zahl = startWert;

		do {
			byte [] data = new byte[1];
			data[0] = (byte)--zahl;
			udpPaket.setData(data);
			udpPaket.setLength(data.length);
			udpPaket.setPort(seinPort);
			udpPaket.setAddress(seineAdresse);
			udpSocket.send(udpPaket);
			System.out.println("Partner2 gesendet: "+zahl);
			Thread.sleep(1000);		
		}
		while(true);
	}

	public void disconnect() throws IOException {
		udpSocket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		BeispielUDPPartner2 meinPartner2 = new BeispielUDPPartner2(4712,InetAddress.getByName("127.0.0.1"),4711);

		meinPartner2.tuWas(100);

		meinPartner2.disconnect();
	}
}