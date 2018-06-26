package soapServer;

public class Leistung {
	String modul;
	public String getModul() {
		return modul;
	}

	public void setModul(String modul) {
		this.modul = modul;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	double note;
	
	Leistung()
	{		
		modul = "nicht initialisiert";
		note  = 6.0;
	}
}
