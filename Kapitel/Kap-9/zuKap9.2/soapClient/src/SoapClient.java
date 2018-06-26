package soapClient;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import soapServer.Leistung;
import soapServer.VerwaltungInterface;

public class SoapClient 
{
	public static void main(String[] args) throws Throwable 
	{
		// URL des Servers
		String url ="http://localhost:4434/verwaltung";
		// Name des Studenten, fuer den wir anfragen
		String name = "Hannah Becker";

		// Verbindung zum Server aufbauen
		Service service = Service.create(
				new URL(url + "?wsdl"), 
				new QName("http://soapServer/", "VerwaltungImplService"));

		// Stub-Methoden bereitstellen
		VerwaltungInterface verwaltung = service.getPort(VerwaltungInterface.class);

		// Server abfragen: 1) Matrikelnummer zu Name
		int matrikelNummer = verwaltung.martikelnummerZuName(name);
		System.out.println("\nMartikelNummer: " + matrikelNummer);

		if (matrikelNummer != -1) 
		{
			// Server abfragen: 2) leistungen zur Matrikelnummer
			Leistung[] leistungen = verwaltung.studienleistungZuMartikelnummer(matrikelNummer);

			if (leistungen != null) 
			{
				for (Leistung leistung : leistungen) 
				{
					System.out.println("\nLeistung: " + leistung.getModul() + " - " + leistung.getNote());
				}
			}
		}

	}
}
