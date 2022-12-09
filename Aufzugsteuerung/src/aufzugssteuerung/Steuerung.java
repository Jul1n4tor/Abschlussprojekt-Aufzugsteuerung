package aufzugssteuerung;

import aufzugssteuerung.Aufzug;
import java.util.ArrayList;

public class Steuerung {

	private static Aufzug[] aufzugsListe = new Aufzug[50];

	public static void aufzugsGenerator() {
		if (aufzugsListe[0] == null) {

			int arrayindex = 0;

			for (int i = 0; i < 20; i++) {
				aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Personenaufzug, klein", 15, 1200, "Aufzugsmelodie");
				arrayindex++;
			}

			for (int i = 0; i < 10; i++) {
				aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Personenaufzug, groß", 30, 2400, "Aufzugsmelodie");
				arrayindex++;
			}

			for (int i = 0; i < 10; i++) {
				aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Lastenaufzug, klein", 0, 5000, "Quadratmeter-Zahl");
				arrayindex++;
			}

			for (int i = 0; i < 5; i++) {
				aufzugsListe[arrayindex] = new Aufzug(arrayindex, "Lastenaufzug, groß", 0, 10000, "Quadratmeter-Zahl");
				arrayindex++;
			}

			for (int i = 0; i < 5; i++) {
				aufzugsListe[arrayindex] = new Aufzug(arrayindex, "VIP-Aufzug", 5, 400, "Hoechstgeschwindigkeit");
				arrayindex++;
			}
		}
	}

	public static int getAufzugslisteGroesse() {
		return aufzugsListe.length - 1;
	}

	public static void setAufzugliste(Aufzug[] Liste) {
		aufzugsListe = Liste;
	}

	public static float groestmoeglicherAufzug(int Aufzugsart) {
		ArrayList<Aufzug> passendeAufzuege = new ArrayList<>();
		for (Aufzug aufzug : aufzugsListe) {
			if (Aufzugsart == 1) {
				if (aufzug.getAufzugsart().contains("Personenaufzug")) {
					passendeAufzuege.add(aufzug);
				}
			} else if (Aufzugsart == 2) {
				if (aufzug.getAufzugsart().contains("Lastenaufzug")) {
					passendeAufzuege.add(aufzug);
				}
			} else {
				if (aufzug.getAufzugsart().contains("VIP-Aufzug")) {
					passendeAufzuege.add(aufzug);
				}
			}
		}

		float zulassung = 0;
		if (Aufzugsart == 1 || Aufzugsart == 3) {
			for (Aufzug aufzug : passendeAufzuege) {
				if (aufzug.getPersonenzahl() > zulassung) {
					zulassung = aufzug.getPersonenzahl();
				}
			}
		} else {
			for (Aufzug aufzug : passendeAufzuege) {
				if (aufzug.getZulaesigesGesamtGewicht() > zulassung) {
					zulassung = aufzug.getZulaesigesGesamtGewicht();
				}
			}
		}
		return zulassung;
	}

	public static int passendeAufzugsnummerErmitteln(float Last, int Aufzugsart, int Stockwerk) {
		ArrayList<Aufzug> passendeAufzuege = new ArrayList<>();
		for (Aufzug aufzug : aufzugsListe) {
			if (Aufzugsart == 1) {
				if (aufzug.getAufzugsart().contains("Personenaufzug") && aufzug.getPersonenzahl() >= Last) {
					passendeAufzuege.add(aufzug);
				}
			} else if (Aufzugsart == 2) {
				if (aufzug.getAufzugsart().contains("Lastenaufzug") && aufzug.getZulaesigesGesamtGewicht() >= Last) {
					passendeAufzuege.add(aufzug);
				}
			} else {
				if (aufzug.getAufzugsart().contains("VIP-Aufzug") && aufzug.getPersonenzahl() >= Last) {
					passendeAufzuege.add(aufzug);
				}
			}
		}
		int Aufzugsnummer = -1;
		int Abstand = 102;

		for (Aufzug aufzug : passendeAufzuege) {
			int distanz = aufzug.getStockwerk() - Stockwerk;
			if (distanz < 0) {
				distanz *= -1;
			}
			if (distanz < Abstand) {
				Abstand = distanz;
				Aufzugsnummer = aufzug.getNummer();
			}
		}
		return Aufzugsnummer;
	}

	public static void fahren(int zielsstockwerk, float last, int Aufzugsnummer) {
		aufzugsListe[Aufzugsnummer].fahren(last, zielsstockwerk);
	}

	public static Aufzug getAufzug(int Aufzugsnummer) {
		return aufzugsListe[Aufzugsnummer];
	}

	public static Aufzug[] getAufzugliste() {
		return aufzugsListe;
	}
}
