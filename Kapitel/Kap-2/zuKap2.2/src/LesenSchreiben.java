import java.io.IOException;

// Interface, das das Lesen und Schreiben der Datensaetze kapselt
// Dateinamen/Netzwerkadressen werden im Konstruktur der Klasse behandelt, 
// die instantiiert wird. 
public interface LesenSchreiben {
	void schreibeDatei(Student[] studenten) throws IOException;
    Student [] leseDatei() 	throws IOException;
}
