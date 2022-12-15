package aufzugssteuerung;

import java.util.Scanner;

public class Main {
	static Scanner scannerIN = new Scanner(System.in);

	public static void main(String[] args) {
		Steuerung.setAufzugliste(Speicher.aufzugsdateiladen());
		Steuerung.aufzugsGenerator();
		int Auswahl = -1;
		while (Auswahl > 2 || Auswahl < 1) {
			System.out.println("Was möchten sie tun?");
			System.out.println("1: Aufzugsteuerung");
			System.out.println("2: Attribute ausgeben oder ändern");
			Auswahl = scannerIN.nextInt();
			if (Auswahl > 2 || Auswahl < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		if (Auswahl == 1) {
			Aufzugrufen();
		} else {
			Systemcheck();
		}
	}

	private static void Aufzugrufen() {
		int Ausgangsstockwerk = -1;
		int Aufzugsart = -1;
		float Last = -1;
		int Zielstockwerk = -1;

		while (Ausgangsstockwerk > 100 || Ausgangsstockwerk < 0) {
			System.out.println("In welchem Stockwerk befinden Sie sich?");
			Ausgangsstockwerk = scannerIN.nextInt();

			if (Ausgangsstockwerk > 100 || Ausgangsstockwerk < 0) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		while (Aufzugsart > 3 || Aufzugsart < 1) {
			System.out.println("Welcher Aufzug soll gerufen werden?");
			System.out.println("1: Personenaufzug");
			System.out.println("2: Lastenaufzug");
			System.out.println("3: VIP Aufzug");
			Aufzugsart = scannerIN.nextInt();

			if (Aufzugsart > 3 || Aufzugsart < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			} else if (Aufzugsart == 3) {
				System.out.println("Bitte VIP Passwot eingeben.");
				int Passwort = scannerIN.nextInt();
				if (Passwort != 1234) {
					System.out.println("Falsches Passwort!");
					Aufzugsart = -1;
				}
			}
		}
		float maximallast = Steuerung.groestmoeglicherAufzug(Aufzugsart);
		while (Last < 0 || Last > maximallast) {
			if (Aufzugsart == 1 || Aufzugsart == 3) {
				System.out.println("Wie viele Personen sollen transportiert werden?");
			} else {
				System.out.println("Wie viel Gewicht wollen sie transportieren (in Kg)?");
			}
			Last = scannerIN.nextFloat();
			if (Last > maximallast || Last < 0) {
				System.out.println("Kein Aufzug dieser Größe verfügbar");
			}
		}
		int Aufzugnummer = Steuerung.passendeAufzugsnummerErmitteln(Last, Aufzugsart, Ausgangsstockwerk);
		while (Zielstockwerk > 100 || Zielstockwerk < 0) {
			System.out.println("In welches Stockwerk soll der Aufzug fahren?");
			Zielstockwerk = scannerIN.nextInt();

			if (Zielstockwerk > 100 || Zielstockwerk < 0) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		Steuerung.fahren(Zielstockwerk, Last, Aufzugnummer);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		System.out.println("Sie befinden sich nun im Ziel Stockwerk.");
		Programmende();
	}

	private static void Systemcheck() {
		int Systemcheck = -1;
		while (Systemcheck > 2 || Systemcheck < 1) {
			System.out.println("Welche Aktion soll ausgeführt werden?");
			System.out.println("1: Ein Attribut ändern");
			System.out.println("2: Aufzugspositionen abfragen");
			Systemcheck = scannerIN.nextInt();

			if (Systemcheck > 2 || Systemcheck < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		if (Systemcheck == 1) {
			Attributaenderung();
		} else {
			Positionsabfrage();
		}
	}

	private static void Attributaenderung() {
		int Aufzug = -1;
		while (Aufzug < 0 || Aufzug > Steuerung.getAufzugslisteGroesse()) {
			System.out.println("Welchen Aufzug wollen sie bearbeiten?");
			Aufzug = scannerIN.nextInt();
			if (Aufzug < 0 || Aufzug > Steuerung.getAufzugslisteGroesse()) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		System.out.println("Aufzug " + String.valueOf(Aufzug) + " hat folgende Attribute:\nAufzugsart: "
				+ Steuerung.getAufzug(Aufzug).getAufzugsart() + "\nPersonenzahl: "
				+ String.valueOf(Steuerung.getAufzug(Aufzug).getPersonenzahl()) + "\nZulässiges Gesamtgewicht: "
				+ String.valueOf(Steuerung.getAufzug(Aufzug).getZulaesigesGesamtGewicht()) + "\nWeitere Eigenschaften: "
				+ Steuerung.getAufzug(Aufzug).getWeitereEigenschaften() + "\nStockwerk: "
				+ String.valueOf(Steuerung.getAufzug(Aufzug).getStockwerk()) + "\nLastenzähler: "
				+ String.valueOf(Steuerung.getAufzug(Aufzug).getLastzaehler()));
		int Attributauswahl = -1;
		while (Attributauswahl > 6 || Attributauswahl < 1) {
			System.out.println("Welches Attribut soll geändert werden?");
			System.out.println("1: Aufzugsart");
			System.out.println("2: Personenzahl");
			System.out.println("3: zusläsiges Gesamtgewicht");
			System.out.println("4: weitere Eigenschaften");
			System.out.println("5: Stockwerk");
			System.out.println("6: lastenzähler");
			Attributauswahl = scannerIN.nextInt();

			if (Attributauswahl > 6 || Attributauswahl < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		System.out.println("Welchen Wert soll das Attribut annehmen?");
		Aufzug temp;
		switch (Attributauswahl) {
		case 1:
			scannerIN.nextLine();
			temp = Steuerung.getAufzug(Aufzug);
			temp.setAufzugsart(scannerIN.nextLine());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		case 2:
			temp = Steuerung.getAufzug(Aufzug);
			temp.setPersonenzahl(scannerIN.nextInt());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		case 3:
			temp = Steuerung.getAufzug(Aufzug);
			temp.setZuslaesigesGesamtgewicht(scannerIN.nextFloat());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		case 4:
			scannerIN.nextLine();
			temp = Steuerung.getAufzug(Aufzug);
			temp.setWeitereEigenschaften(scannerIN.nextLine());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		case 5:
			temp = Steuerung.getAufzug(Aufzug);
			temp.setStockwerk(scannerIN.nextInt());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		case 6:
			temp = Steuerung.getAufzug(Aufzug);
			temp.setLastzaeler(scannerIN.nextFloat());
			Steuerung.setAufzug(Aufzug, temp);
			break;
		}
		System.out.println("Attribut wurde geändert.");
		Programmende();
	}

	private static void Positionsabfrage() {
		int Abfrage = -1;
		while (Abfrage > 2 || Abfrage < 1) {
			System.out.println("Welche Aktion soll ausgeführt werden?");
			System.out.println("1: Alle Aufzug Positionen ausgeben");
			System.out.println("2: Nach Atributen filtern");
			Abfrage = scannerIN.nextInt();

			if (Abfrage > 2 || Abfrage < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		if (Abfrage == 1) {
			System.out.println("");
			for (Aufzug aufzug : Steuerung.getAufzugliste()) {
				System.out.println("Aufzug " + String.valueOf(aufzug.getNummer()) + " Befindet sich in Stockwerk "
						+ String.valueOf(aufzug.getStockwerk()));
			}
		} else {
			int Attributauswahl = -1;
			while (Attributauswahl > 6 || Attributauswahl < 1) {
				System.out.println("Nach welchem Attribut soll gefiltert werden");
				System.out.println("1: Aufzugsart");
				System.out.println("2: Personenzahl");
				System.out.println("3: zusläsiges Gesamtgewicht");
				System.out.println("4: weitere Eigenschaften");
				System.out.println("5: Stockwerk");
				System.out.println("6: lastenzähler");
				Attributauswahl = scannerIN.nextInt();

				if (Attributauswahl > 6 || Attributauswahl < 1) {
					System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
				}
			}
			System.out.println("Welchen Wert soll das Attribut haben?");
			switch (Attributauswahl) {
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
					if (aufzug.getZulaesigesGesamtGewicht() == wert3) {
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
		Programmende();
	}

	private static void Programmende() {
		int Auswahl = -1;
		while (Auswahl > 2 || Auswahl < 1) {
			System.out.println("Wollen Sie das Programm beenden?");
			System.out.println("1: Ja");
			System.out.println("2: Nein");
			Auswahl = scannerIN.nextInt();
			if (Auswahl > 2 || Auswahl < 1) {
				System.out.println("SIE VOLLIDIOT GEHEN SIE SICH EIN HOBBY SUCHEN!!!");
			}
		}
		if (Auswahl == 2) {
			Speicher.AlsDateiSpeichern(Steuerung.getAufzugliste());
			main(null);
		} else {
			Speicher.AlsDateiSpeichern(Steuerung.getAufzugliste());
		}
	}

}
