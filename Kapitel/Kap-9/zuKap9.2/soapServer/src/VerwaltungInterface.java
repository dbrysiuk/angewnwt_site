package soapServer;

import javax.jws.*;

@WebService
public interface VerwaltungInterface 
{
	public int martikelnummerZuName( @WebParam( name = "name" ) String name );
	
	public Leistung[] studienleistungZuMartikelnummer( @WebParam( name = "matrikelNummer" ) int matrikelNummer );
}
