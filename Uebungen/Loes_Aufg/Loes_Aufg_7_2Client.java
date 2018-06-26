import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;

import java.net.Socket;
import java.net.UnknownHostException;

public class Loes_Aufg_7_2Client {
   
    Socket linkZumServer;
    DataInputStream inFromServer;
    DataOutputStream outToServer;
    
    public Loes_Aufg_7_2Client (InetAddress address, int port) throws IOException {
        
        linkZumServer = new Socket(address,port); // mit Server verbinden
        System.out.println("Verbindung hergestellt");
        
        inFromServer = new DataInputStream(new BufferedInputStream(linkZumServer.getInputStream()));
        outToServer = new DataOutputStream(new BufferedOutputStream(linkZumServer.getOutputStream()));
    }
    
    public void sendeDatei(String dateiName) throws IOException {
        int readByte;
        int numberOfBytes;
        
        // Datei zum Lesen oeffnen
        FileInputStream inFromFile = new FileInputStream(dateiName);
        System.out.println("Datei " + dateiName + "wird uebertragen");
        
        // Dateinamen uebertragen
        outToServer.writeUTF(dateiName);
        
        // Dateilaenge ermitteln und uebertragen
        numberOfBytes = inFromFile.available();
        outToServer.writeInt(numberOfBytes);
        System.out.println("Sende " + numberOfBytes + " Bytes.");
        
        // Datei byteweise einlesen und an Server schicken
        while((readByte = inFromFile.read()) >= 0) {
            outToServer.writeByte(readByte);
        }
        // evtl. noch im Puffer des BufferedOutputStreams befindliche Bytes an Server schicken
        outToServer.flush();
        inFromFile.close();
        
        // Bytezahl vom Server empfangen
        int anzempfbytes = inFromServer.readInt();
        System.out.println("Der Server hat folgende Anzahl empfangener Bytes gemeldet: " + anzempfbytes);
    }
    
    public void disconnect() throws IOException {
        outToServer.close();
        inFromServer.close();
        linkZumServer.close();
    }
   
    public static void main(String[] args) throws UnknownHostException, IOException {
        String dateiName;
        dateiName = "test.jpg";
        
        Loes_Aufg_7_2Client meinClient = new Loes_Aufg_7_2Client (InetAddress.getByName("127.0.0.1"),4711);
        
        meinClient.sendeDatei(dateiName);
        meinClient.disconnect();
    }
}