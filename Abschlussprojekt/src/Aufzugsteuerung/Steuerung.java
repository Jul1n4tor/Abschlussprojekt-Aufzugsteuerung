package aufzugssteuerung;
import aufzugssteuerung.Aufzug;

public class Steuerung {

	private Aufzug[] aufzugsListe = new Aufzug[44];  
	
	public void aufzugsGenerator( ) {
		int arrayindex = 0;
		
		for(int i=0; i<20; i++) {
			aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Personenaufzug, klein", 15, 1200, "Aufzugsmelodie");
			arrayindex++;
		}
		
		for(int i=0; i<10; i++) {
			aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Personenaufzug, groß", 30, 2400, "Aufzugsmelodie");
			arrayindex++;
		}
		
		for(int i=0; i<10; i++) {
			aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Lastenaufzug, klein", 0, 5000, "Quadratmeter-Zahl");
			arrayindex++;
		}
		
		for(int i=0; i<5; i++) {
			aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Lastenaufzug, groß", 0, 10000, "Quadratmeter-Zahl");
			arrayindex++;
		}
		
		for(int i=0; i<5; i++) {
			aufzugsListe[arrayindex] = new Aufzug(arrayindex, "VIP-Aufzug", 5, 400, "Hoechstgeschwindigkeit");
			arrayindex++;
		}
	}
	
	
	
}
