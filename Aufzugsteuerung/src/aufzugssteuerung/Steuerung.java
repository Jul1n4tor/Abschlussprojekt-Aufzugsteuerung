package aufzugssteuerung;

import aufzugssteuerung.Aufzug;
import java.util.ArrayList;

/**
 * In der "Steuerungs"-Klasse wird der Arrayindex generiert in dem alle Aufüge stehen.
 * Dazu wird diese Klasse dafür verwendent, dass bei der Auswahl einen Aufzugs immer der passende
 * und nächstmögliche Aufzug ausgewählt wird.
 * Desweiteren wird dem Aufzug hier beigebracht wie er sich durch die Stockwerke bewegen soll.
 * 
 * @author Cedric Beyer 
 *
 */
public class Steuerung {

	/**
	 * Hier wird ein Neues Array erstllt in dem sich alle Aufzüge befinden und abgerufen werden können.
	 */
	private static Aufzug[] aufzugsListe = new Aufzug[50];

	/**
	 * Generiert ein Array mit allen exestierenden Aufzügen und den dazugehörigen Atributen. 
	 * 
	 */
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

	/**
	 * Gibt die größe der Aufzugs Arrys aus.
	 * 
	 * @return Länge der Aufzugliste wird ausgegeben.
	 */
	public static int getAufzugslisteGroesse() {
		return aufzugsListe.length - 1;
	}

	/**
	 * Liste aller Aufzüge wird abgespeichert.
	 * 
	 * @param Liste wird als neues Atribut verwändet.
	 */
	public static void setAufzugliste(Aufzug[] Liste) {
		aufzugsListe = Liste;
	}

	/**
	 * Der bestmöglichst passende Aufzug wird gerufen. In den jeder und alles hinein passt.
	 * 
	 * @param Aufzugsart die Art welcher Aufzug gerufen wird. Sei es Peronen oder LastenAufzug.
	 * 
	 * @return zulassung wenn der Passende Aufzug gefunden wurde.
	 */
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

	/**
	 * Der Aufzug der sich am nächsten am eigenen Stockwerk befindet kommt angefahren.
	 * 
	 * @param Last das Gewicht-/Personenanzahl die transportiert werden soll.
	 * @param Aufzugsart die Art des Aufzug der gerufen werden soll.
	 * @param Stockwerk das Sockwerk auf dem man sich befindet.
	 * 
	 * @return Aufzugsnummer wenn der am nächsten befindliche Aufzug gefunden wurde.
	 */
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

	/**
	 * Der Aufzug bewegt sich vom Startstockwerk ins Zielstockwerk.
	 * 
	 * @param zielsstockwerk das Stockwerk wo man wieder aussteigen möchte.
	 * @param last die anzhal Personen-/Gewicht die transportiert werden sollen.
	 * @param Aufzugsnummer der Aufzug der sich bewegen soll.
	 */
	public static void fahren(int zielsstockwerk, float last, int Aufzugsnummer) {
		aufzugsListe[Aufzugsnummer].fahren(last, zielsstockwerk);
	}

	/**
	 * Aus der Aufzugsliste wird die Aufzugsnummer eines Aufzuges abgerufen.
	 * 
	 * @param Aufzugsnummer die Nummer die der Aufzug automatisch erhalten hat.
	 * 
	 * @return gibt die Liste aus mit der Aufzugsnummer. 
	 */
	public static Aufzug getAufzug(int Aufzugsnummer) {
		return aufzugsListe[Aufzugsnummer];
	}

	/**
	 * Die komplete Aufzugsliste wird Ausgegeben.
	 * 
	 * @return Aufzugsliste kann abgerufen werden.
	 */
	public static Aufzug[] getAufzugliste() {
		return aufzugsListe;
	}
	
	/**
	 * Jeder Aufzug bekommt eine Aufzugsnummer zugeteilt.
	 * 
	 * @param Aufzugsnummer die Nummer des entsprechenden Aufzuges.
	 * @param aufzug der Aufzug der abgerufen wird.
	 */
	public static void setAufzug(int Aufzugsnummer, Aufzug aufzug) {
		aufzugsListe[Aufzugsnummer] = aufzug; 
	}
}
