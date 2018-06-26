 // Ermittlung des Mittelwertes ueber alle Noten aller Studenten
	double mittelwert (Student[] studenten) {
			
		double summe=0;
		int count=0;
		
		for(int i=0; i < studenten.length; i++) { // Schleife ueber die Anzahl der eingetragenen Studenten
			if(studenten[i].leistungen != null) { // falls mindestens eine Pruefungsleistung eingetragen, dann...
				for (int j=0; j < studenten[i].leistungen.length; j++) {
                // ...Schleife ueber die Anzahl der eingetragenen Pruefungsleistungen des jeweiligen Studenten
						summe=summe+studenten[i].leistungen[j].note; // Noten aufsummieren
						count++; // count = Anzahl der aufsummierten Noten
						}
				}
			}
			
		if (count > 0)				// Wenn mindestens eine Note, dann...
			return (summe/count);	// ...Rueckgabe des arithm. Mittelwertes
		else return 0;				// ansonsten wird 0 zurueckgegeben
	}
