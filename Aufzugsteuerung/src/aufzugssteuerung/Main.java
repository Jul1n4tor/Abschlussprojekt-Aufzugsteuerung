package aufzugssteuerung;

import java.util.Scanner;

/**
 * Diese "Main"-Klasse ist der Dreh und Angelpunkt des Programms. Hier wird das
 * Interface für die Steuerung generiert und verarbeitet. Die Methoden steuern
 * dann (bei korrekter Eingabe) die weiteren Klassen und deren Methoden an. Das
 * macht das Projekt übersichtlicher und einfacher zu steuern.
 * 
 * Die Klasse arbeitet hauptsächlich mit >scannerIN.nextInt< was die Eingaben
 * durch den Benutzer repräsentieren. Diese Eingaben sind darauf ausgerichtet,
 * immer Integer zu sein. Das bedeutet, dass das Programm in der Console auch
 * nur mit Int-Eingaben funktioniert. Eine direkte Texteingabe ist nicht möglich
 * und bringt das Programm zum Absturz.
 * 
 * @author Cedric Beyer und Julius Marquardt
 */

public class Main {
	static Scanner scannerIN = new Scanner(System.in);

	/**
	 * Die Main-Methode und der Eingang in das Programm. Hier wird der Benutzer nach
	 * seiner Wahl des Programms gefragt.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Steuerung.setAufzugliste(Speicher.aufzugsdateiladen());
		Steuerung.aufzugsGenerator();
		int auswahl = -1;
		while (auswahl > 2 || auswahl < 1) {
			System.out.println("Was möchten Sie tun?");
			System.out.println("1: Aufzugsteuerung");
			System.out.println("2: Attribute ausgeben oder ändern");
			auswahl = scannerIN.nextInt();
			if (auswahl > 2 || auswahl < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		if (auswahl == 1) {
			Aufzugrufen();
		} else {
			Systemcheck();
		}
	}

	/**
	 * Die gesammte Steuerung der Aufzüge. Hier wir nacheinander der Benutzer nach
	 * Start-Stockwerk, der Wahl des Aufzugs und zuletzt dem Ziel-Stockwerk gefragt.
	 * Durch die While-Schleifen bleiben die Abfragen so lange offen, bis eine
	 * korrekte Eingabe getätigt wurde.
	 */

	private static void Aufzugrufen() {
		int ausgangsstockwerk = -1;
		int aufzugsart = -1;
		float last = -1;
		int zielstockwerk = -1;

		while (ausgangsstockwerk > 100 || ausgangsstockwerk < 0) {
			System.out.println("In welchem Stockwerk befinden Sie sich?");
			ausgangsstockwerk = scannerIN.nextInt();

			if (ausgangsstockwerk > 100 || ausgangsstockwerk < 0) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		while (aufzugsart > 3 || aufzugsart < 1) {
			System.out.println("Welcher Aufzug soll gerufen werden?");
			System.out.println("1: Personenaufzug");
			System.out.println("2: Lastenaufzug");
			System.out.println("3: VIP Aufzug");
			aufzugsart = scannerIN.nextInt();

			if (aufzugsart > 3 || aufzugsart < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			} else if (aufzugsart == 3) {
				System.out.println("Bitte VIP Passwot eingeben (Hinweis: 1234).");
				int passwort = scannerIN.nextInt();
				if (passwort != 1234) {
					System.out.println("Falsches Passwort!");
					aufzugsart = -1;
				}
			}
		}
		float maximallast = Steuerung.groestmoeglicherAufzug(aufzugsart);
		while (last < 0 || last > maximallast) {
			if (aufzugsart == 1 || aufzugsart == 3) {
				System.out.println("Wie viele Personen sollen transportiert werden?");
			} else {
				System.out.println("Wie viel Gewicht wollen sie transportieren (in Kg)?");
			}
			last = scannerIN.nextFloat();
			if (last > maximallast || last < 0) {
				System.out.println("Kein Aufzug dieser Größe verfügbar!");
			}
		}
		int aufzugnummer = Steuerung.passendeAufzugsnummerErmitteln(last, aufzugsart, ausgangsstockwerk);
		while (zielstockwerk > 100 || zielstockwerk < 0) {
			System.out.println("In welches Stockwerk soll der Aufzug fahren?");
			zielstockwerk = scannerIN.nextInt();

			if (zielstockwerk > 100 || zielstockwerk < 0) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		Steuerung.fahren(zielstockwerk, last, aufzugnummer);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.println("Sie befinden sich nun im Ziel Stockwerk.");
		programmende();
	}

	/**
	 * Steuerung der Attribute und der Ausgabe der Aufzugspositionen. Hier kann der
	 * Benutzer die Attribute der Aufzüge entweder einzeln oder im gesammten
	 * Ausgeben lassen und ändern. Dazu kann hier auch eine Liste aller Aufzüge mit
	 * deren Position oder Attribute ausgegeben werden.
	 */

	private static void Systemcheck() {
		int systemcheck = -1;
		while (systemcheck > 2 || systemcheck < 1) {
			System.out.println("Welche Aktion soll ausgeführt werden?");
			System.out.println("1: Ein Attribut ändern");
			System.out.println("2: Aufzugspositionen abfragen");
			systemcheck = scannerIN.nextInt();

			if (systemcheck > 2 || systemcheck < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		if (systemcheck == 1) {
			Attributaenderung();
		} else {
			Positionsabfrage();
		}
	}

	private static void Attributaenderung() {
		int aufzug = -1;
		while (aufzug < 0 || aufzug > Steuerung.getAufzugslisteGroesse()) {
			System.out.println("Welchen Aufzug wollen sie bearbeiten?");
			aufzug = scannerIN.nextInt();
			if (aufzug < 0 || aufzug > Steuerung.getAufzugslisteGroesse()) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		System.out.println("Aufzug " + String.valueOf(aufzug) + " hat folgende Attribute:\nAufzugsart: "
				+ Steuerung.getAufzug(aufzug).getAufzugsart() + "\nPersonenzahl: "
				+ String.valueOf(Steuerung.getAufzug(aufzug).getPersonenzahl()) + "\nZulässiges Gesamtgewicht: "
				+ String.valueOf(Steuerung.getAufzug(aufzug).getZulaessigesGesamtgewicht())
				+ "\nWeitere Eigenschaften: " + Steuerung.getAufzug(aufzug).getWeitereEigenschaften() + "\nStockwerk: "
				+ String.valueOf(Steuerung.getAufzug(aufzug).getStockwerk()) + "\nLastenzähler: "
				+ String.valueOf(Steuerung.getAufzug(aufzug).getLastzaehler()));
		int attributauswahl = -1;
		while (attributauswahl > 6 || attributauswahl < 1) {
			System.out.println("Welches Attribut soll geändert werden?");
			System.out.println("1: Aufzugsart");
			System.out.println("2: Personenzahl");
			System.out.println("3: Zulässiges Gesamtgewicht");
			System.out.println("4: Weitere Eigenschaften");
			System.out.println("5: Stockwerk");
			System.out.println("6: Lastenzähler");
			attributauswahl = scannerIN.nextInt();

			if (attributauswahl > 6 || attributauswahl < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		System.out.println("Welchen Wert soll das Attribut annehmen?");
		Aufzug temp;
		switch (attributauswahl) {
		case 1:
			scannerIN.nextLine();
			temp = Steuerung.getAufzug(aufzug);
			temp.setAufzugsart(scannerIN.nextLine());
			Steuerung.setAufzug(aufzug, temp);
			break;
		case 2:
			temp = Steuerung.getAufzug(aufzug);
			temp.setPersonenzahl(scannerIN.nextInt());
			Steuerung.setAufzug(aufzug, temp);
			break;
		case 3:
			temp = Steuerung.getAufzug(aufzug);
			temp.setZulaessigesGesamtgewicht(scannerIN.nextFloat());
			Steuerung.setAufzug(aufzug, temp);
			break;
		case 4:
			scannerIN.nextLine();
			temp = Steuerung.getAufzug(aufzug);
			temp.setWeitereEigenschaften(scannerIN.nextLine());
			Steuerung.setAufzug(aufzug, temp);
			break;
		case 5:
			temp = Steuerung.getAufzug(aufzug);
			temp.setStockwerk(scannerIN.nextInt());
			Steuerung.setAufzug(aufzug, temp);
			break;
		case 6:
			temp = Steuerung.getAufzug(aufzug);
			temp.setLastzaeler(scannerIN.nextFloat());
			Steuerung.setAufzug(aufzug, temp);
			break;
		}
		System.out.println("Attribut wurde geändert.");
		programmende();
	}

	/**
	 * Filterung der Aufzüge. Hier ist es dem Benutzer des Programms möglich,
	 * entweder die Positionen aller Aufzüge auszugeben oder nach einem bestimmten
	 * Attribut zu filtern.
	 */

	private static void Positionsabfrage() {
		int abfrage = -1;
		while (abfrage > 2 || abfrage < 1) {
			System.out.println("Welche Aktion soll ausgeführt werden?");
			System.out.println("1: Alle Aufzug Positionen ausgeben");
			System.out.println("2: Nach Atributen filtern");
			abfrage = scannerIN.nextInt();

			if (abfrage > 2 || abfrage < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		if (abfrage == 1) {
			System.out.println("");
			for (Aufzug aufzug : Steuerung.getAufzugliste()) {
				System.out.println("Aufzug " + String.valueOf(aufzug.getNummer()) + " Befindet sich in Stockwerk "
						+ String.valueOf(aufzug.getStockwerk()));
			}
		} else {
			int attributAuswahl = -1;
			while (attributAuswahl > 6 || attributAuswahl < 1) {
				System.out.println("Nach welchem Attribut soll gefiltert werden?");
				System.out.println("1: Aufzugsart");
				System.out.println("2: Personenzahl");
				System.out.println("3: Zulässiges Gesamtgewicht");
				System.out.println("4: Weitere Eigenschaften");
				System.out.println("5: Stockwerk");
				System.out.println("6: Lastenzähler");
				attributAuswahl = scannerIN.nextInt();

				if (attributAuswahl > 6 || attributAuswahl < 1) {
					System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
				}
			}
			System.out.println("Welchen Wert soll das Attribut haben?");
			switch (attributAuswahl) {
			case 1:
				String wert1 = scannerIN.nextLine();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getAufzugsart().equals(wert1)) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			case 2:
				int wert2 = scannerIN.nextInt();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getPersonenzahl() == wert2) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			case 3:
				float wert3 = scannerIN.nextFloat();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getZulaessigesGesamtgewicht() == wert3) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			case 4:
				String wert4 = scannerIN.nextLine();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getWeitereEigenschaften().equals(wert4)) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			case 5:
				int wert5 = scannerIN.nextInt();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getStockwerk() == wert5) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			case 6:
				float wert6 = scannerIN.nextFloat();
				for (Aufzug aufzug : Steuerung.getAufzugliste()) {
					if (aufzug.getLastzaehler() == wert6) {
						System.out.println("Aufzug " + String.valueOf(aufzug.getNummer())
								+ " Befindet sich in Stockwerk " + String.valueOf(aufzug.getStockwerk()));
					}
				}
				break;
			}
		}
		programmende();
	}

	/**
	 * Das Programmende. Zu dieser Abfrage wird der Benutzer zum Schluss seiner
	 * Eingaben hingeleitet. Hier kann das Programm entweder von vorne gestartet
	 * werden oder beendet werden. Dazu werden alle Änderung bei der Schließung des
	 * Programms abgespeichert und übernommen.
	 */

	private static void programmende() {
		int auswahl = -1;
		while (auswahl > 2 || auswahl < 1) {
			System.out.println("Wollen Sie das Programm beenden?");
			System.out.println("1: Ja");
			System.out.println("2: Nein");
			auswahl = scannerIN.nextInt();
			if (auswahl > 2 || auswahl < 1) {
				System.out.println("Die Eingabe war leider Falsch. Versuchen sie es erneut.");
			}
		}
		if (auswahl == 2) {
			Speicher.alsDateiSpeichern(Steuerung.getAufzugliste());
			main(null);
		} else {
			Speicher.alsDateiSpeichern(Steuerung.getAufzugliste());
		}
	}
}
