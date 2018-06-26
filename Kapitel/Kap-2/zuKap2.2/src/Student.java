
public class Student {
	int matrikelNummer;
	String name;
	Leistung[] leistungen;
	
	@Override
	public String toString() {
		String result = matrikelNummer + ":" + name + ":" ;
		if(leistungen.length > 0) {
			for(Leistung l : leistungen)
				result += l;
		}
		else
			result += "keine Leistungen;";
		return result;
	}
}
