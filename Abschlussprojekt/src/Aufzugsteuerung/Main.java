package Aufzugsteuerung;

import java.util.Scanner;

class Hauptprogramm {
	Scanner scannerE = new Scanner(System.in);

	public int Eingabe() {
		System.out.println("Was möchten sie tun?");
		System.out.println("1 Aufzug");
		System.out.println("2 Attribute");
		return scannerE.nextInt();

	}
}

public class Main {
	static Scanner scannerIN = new Scanner(System.in);

	public static void main(String[] args) {
		Hauptprogramm UserIn = new Hauptprogramm();

		int in = 0;
		while (in == 0) {
			in = UserIn.Eingabe();
		}
		Steuerung(in);
		
	}

	// Steuerung -> Programm-Auswahl Abfrage
	static void Steuerung(int Ein) {

		if (Ein == 1) {
			System.out.println("Welchen Aufzug?");
			AufArt(scannerIN.nextInt());

		}
		if (Ein == 2) {
			System.out.println("Attributen-Steuerung Ausgewählt");

		} else {
			System.out.println("leider falsch bitte neu");
			Steuerung(scannerIN.nextInt());

		}
	}

	// AufArt -> Welcher Aufzug?
	static void AufArt(int in1) {
		if (in1 == 1) {
			PS();
			PSA(scannerIN.nextInt());
			SWST(scannerIN.nextInt());
			Ende();

		}
		if (in1 == 2) {
			LS();
			LSA(scannerIN.nextInt());
			SWST(scannerIN.nextInt());
			Ende();

		}
		if (in1 == 3) {
			VS();
			VSP(scannerIN.nextInt());
			VSA(scannerIN.nextInt());
			SWST(scannerIN.nextInt());
			Ende();

		} else {
			System.out.println("leider falsch bitte neu");
			AufArt(scannerIN.nextInt());
		}

	}

	// PS -> Personen Aufzug abfrage.
	static void PS() {
		System.out.println("Personenaufzug. Wieviele Personen?");

	}

	// PSA -> Personen Anzahl
	static void PSA(int Anz) {
		if (Anz <= 30 && Anz > 15) {
			System.out.println(Anz + " Personen ausgewählt. Ein großer Personenaufzug wird sie fahren.");
			System.out.println("Von Wo soll der Aufzug losfahren?");

		} else {
			if (Anz <= 15 && Anz > 0) {
				System.out.println(Anz + " Personen ausgewählt. Ein kleiner Personenaufzug wird sie fahren.");
				System.out.println("Von Wo soll der Aufzug losfahren?");

			} else {
				System.out.println("leider falsch bitte neu");
				PSA(scannerIN.nextInt());

			}
		}
	}

	// LS -> Lasten Aufzug abfrage.
	static void LS() {
		System.out.println("Lastenaufzug. Wieviel KG Last?");

	}

	// LSA -> Lasten Menge
	static void LSA(int Anz) {
		if (Anz <= 10000 && Anz > 5000) {
			System.out.println(Anz + " KG ausgewählt. Ein großer Lastenaufzug wird sie fahren.");
			System.out.println("Von Wo soll der Aufzug losfahren?");

		}
		if (Anz <= 5000 && Anz > 0) {
			System.out.println(Anz + " KG ausgewählt. Ein kleiner Lastenaufzug wird sie fahren.");
			System.out.println("Von Wo soll der Aufzug losfahren?");

		} else {
			System.out.println("leider falsch bitte neu");
			LSA(scannerIN.nextInt());

		}
	}

	// VS -> VIP-Aufzug abfrage.
	static void VS() {
		System.out.println("VIP-Aufzug. Bitte geben sie nun das Passwort ein: (Tipp: 1234)");

	}

	// VSP -> Passwort abfrage.
	static void VSP(int PW) {
		if (PW == 1234) {
			System.out.println("Passwort Korrekt! Wie viele Personen fahren in diesem Aufzug?");

		} else {
			System.out.println("leider falsch bitte neu");
			VSP(scannerIN.nextInt());

		}
	}

	// VSA -> VIP-Aufzug Personen Anzahl
	static void VSA(int Anz) {
		if (Anz <= 5 && Anz > 0) {
			System.out.println(Anz + " Personen wurden ausgewählt.");
			System.out.println("Von Wo soll der Aufzug losfahren?");

		} else {
			System.out.println("leider falsch bitte neu");
			VSA(scannerIN.nextInt());

		}
	}

	// SWST -> Stockwerk Start
	static void SWST(int Start) {
		if (Start < 100 && Start >= 0) {
			System.out.println(
					"Der Aufzug wird vom " + Start + ". Losfahren. In welches Stockwerk soll die Fahrt gehen?");
			SWSP(Start, scannerIN.nextInt());

		} else {
			System.out.println("Dieses Stockwerk existiert nicht. Bitte erneut eingeben!");
			SWST(scannerIN.nextInt());

		}
	}

	// SWSP -> Stockwerk Stopp
	static void SWSP(int Start, int Stopp) {
		if (Stopp < 100 && Stopp >= 0) {
			if (Start == Stopp) {
				System.out.println("Start und Stopp sind gleich!");
				SWSP(Start, scannerIN.nextInt());

			} else {

				System.out.println(
						"Der Aufzug wird vom " + Start + ". Stock bis zum " + Stopp + ". Stock Fahren. Gute Fahrt!");
			}

		} else {
			System.out.println("Dieses Stockwerk existiert nicht. Bitte erneut eingeben!");
			SWSP(Start, scannerIN.nextInt());

		}
	}

	// Ende -> Abschluss Abfrage
	static void Ende() {
		System.out.println("-----");
		System.out.println("1: Zurück zu Programm Auswahl " + "2: Programm beenden");
		System.out.println("-----");
		int A = scannerIN.nextInt();
		if (A == 1) {
			System.out.println("Was möchten sie tun?");
			System.out.println("1 Aufzug");
			System.out.println("2 Attribute");
			Steuerung(scannerIN.nextInt());
		}
		if (A == 2) {
			System.exit(0);
		} else {
			System.out.println("Das ist keine Auswahl.");
			Ende();
		}
	}
	/*
	 * Log Funktion mit case/if statements. Checkt die Eingaben
	 * 
	 * schreibeInLog (int AufzugArt, int PersAnz, int StartStock, int StoppStock) {
	 * Case 1 : PersonenAufzug }
	 * 
	 */
}
