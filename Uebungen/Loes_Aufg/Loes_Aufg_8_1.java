import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Loes_Aufg_8_1 {
    InetAddress adresse;
    int port;
    DatagramSocket socket;
    byte[] bytePuffer;
    DatagramPacket udpPaket;
    
    public Loes_Aufg_8_1(InetAddress empfaengerAdresse, int empfaengerPort) throws IOException {
        
        socket = new DatagramSocket();
        System.out.println("UDPSender Socket erzeugt");
        bytePuffer = new byte[10];
        udpPaket = new DatagramPacket(bytePuffer,bytePuffer.length);
        System.out.println("UDPSender Datenpaket erzeugt");
        this.adresse = empfaengerAdresse;
        this.port = empfaengerPort;
    }
    
    public void tuWas(int startwert) throws IOException, InterruptedException {
        
        do {
            String zahl = String.valueOf(startwert);
            byte[] ziffern = zahl.getBytes();
            udpPaket.setData(ziffern);
            udpPaket.setLength(ziffern.length);
            udpPaket.setPort(port);
            udpPaket.setAddress(adresse);
            socket.send(udpPaket);
            System.out.println("UDPSender gesendet: "+zahl);
            Thread.sleep(1000);
            startwert++;
        }
        while(true);
    }
    
    public void disconnect() throws IOException {
        
        socket.close();
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        
        Loes_Aufg_8_1 sender = new Loes_Aufg_8_1(InetAddress.getByName("127.0.0.1"),4711);
        sender.tuWas(1);
        sender.disconnect();
    }
}