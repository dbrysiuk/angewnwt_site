package soapServer;

import javax.xml.ws.Endpoint;

public class SoapServer 
{
	public static void main(String[] args) 
	{
		// SOAP Service erstellen
		String url = "http://localhost:4434/verwaltung";
	    Endpoint.publish( url, new VerwaltungImpl() );
	    System.out.println("SOAP-Server gestartet: "+url);
	}

}
