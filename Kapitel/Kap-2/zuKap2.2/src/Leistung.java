public class Leistung {
	String modul;
	double note;

	@Override
	public String toString() {
		String result = modul + " " + note + ";";
		return result;
	}
}