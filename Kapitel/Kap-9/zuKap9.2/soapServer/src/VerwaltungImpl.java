package soapServer;

import javax.jws.WebService;

@WebService( endpointInterface="soapServer.VerwaltungInterface" )
public class VerwaltungImpl implements VerwaltungInterface 
{
	@Override
	public int martikelnummerZuName(String name) 
	{
		System.out.print("matrikelNummerZuName: "+ name);
		Student s = Speicher.getSucheMatrikelNummerZuName(name);
		
		if(s != null)
		{
			System.out.println(" "+ s.matrikelNummer);
			return s.matrikelNummer;
		}
		
		System.out.println(" nicht gefunden");
		return -1;
	}

	@Override
	public Leistung[] studienleistungZuMartikelnummer(int matrikelNummer) 
	{
		System.out.print("StudienleistungZuMartikelnummer: "+ matrikelNummer);
		
		Student s = Speicher.getStudentenInfoZuMatrikelNummer(matrikelNummer);
		
		if(s != null)
		{
			System.out.println(" "+ s.name + " mit " + s.leistungen.length + " Leistungen");
			return s.leistungen;
		}
		
		System.out.println(" nicht gefunden");
		return null;
	}
}
