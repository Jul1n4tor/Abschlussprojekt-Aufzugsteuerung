package aufzugssteuerung;

import java.util.ArrayList;

/**
 * In der "Steuerung"-Klasse wird der Arrayindex generiert in dem alle Aufüge
 * stehen. Dazu wird diese Klasse dafür verwendent, dass bei der Auswahl eines
 * Aufzugs immer der passende und nächstmögliche Aufzug ausgewählt wird.
 * Desweiteren wird dem Aufzug hier beigebracht wie er sich durch die Stockwerke
 * bewegen soll.
 * 
 * @author Cedric Beyer
 */

public class Steuerung {

	/**
	 * Hier wird ein neues Array erstellt in dem sich alle Aufzüge befinden und
	 * abgerufen werden können.
	 */

	private static Aufzug[] aufzugsListe = new Aufzug[50];

	/**
	 * Generiert ein Array mit allen existierenden Aufzügen und den dazugehörigen
	 * Attributen.
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
	 * Gibt die größe der Arraylist der Aufzüge aus.
	 * 
	 * @return Länge der Aufzugliste wird ausgegeben.
	 */

	public static int getAufzugslisteGroesse() {
		return aufzugsListe.length - 1;
	}

	/**
	 * Liste aller Aufzüge wird abgespeichert.
	 * 
	 * @param liste wird als neues Attribut verwendet.
	 */

	public static void setAufzugliste(Aufzug[] liste) {
		aufzugsListe = liste;
	}

	/**
	 * Der nächstmögliche, passende Aufzug wird gerufen. Hier soll jeder und alles
	 * hinein passt.
	 * 
	 * @param aufzugsart ; die Art des Aufzugs der gerufen wird. Kann Personen- oder
	 *                   Lastenaufzug sein.
	 * 
	 * @return zulassung wenn der Passende Aufzug gefunden wurde.
	 */

	public static float groestmoeglicherAufzug(int aufzugsart) {
		ArrayList<Aufzug> passendeAufzuege = new ArrayList<>();
		for (Aufzug aufzug : aufzugsListe) {
			if (aufzugsart == 1) {
				if (aufzug.getAufzugsart().contains("Personenaufzug")) {
					passendeAufzuege.add(aufzug);
				}
			} else if (aufzugsart == 2) {
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
		if (aufzugsart == 1 || aufzugsart == 3) {
			for (Aufzug aufzug : passendeAufzuege) {
				if (aufzug.getPersonenzahl() > zulassung) {
					zulassung = aufzug.getPersonenzahl();
				}
			}
		} else {
			for (Aufzug aufzug : passendeAufzuege) {
				if (aufzug.getZulaessigesGesamtgewicht() > zulassung) {
					zulassung = aufzug.getZulaessigesGesamtgewicht();
				}
			}
		}
		return zulassung;
	}

	/**
	 * Der Aufzug der sich am nächsten zum eigenen Stockwerk befindet soll
	 * angefahren kommen.
	 * 
	 * @param last       ; das Gewicht-/ die Personenanzahl die transportiert werden
	 *                   soll.
	 * @param aufzugsart ; die Art des Aufzug der gerufen werden soll.
	 * @param stockwerk  ; das Stockwerk auf dem man sich befindet.
	 * 
	 * @return Aufzugsnummer wenn der am nächsten befindliche Aufzug gefunden wurde.
	 */

	public static int passendeAufzugsnummerErmitteln(float last, int aufzugsart, int stockwerk) {
		ArrayList<Aufzug> passendeAufzuege = new ArrayList<>();
		for (Aufzug aufzug : aufzugsListe) {
			if (aufzugsart == 1) {
				if (aufzug.getAufzugsart().contains("Personenaufzug") && aufzug.getPersonenzahl() >= last) {
					passendeAufzuege.add(aufzug);
				}
			} else if (aufzugsart == 2) {
				if (aufzug.getAufzugsart().contains("Lastenaufzug") && aufzug.getZulaessigesGesamtgewicht() >= last) {
					passendeAufzuege.add(aufzug);
				}
			} else {
				if (aufzug.getAufzugsart().contains("VIP-Aufzug") && aufzug.getPersonenzahl() >= last) {
					passendeAufzuege.add(aufzug);
				}
			}
		}
		int aufzugsnummer = -1;
		int abstand = 102;

		for (Aufzug aufzug : passendeAufzuege) {
			int distanz = aufzug.getStockwerk() - stockwerk;
			if (distanz < 0) {
				distanz *= -1;
			}
			if (distanz < abstand) {
				abstand = distanz;
				aufzugsnummer = aufzug.getNummer();
			}
		}
		return aufzugsnummer;
	}

	/**
	 * Der Aufzug bewegt sich vom Startstockwerk ins Zielstockwerk.
	 * 
	 * @param zielsstockwerk ; das Stockwerk aus dem man aussteigen möchte.
	 * @param last           ; die Anzahl der Personen/Gewichte die transportiert
	 *                       werden sollen.
	 * @param aufzugsnummer  ; der Aufzug der sich bewegen soll.
	 */

	public static void fahren(int zielsstockwerk, float last, int aufzugsnummer) {
		aufzugsListe[aufzugsnummer].fahren(last, zielsstockwerk);
	}

	/**
	 * Aus der Aufzugsliste wird die Aufzugsnummer eines Aufzuges abgerufen.
	 * 
	 * @param Aufzugsnummer ; die Nummer die der Aufzug automatisch erhalten hat.
	 * 
	 * @return gibt die Liste aus mit der Aufzugsnummer.
	 */

	public static Aufzug getAufzug(int Aufzugsnummer) {
		return aufzugsListe[Aufzugsnummer];
	}

	/**
	 * Die komplette Aufzugsliste wird ausgegeben.
	 * 
	 * @return Aufzugsliste kann abgerufen werden.
	 */

	public static Aufzug[] getAufzugliste() {
		return aufzugsListe;
	}

	/**
	 * Jeder Aufzug bekommt eine Aufzugsnummer zugeteilt.
	 * 
	 * @param aufzugsNummer ; die Nummer des entsprechenden Aufzuges.
	 * @param aufzug        ; der Aufzug der abgerufen wird.
	 */

	public static void setAufzug(int aufzugsNummer, Aufzug aufzug) {
		aufzugsListe[aufzugsNummer] = aufzug;
	}
}