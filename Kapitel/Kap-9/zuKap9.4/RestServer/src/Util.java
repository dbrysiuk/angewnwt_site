package restServer;


public class Util {
	static final String [] vornamen = { "Mia","Ben","Emma","Jonas","Hannah","Leon","Sofia","Finn","Anna","Elias"};
	static final String [] nachnamen = {"Bauer","Becker","Fischer","Fuchs","Hartmann","Lang", "Jung","Hofmann","Huber"};
	static final String [] module = {"Analysis A","Lineare Algebra A","Analysis B","Lineare Algebra B","Numerik A",
    "Stochastik A","Stochastik B","Numerik partieller Differentialgleichungen 1","Numerik partieller Differentialgleichungen 2",
    "Baumechanik I (Statik starrer Koerper)","Baumechanik II (Elastomechanik)","Baumechanik III (Kinematik und Kinetik)",
    "Kontinuumsmechanik I","Modellbildung im Ingenieurwesen","Numerische Mechanik","Festkoerpermechanik","Finite Elemente II",
    "Grundlagen der Elektrotechnik","Umweltbiologie und -chemie","Stroemungsmechanik","Thermodynamik im Ueberblick",
    "Datenstrukturen, Algorithmen und Programmierung","Datenbanksysteme im Ingenieurwesen","Graphen und Netze","Baustoffkunde I",
    "Baustoffkunde II","Ausgleichungsrechnung und Statistik I","Ausgleichungsrechnung und Statistik II",
    "Projekte des Ingenieurwesens" };
	
	public static Student[] fuelleMitUnsinn(int Zahl)
	{
		Student[] unsinn = new Student[Zahl];
		
		for(int i=0; i < Zahl; i++) {
			unsinn[i]=new Student();
			int vn_indx = (int)(Math.random()*vornamen.length);
			int nn_indx = (int)(Math.random()*nachnamen.length);
			unsinn[i].name = vornamen[vn_indx] + " " + nachnamen[nn_indx];
			unsinn[i].matrikelNummer = vn_indx * 100 + nn_indx;
			int notenZahl = (int)(Math.random()*8);
			if(notenZahl >= 1) {
				unsinn[i].leistungen = new Leistung[notenZahl];
				for(int j=0; j < notenZahl; j++) {
					int mod_indx = (int)(Math.random()*module.length);
					unsinn[i].leistungen[j] = new Leistung();
					unsinn[i].leistungen[j].modul = module[mod_indx];
					unsinn[i].leistungen[j].note = (int)(Math.random()*5) + 1;
				}
			}
			else
				unsinn[i].leistungen = null;
		}
		return unsinn;
	}
	
	public static boolean sindArraysGleich(Student[] a, Student[] b) {
		boolean istUnGleich = false;
		if(a.length == b.length)
		{
			for(int i=0; i < a.length; i++) {
				istUnGleich |= a[i].matrikelNummer != b[i].matrikelNummer;
				istUnGleich |= !(a[i].name.equals(b[i].name));
				if(a[i].leistungen != null) {
					for(int j=0; j < a[i].leistungen.length; j++) {
						istUnGleich |= !(a[i].leistungen[j].modul.equals(b[i].leistungen[j].modul)) ;
						istUnGleich |= a[i].leistungen[j].note != b[i].leistungen[j].note ;
					}
				}
				if(istUnGleich)
					System.out.println("Ungleich "+i);
			}
		}
		else
			istUnGleich = true;

		return !istUnGleich;
	}
}
