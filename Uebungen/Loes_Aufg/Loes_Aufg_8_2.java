import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Loes_Aufg_8_2 {
    InetAddress adresse;
    int port;
    DatagramSocket socket;
    byte[] bytePuffer;
    DatagramPacket udpPaket;
    
    public Loes_Aufg_8_2 (int empfaengerPort) throws IOException {
        
        socket = new DatagramSocket(empfaengerPort);
        System.out.println("UDPEmpfaenger Socket erzeugt");
        bytePuffer = new byte[10];
        udpPaket = new DatagramPacket(bytePuffer,bytePuffer.length);
        System.out.println("UDPEmpfaenger Datenpaket erzeugt");
    }
    
    public void tuWas() throws IOException {
        
        String zahl;
        do {
            socket.receive(udpPaket);
            zahl = new String(udpPaket.getData());
            System.out.println("Empfangen: "+zahl);
        }
        while(true);
    }
    
    public void disconnect() throws IOException {
        
        socket.close();
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Loes_Aufg_8_2 empfaenger = new Loes_Aufg_8_2(4711);
        empfaenger.tuWas();
        empfaenger.disconnect();
    }
}